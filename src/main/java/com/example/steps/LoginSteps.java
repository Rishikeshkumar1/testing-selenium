package com.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.*;

import org.openqa.selenium.WebDriver;
import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver.navigate().to("https://example.com/login");
    }

    @When("User enters {string} credentials")
    public void user_enters_valid_credentials(String userName) {
        loginPage.login("testuser", "testpass123");
    }

    @Then("User enters valid credentials")
    public void user_should_see_dashboard(DataTable dt) {
    	List<Map<String, String>> a = dt.asMaps(null, null);
    	
    	for(Map<String, String> b : a) {
    		String username = b.get("username");
    		String pass = b.get("pass");
    		
    		
    	}
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("dashboard");
    }
}
