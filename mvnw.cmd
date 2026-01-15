@echo off
REM Lightweight wrapper: invokes the PowerShell wrapper to ensure Maven is available
setlocal
set SCRIPT_DIR=%~dp0
powershell -NoProfile -ExecutionPolicy Bypass -File "%SCRIPT_DIR%mvnw.ps1" %*
exit /b %ERRORLEVEL%
