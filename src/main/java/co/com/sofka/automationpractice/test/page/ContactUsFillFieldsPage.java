package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsFillFieldsPage {


    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement testBoxSubject;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailSubject;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement orderReference;

    @CacheLookup
    @FindBy(id = "message")
    WebElement messageSubject;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submitMessage']/span")
    WebElement sendButtonSubject;

    //Validation
    @CacheLookup
    @FindBy(css = ".alert.alert-success")
    WebElement alertSubject;

    @CacheLookup
    @FindBy(xpath = "//div[@id='center_column']/div/ol/li")
    WebElement errorAlertSubject;

    public WebElement getTestBoxSubject() {
        return testBoxSubject;
    }

    public WebElement getEmailSubject() {
        return emailSubject;
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getMessageSubject() {
        return messageSubject;
    }

    public WebElement getSendButtonSubject() {
        return sendButtonSubject;
    }

    public WebElement getAlertSubject() {
        return alertSubject;
    }

    public WebElement getErrorAlertSubject() {
        return errorAlertSubject;
    }

    public ContactUsFillFieldsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
