package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccount;

    @CacheLookup
    @FindBy(id = "uniform-id_gender1")
    WebElement mr;

    @CacheLookup
    @FindBy(id = "uniform-id_gender2")
    WebElement mrs;

    @CacheLookup
    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement password;

    @CacheLookup
    @FindBy(id = "days")
    WebElement day;

    @CacheLookup
    @FindBy(id = "months")
    WebElement month;

    @CacheLookup
    @FindBy(id = "years")
    WebElement year;

    @CacheLookup
    @FindBy(id = "newsletter")
    WebElement newsLetter;

    @CacheLookup
    @FindBy(id = "optin")
    WebElement receiveSpecialOffers;

    @CacheLookup
    @FindBy(id = "firstname")
    WebElement firstNameAddress;

    @CacheLookup
    @FindBy(id = "lastname")
    WebElement lastNameAddress;

    @CacheLookup
    @FindBy(id = "company")
    WebElement company;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "id_state")
    WebElement state;

    @CacheLookup
    @FindBy(id = "postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "id_country")
    WebElement idCountry;

    @CacheLookup
    @FindBy(id = "other")
    WebElement other;

    @CacheLookup
    @FindBy(id = "phone")
    WebElement phone;

    @CacheLookup
    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;

    @CacheLookup
    @FindBy(id = "alias")
    WebElement alias;

    @CacheLookup
    @FindBy(id = "submitAccount")
    WebElement register;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }

    public WebElement getMr() {
        return mr;
    }

    public WebElement getMrs() {
        return mrs;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getNewsLetter() {
        return newsLetter;
    }

    public WebElement getReceiveSpecialOffers() {
        return receiveSpecialOffers;
    }

    public WebElement getFirstNameAddress() {
        return firstNameAddress;
    }

    public WebElement getLastNameAddress() {
        return lastNameAddress;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getIdCountry() {
        return idCountry;
    }

    public WebElement getOther() {
        return other;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getPhoneMobile() {
        return phoneMobile;
    }

    public WebElement getAlias() {
        return alias;
    }

    public WebElement getRegister() {
        return register;
    }

    public CreateAnAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
