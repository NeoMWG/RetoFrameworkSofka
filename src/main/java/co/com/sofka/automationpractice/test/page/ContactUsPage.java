package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(xpath = "//a[@title='Contact Us']")
    WebElement contactUs;

    public WebElement getContactUs() {
        return contactUs;
    }

    public ContactUsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
