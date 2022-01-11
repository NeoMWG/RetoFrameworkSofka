package co.com.sofka.automationpractice.test.controllers;

import co.com.sofka.automationpractice.test.models.Customer;
import co.com.sofka.automationpractice.test.page.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.*;
import static co.com.sofka.automationpractice.test.helpers.Helper.generateCustomer;

public class CreateAnAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(createAnAccountPage.getEmailAddress(), customer.getEmail(), 2, true);
            webAction.click(createAnAccountPage.getCreateAnAccount(), 2, true);
            webAction.click(createAnAccountPage.getMr(), 10, true);
            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(), true);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(), true);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(), true);
            webAction.selectByPartialText(createAnAccountPage.getDay(), customer.getDayBirth(), true);
            webAction.selectByValue(createAnAccountPage.getMonth(), customer.getMonthBirth(), true);
            webAction.selectByPartialText(createAnAccountPage.getYear(), customer.getYearBirth(), true);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(), true);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(), true);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(), true);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(), true);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(), true);
            webAction.click(createAnAccountPage.getRegister(), true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }
}
