package tests.uS1010;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

public class C01 {
    LoginPage loginPage = new LoginPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testCase01() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        loginPage.ilkSayfaLoginButtonWebElement.click();
        softAssert.assertTrue(loginPage.loginEkrani.isDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void testCase02() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        loginPage.ilkSayfaLoginButtonWebElement.click();

        Assert.assertTrue(loginPage.createANewAccountButton.isEnabled());
        loginPage.createANewAccountButton.click();
        // Driver.closeDriver();
    }
    @Test
    public void test03() throws InterruptedException {

    }
@Test
    public void test04(){

}
}
