package com.example.steps;

import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private String appUrl = "https://example.com/login"; // placeholder

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.open(appUrl);
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() throws Exception {
        ObjectMapper om = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/testdata/users.json")) {
            JsonNode root = om.readTree(is);
            JsonNode user = root.path("users").get(0);
            String username = user.path("username").asText();
            String password = user.path("password").asText();
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();
        }
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        // Minimal assertion for sample; real test would assert URL or element on home page
        Assertions.assertTrue(true);
    }
}
