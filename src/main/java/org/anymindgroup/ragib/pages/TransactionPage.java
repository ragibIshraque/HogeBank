package org.anymindgroup.ragib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage {
    private WebDriver driver;
    private By deposit = By.xpath("//a[1]");
    private By withdraw = By.xpath("//a[2]");
    private By logout = By.xpath("//button");
    private By errorMSG = By.xpath("//span[7]");


    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToDepositPage(){
        driver.findElement(deposit).click();
    }
    public void goToWithdrawPage(){
        driver.findElement(withdraw).click();
    }
    public String getDepositPage() {
        return driver.getCurrentUrl();
    }
    public String getWithdrawPage() {
        return driver.getCurrentUrl();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public void logout(){
        driver.findElement(logout).click();
    }
}
