package org.anymindgroup.ragib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
    WebDriver driver;
    private By errorMSG = By.xpath("//span");

    public Registration(WebDriver driver) {
        this.driver = driver;
    }
    public String  getErrorMessage(){
        return driver.findElement(errorMSG).getText();
    }
}
