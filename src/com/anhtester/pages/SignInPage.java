package com.anhtester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class SignInPage {
    private WebDriver driver;

    private By headerPageText = By.xpath("//h2[contains(.,'Stay hungry, stay foolish.')]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSignInPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean verifySignInPageTitle() {
        String expectedTitle = "Đăng nhập";
        return getSignInPageTitle().equals(expectedTitle);
    }

    public boolean verifySignInPageText() {
        WebElement element = driver.findElement(headerPageText);
        String pageText = element.getText();
        String expectedPageText = "Stay hungry, stay foolish.";
        return pageText.contains(expectedPageText);
    }
}
