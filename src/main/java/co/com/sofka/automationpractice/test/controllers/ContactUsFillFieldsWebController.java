package co.com.sofka.automationpractice.test.controllers;

import co.com.sofka.automationpractice.test.models.Customer;
import co.com.sofka.automationpractice.test.page.ContactUsFillFieldsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;


public class ContactUsFillFieldsWebController {

    private WebAction webAction;
    private String message = "";
        Customer customer;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void fillFieldsContactUs(){
        try{

            //new Customer();
            ContactUsFillFieldsPage contactUsFillFieldsPage = new ContactUsFillFieldsPage(webAction.getDriver());
            webAction.selectByPartialText(contactUsFillFieldsPage.getTestBoxSubject(),"Customer service",2,true);
            webAction.sendText(contactUsFillFieldsPage.getEmailSubject(), "mail@mail.com",2,true);
            webAction.sendText(contactUsFillFieldsPage.getOrderReference(),"1234",2,true);
            webAction.sendText(contactUsFillFieldsPage.getMessageSubject(),"Hola, megustaria hacer algunas sugerencias acerca de los productos. Muchas gracias.",2,true);
            webAction.click(contactUsFillFieldsPage.getSendButtonSubject(),2,true);

        } catch (WebActionsException e){
            Report.reportFailure("Ha ocurrido un error inesperado al intentar llenar los campos de contacto.", e);
        }
    }

    public void fillIncompleteFieldsContactUs(){

        try{

            //new Customer();
            ContactUsFillFieldsPage contactUsFillFieldsPage = new ContactUsFillFieldsPage(webAction.getDriver());
            webAction.selectByPartialText(contactUsFillFieldsPage.getTestBoxSubject(),"Customer service",2,true);
            webAction.sendText(contactUsFillFieldsPage.getEmailSubject(), "mail@mail.com",2,true);
            webAction.sendText(contactUsFillFieldsPage.getOrderReference(),"1234",2,true);
            webAction.click(contactUsFillFieldsPage.getSendButtonSubject(),2,true);

        } catch (WebActionsException e){
            Report.reportFailure("Ha ocurrido un error inesperado al intentar llenar los campos de contacto incompletos.", e);
        }

    }

}
