package co.com.sofka.automationpractice.test.controllers;

import co.com.sofka.automationpractice.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void navegateToContactUs(){
        try{
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.click(contactUsPage.getContactUs(),2,true);

        } catch (WebActionsException e){
            Report.reportFailure("Ha ocurrido un error al intentar ingresar a la pagina de Contactenos.", e);
        }
    }
}
