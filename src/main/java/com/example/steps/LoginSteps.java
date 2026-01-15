package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;
import com.example.config.Config;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver.navigate().to(Config.getLoginPageUrl());
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.login("testuser", "testpass123");
    }

    @Then("User should see dashboard")
    public void user_should_see_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("dashboard");
    }
}
