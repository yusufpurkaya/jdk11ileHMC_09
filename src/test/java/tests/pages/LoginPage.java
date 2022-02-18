package tests.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //ilk sayfa login butonu
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkSayfaLoginButtonWebElement;

    //username textbox
    @FindBy(id = "UserName")
    public  WebElement usernameWebElement;

    //password textbox
    @FindBy(id = "Password")
    public  WebElement passwordWebElement;

    //AccountLogin butonu
    @FindBy(id = "btnSubmit")
    public WebElement accountLoginWebElement;

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkSayfaLoginButtonWebElement.click();
        usernameWebElement.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordWebElement.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        accountLoginWebElement.click();
    }
    //----------------us10
    @FindBy(xpath = "//h1[@class='mb-4 bread']")
    public WebElement loginEkrani;
    @FindBy(xpath = "//span[@class='btn btn-primary py-3 px-5']")
    public WebElement createANewAccountButton;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement registrationUsername;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement registrationPassword;
    @FindBy(xpath = "//Select[@name='IDCountry']")
    public WebElement registrationCountry;
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement registrationOnayOkbuttonu;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement registrationBasararilikayitYazisi;
    @FindBy(xpath = "//h2[@class='mb-4']")
    public WebElement profilpage;
    @FindBy(xpath = "//a[@href='/profile/Reservations']")
    public WebElement reservationslinki;
    @FindBy(id = "AdultCount")
    public WebElement reservationAdultDropBox;
    @FindBy(xpath = "//select[@id='ChildrenCount']")
    public WebElement reservationChildrenCount;
@FindBy(id = "NameOnCreditCard")
        public WebElement reservationCCname;
@FindBy(id = "CreditCardNumber")
        public WebElement reservationCCnumber;
@FindBy(id = "CreditCardExpirationYear")
        public WebElement rsvCrdtCrdExYear;
@FindBy(id = "CreditCardExpirationMonth")
        public WebElement rsvCrdCrdExMonth;
@FindBy(id = "CVV")
        public WebElement rsvCCardCVV;
@FindBy(id = "Message")
        public WebElement reservationMassage;
@FindBy(xpath = "//input[@type='submit']")
        public WebElement rsvBookRoom;
@FindBy (xpath = "(//a[@href='/Profile/ReservationDetail/1583'])[2]")
        public WebElement yourReservationHere;
@FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement basarilireseveYazisi;
@FindBy(xpath = "//a[@href='/profile/Reservations']")
        public WebElement usermenuReservations;
    //@FindBy(xpath = "//a[@href='/Account/Logon']")
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    SoftAssert softAssert=new SoftAssert();
    public String fakername=faker.name().name();
    public String fakerpassword=faker.internet().password();
    Select select=new Select(registrationCountry);
    Random rdm=new Random();
    // int ulkeindex=rdm.nextInt(24,265);
    int odano=rdm.nextInt(3);
    public void yeniHesapOlustur(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkSayfaLoginButtonWebElement.click();
        createANewAccountButton.click();

        registrationUsername.sendKeys(fakername+ Keys.TAB);
        registrationPassword.sendKeys(fakerpassword+Keys.TAB);
        actions.sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).
                sendKeys(fakername+faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).
                sendKeys("123456789").sendKeys(Keys.TAB).
                sendKeys("yes").sendKeys(Keys.TAB).perform();
        select.selectByIndex(5);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
                sendKeys("IT").sendKeys(Keys.TAB).sendKeys("20/10/1990").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
    public void reservasionDateSecme(){


    }
    public void alinanhesaplaLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkSayfaLoginButtonWebElement.click();
        createANewAccountButton.click();

        registrationUsername.sendKeys(fakername+ Keys.TAB);
        registrationPassword.sendKeys(fakerpassword+Keys.TAB);
        actions.sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).
                sendKeys(fakername+faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).
                sendKeys("123456789").sendKeys(Keys.TAB).
                sendKeys("yes").sendKeys(Keys.TAB).perform();
        select.selectByIndex(5);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
                sendKeys("IT").sendKeys(Keys.TAB).sendKeys("20/10/1990").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


    }
    public void dropboxrandomsecim(WebElement a){
        Faker faker = new Faker();
        Select select = new Select(a);
        List<WebElement> dropbox = select.getOptions();
        int rnd = faker.random().nextInt(1, dropbox.size() - 1);
        select.selectByIndex(rnd);


    }
    @FindBy(id = "checkin_date")
    public WebElement reservationdate;
    public void reservationRoom() {
        Driver.getDriver().findElement(By.xpath("(//a[@class='btn-custom'])["+odano+"]")).click();
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        dropboxrandomsecim(reservationAdultDropBox);

        dropboxrandomsecim(reservationChildrenCount);
actions.sendKeys(Keys.PAGE_DOWN).perform();
reservationCCname.sendKeys("free");
reservationCCnumber.sendKeys("0000000000000000");
dropboxrandomsecim(rsvCrdtCrdExYear);
dropboxrandomsecim(rsvCrdCrdExMonth);
rsvCCardCVV.sendKeys("000");
reservationMassage.sendKeys("I like this Game");
rsvBookRoom.click();

String basarilireseve="Reservation was made successfully";
softAssert.assertTrue(basarilireseveYazisi.getText().contains(basarilireseve));
softAssert.assertAll();
        yourReservationHere.click();
        usermenuReservations.click();
    }
}
