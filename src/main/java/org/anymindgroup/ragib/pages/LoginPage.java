package org.anymindgroup.ragib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By userName = By.xpath("//input[1]");
    private By password = By.xpath("//input[2]");
    private By loginButton = By.xpath("//button[2]");
    private By signupButton = By.xpath("//button[1]");
    private By balance  = By.xpath("//tr[1]/td[2]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPage() {
        return driver.getCurrentUrl();
    }
    public void enterUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickOnLogin() {
        driver.findElement(loginButton).click();
    }
    public void clickOnSignup() {
        driver.findElement(signupButton).click();
    }
    public String getPortfolioPage() {
        return driver.getCurrentUrl();
    }
    public String getBalance(){
        return driver.findElement(balance).getText();
    }

}
