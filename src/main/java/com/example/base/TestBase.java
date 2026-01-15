package com.example.base;

import org.openqa.selenium.WebDriver;
import com.example.utils.DriverFactory;

public class TestBase {
    protected WebDriver driver;

    public TestBase() {
        this.driver = DriverFactory.getDriver();
    }

    public void quitDriver() {
        DriverFactory.quitDriver();
    }
}
