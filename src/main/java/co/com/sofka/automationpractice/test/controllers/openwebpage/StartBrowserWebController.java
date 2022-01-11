package co.com.sofka.automationpractice.test.controllers.openwebpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.APP_URL_PROPERTY;
import static co.com.sofka.automationpractice.test.helpers.Helper.getProperty;

public class StartBrowserWebController {
    private WebAction webAction;
    private String feature;
    private Browser browser;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void abrirTiendaOnline() {
        try{
            webAction.startWebApp(browser, getProperty(APP_URL_PROPERTY), feature);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrió un error al intentar abrir la tienda online.", e);
        }
    }
}
