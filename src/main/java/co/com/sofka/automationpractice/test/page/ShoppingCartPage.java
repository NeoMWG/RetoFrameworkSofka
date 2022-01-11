package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    WebElement T_SHIRTS_ZONE;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
    WebElement EYE_PRODUCT;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
    WebElement ADD_TO_CART_BUTTON;

    @CacheLookup
    @FindBy(xpath = "(//span[normalize-space()='Proceed to checkout'])[1]")
    WebElement PROCEED_TO_CHECKOUT_WINDOW;

    @CacheLookup
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement PROCEED_TO_CHECKOUT_SUMMARY;

    @CacheLookup
    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement PROCEED_TO_CHECKOUT_ADDRESS;

    @CacheLookup
    @FindBy(xpath = "//label[@for='cgv']")
    WebElement CHECKBOX_TERMS_SERVICES;

    @CacheLookup
    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement PROCEED_TO_CHECKOUT_SHIPPING;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Pay by bank wire']//span[contains(text(),'(order processing will be longer)')]")
    WebElement PAY_BANK_WIRE_OPTION;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement CONFIRM_FINAL_BUTTON;

    @CacheLookup
    @FindBy(xpath = "//div[@class='columns-container']//div[@class='row']//div[2]//div[1]")
    WebElement PAY_BY_CHECK;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement CONFIRM_FINAL_BUTTON_CHECK;

    //Validations
    @CacheLookup
    @FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
    WebElement CONFIRM_ORDER_MSG;

    @CacheLookup
    @FindBy(xpath = "(//p[@class='alert alert-success'])[1]")
    WebElement CONFIRM_ORDER_MSG_CHECK;


    public WebElement getT_SHIRTS_ZONE() {
        return T_SHIRTS_ZONE;
    }

    public WebElement getEYE_PRODUCT() {
        return EYE_PRODUCT;
    }

    public WebElement getADD_TO_CART_BUTTON() {
        return ADD_TO_CART_BUTTON;
    }

    public WebElement getPROCEED_TO_CHECKOUT_WINDOW() {
        return PROCEED_TO_CHECKOUT_WINDOW;
    }

    public WebElement getPROCEED_TO_CHECKOUT_SUMMARY() {
        return PROCEED_TO_CHECKOUT_SUMMARY;
    }

    public WebElement getPROCEED_TO_CHECKOUT_ADDRESS() {
        return PROCEED_TO_CHECKOUT_ADDRESS;
    }

    public WebElement getCHECKBOX_TERMS_SERVICES() {
        return CHECKBOX_TERMS_SERVICES;
    }

    public WebElement getPROCEED_TO_CHECKOUT_SHIPPING() {
        return PROCEED_TO_CHECKOUT_SHIPPING;
    }

    public WebElement getPAY_BANK_WIRE_OPTION() {
        return PAY_BANK_WIRE_OPTION;
    }

    public WebElement getCONFIRM_FINAL_BUTTON() {
        return CONFIRM_FINAL_BUTTON;
    }

    public WebElement getCONFIRM_FINAL_BUTTON_CHECK() {
        return CONFIRM_FINAL_BUTTON_CHECK;
    }

    public WebElement getPAY_BY_CHECK() {
        return PAY_BY_CHECK;
    }

    public WebElement getCONFIRM_ORDER_MSG() {
        return CONFIRM_ORDER_MSG;
    }

    public WebElement getCONFIRM_ORDER_MSG_CHECK() {
        return CONFIRM_ORDER_MSG_CHECK;
    }

    public ShoppingCartPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
