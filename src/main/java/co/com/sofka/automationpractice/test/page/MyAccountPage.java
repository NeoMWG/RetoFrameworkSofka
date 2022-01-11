package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @CacheLookup
    @FindBy(className = "account")
    WebElement customerName;

    public WebElement getCustomerName() {
        return customerName;
    }

    public MyAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
