package org.anymindgroup.ragib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawPage {
    private WebDriver driver;
    private By withdraw = By.xpath("//button");
    private By amount = By.xpath("//input");
    private By initialBalance = By.xpath("//span[2]");
    private By transactionFee = By.xpath("//span[4]");
    private By finalDeposit = By.xpath("//span[6]");
    private By errorMSG = By.xpath("//span[7]");

    public WithdrawPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterAmountForDeposit(String depositAmound){
        driver.findElement(amount).sendKeys(depositAmound);
    }
    public void clickDepositButton(){
        driver.findElement(withdraw).click();
    }
    public String getTransactionFee(){
        return driver.findElement(transactionFee).getText();
    }
    public String getFinalDeposit(){
        return driver.findElement(finalDeposit).getText();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMSG).getText();
    }
    public String getInitialBalance(){
        return driver.findElement(initialBalance).getText();
    }
}
