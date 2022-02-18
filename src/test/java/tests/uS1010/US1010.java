package tests.uS1010;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US1010 {
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
    public void testCase03() {

        loginPage.yeniHesapOlustur();
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(loginPage.registrationBasararilikayitYazisi.isDisplayed());
        softAssert.assertAll();
        loginPage.registrationOnayOkbuttonu.click();
        // Driver.closeDriver();
    }
    @Test
    public void testCase04(){
        loginPage.yeniHesapOlustur();

        loginPage.registrationOnayOkbuttonu.click();
        Assert.assertTrue(loginPage.accountLoginWebElement.isDisplayed());
        Assert.assertTrue(loginPage.accountLoginWebElement.isEnabled());
        loginPage.loginEkrani.click();
        loginPage.usernameWebElement.sendKeys(loginPage.fakername);
        loginPage.passwordWebElement.sendKeys(loginPage.fakerpassword);
        loginPage.accountLoginWebElement.click();
        Assert.assertTrue(loginPage.profilpage.isDisplayed());

    }
    @Test
    public void testCase05(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        loginPage.ilkSayfaLoginButtonWebElement.click();
        loginPage.usernameWebElement.sendKeys(ConfigReader.getProperty("HMCnewValidUsername"));
        loginPage.passwordWebElement.sendKeys(ConfigReader.getProperty("HMCnewValidPassword"));
        loginPage.accountLoginWebElement.click();
        loginPage.reservationRoom();



    }
    @Test
    public void testdeneme(){
        Driver.getDriver().get("https://www.hotelmycamp.com/RoomDetail/346");
        String date=Driver.getDriver().findElement(By.xpath("https://www.hotelmycamp.com/RoomDetail/346")).getText();
    }
}
