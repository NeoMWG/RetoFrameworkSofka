package co.com.sofka.automationpractice.test.controllers;

import co.com.sofka.automationpractice.test.page.ContactUsFillFieldsPage;
import co.com.sofka.automationpractice.test.page.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class AlertMessageWebController {



    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String successMessageAlert(){
        String message = "";
        try{
            ContactUsFillFieldsPage contactUsFillFieldsPage = new ContactUsFillFieldsPage(webAction.getDriver());
            message = webAction.getText(contactUsFillFieldsPage.getAlertSubject(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ha ocurrido un error inesperado al intentar validar la respuesta del mensaje correcto", e);
        }

        return message;
    }

    public String errorMessageAlert(){
        String errorMessage = "";
        try{
            ContactUsFillFieldsPage contactUsFillFieldsPage = new ContactUsFillFieldsPage(webAction.getDriver());
            errorMessage = webAction.getText(contactUsFillFieldsPage.getErrorAlertSubject(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ha ocurrido un error inesperado al intentar validar la respuesta dada por el mensaje en blanco.", e);
        }

        return errorMessage;

    }

    public String orderMessage(){
        String orderMsg = "";
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            orderMsg = webAction.getText(shoppingCartPage.getCONFIRM_ORDER_MSG(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ha ocurrido un error inesperado al intentar validar la respuesta a la orden.", e);
        }

        return orderMsg;
    }

    public String orderMessageChek(){
        String orderMsgChek = "";
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            orderMsgChek = webAction.getText(shoppingCartPage.getCONFIRM_ORDER_MSG_CHECK(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ha ocurrido un error inesperado al intentar validar la respuesta a la orden con cheque", e);
        }

        return orderMsgChek;
    }
}
