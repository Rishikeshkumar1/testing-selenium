param(
    [Parameter(ValueFromRemainingArguments=$true)]
    [string[]]$Args
)

$root = Split-Path -Parent $MyInvocation.MyCommand.Definition
$mvnDir = Join-Path $root ".mvn\apache-maven"
$mvnCmd = Join-Path $mvnDir "bin\mvn.cmd"

if (-not (Test-Path $mvnCmd)) {
    Write-Host "Maven not found in project wrapper. Downloading Maven..."
    $wrapperDir = Join-Path $root ".mvn"
    if (-not (Test-Path $wrapperDir)) { New-Item -ItemType Directory -Path $wrapperDir | Out-Null }

    $mavenVersion = '3.9.4'
    $zipName = "apache-maven-$mavenVersion-bin.zip"
    $downloadUrl = "https://archive.apache.org/dist/maven/maven-3/$mavenVersion/binaries/$zipName"
    $zipPath = Join-Path $wrapperDir $zipName

    Write-Host "Downloading $downloadUrl"
    Invoke-WebRequest -Uri $downloadUrl -OutFile $zipPath -UseBasicParsing

    Write-Host "Extracting $zipPath"
    Expand-Archive -LiteralPath $zipPath -DestinationPath $wrapperDir -Force

    $extractedFolder = Join-Path $wrapperDir "apache-maven-$mavenVersion"
    if (Test-Path $extractedFolder) {
        if (Test-Path $mvnDir) { Remove-Item -Recurse -Force $mvnDir }
        Move-Item -Path $extractedFolder -Destination $mvnDir
    }

    Remove-Item $zipPath -Force
    Write-Host "Maven $mavenVersion installed to $mvnDir"
}

# Run the mvn command with forwarded arguments
& "$mvnCmd" @Args
exit $LASTEXITCODE
