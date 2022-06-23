package com.anhtester.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.anhtester.base.BaseSetUp;
import com.anhtester.pages.SignInPage;


public class SignInTest extends BaseSetUp {

    private WebDriver driver;
    public SignInPage signInPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void signIn() throws Exception {
        System.out.println(driver);
        signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn/t match");
        Assert.assertTrue(signInPage.verifySignInPageText(), "Header page text not matching");

    }

}
