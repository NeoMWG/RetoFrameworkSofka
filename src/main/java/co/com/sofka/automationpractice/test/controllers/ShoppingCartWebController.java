package co.com.sofka.automationpractice.test.controllers;

import co.com.sofka.automationpractice.test.page.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingCartWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void selectProducts(){
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            webAction.moveTo(shoppingCartPage.getT_SHIRTS_ZONE(), 5,true);
            webAction.click(shoppingCartPage.getT_SHIRTS_ZONE(),2,true);
            webAction.click(shoppingCartPage.getEYE_PRODUCT(), 2,true);
            webAction.click(shoppingCartPage.getADD_TO_CART_BUTTON(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_WINDOW(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_SUMMARY(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_ADDRESS(), 2,true);
            webAction.click(shoppingCartPage.getCHECKBOX_TERMS_SERVICES(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_SHIPPING(),2,true);
            webAction.click(shoppingCartPage.getPAY_BANK_WIRE_OPTION(), 2,true);
            webAction.click(shoppingCartPage.getCONFIRM_FINAL_BUTTON(), 2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Se ha producido un error inesperado en la seleccion de las opciones de producto");

        }
    }

    public void selectProductsCheck(){
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            webAction.moveTo(shoppingCartPage.getT_SHIRTS_ZONE(), 5,true);
            webAction.click(shoppingCartPage.getT_SHIRTS_ZONE(),2,true);
            webAction.click(shoppingCartPage.getEYE_PRODUCT(), 2,true);
            webAction.click(shoppingCartPage.getADD_TO_CART_BUTTON(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_WINDOW(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_SUMMARY(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_ADDRESS(), 2,true);
            webAction.click(shoppingCartPage.getCHECKBOX_TERMS_SERVICES(), 2,true);
            webAction.click(shoppingCartPage.getPROCEED_TO_CHECKOUT_SHIPPING(),2,true);
            webAction.click(shoppingCartPage.getPAY_BY_CHECK(), 2,true);
            webAction.click(shoppingCartPage.getCONFIRM_FINAL_BUTTON_CHECK(), 5,true);

        }catch (WebActionsException e){
            Report.reportFailure("Se ha producido un error inesperado en la seleccion de las opciones de producto");

        }
    }
}
