package co.com.sofka.automationpractice.test.stepdefinition;

import co.com.sofka.automationpractice.test.controllers.*;
import co.com.sofka.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.automationpractice.test.data.objects.TestInfo;
import co.com.sofka.automationpractice.test.models.Customer;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class ContactUsStepDefinition extends GeneralSetup {

    private WebAction webAction;
    private Customer customer;
    private String MESSAJE_SUCCESS_ALERT = "Your message has been successfully sent to our team.";
    private String MESSAJE_ERROR_ALERT = "The message cannot be blank.";

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente se encuentra registrado en la pagina y se encuentra en pagina de inicio")
    public void queElClienteSeEncuentraRegistradoEnLaPaginaYSeEncuentraEnPaginaDeInicio() {

        //Abrir la Tienda Online
        openOnlineStore();

    }

    @Cuando("el cliente desea consultar algo al administrador de la pagina y da click en Contactenos")
    public void elClienteDeseaConsultarAlgoAlAdministradorDeLaPaginaYDaClickEnContactenos() {

        //Navegar hasta la pagina de Contactenos
        navToContactUs();
    }

    @Cuando("llena los campos descritos en la seccion en su totalidad")
    public void llenaLosCamposDescritosEnLaSeccionEnSuTotalidad() {
        ContactUsFillFieldsWebController contactUsFillFieldsWebController = new ContactUsFillFieldsWebController();
        contactUsFillFieldsWebController.setWebAction(webAction);
        contactUsFillFieldsWebController.fillFieldsContactUs();
    }

    @Entonces("el usuario deberia recibir un mensaje indicando que se ha enviado el mensaje correctamente.")
    public void elUsuarioDeberiaRecibirUnMensajeIndicandoQueSeHaEnviadoElMensajeCorrectamente() {

        AlertMessageWebController alertMessageWebController = new AlertMessageWebController();
        alertMessageWebController.setWebAction(webAction);
        Assert.Hard.thatString(alertMessageWebController.successMessageAlert()).isEqualTo(MESSAJE_SUCCESS_ALERT );
    }

    @Dado("que el cliente ya se se encuentra registrado en la plataforma y se halla en la pagina de inicio")
    public void queElClienteYaSeSeEncuentraRegistradoEnLaPlataformaYSeHallaEnLaPaginaDeInicio() {

        //Abrir la Tienda Online
        openOnlineStore();
    }

    @Cuando("el cliente requiere consultar o solicitar algo al administrador de la pagina y da click en Contactenos")
    public void elClienteRequiereConsultarOSolicitarAlgoAlAdministradorDeLaPaginaYDaClickEnContactenos() {

        //Navegar hasta la pagina de Contactenos
        navToContactUs();
    }

    @Cuando("llena los campos descritos en la seccion sin incluir informacion en el mensaje")
    public void llenaLosCamposDescritosEnLaSeccionSinIncluirInformacionEnElMensaje() {

        ContactUsFillFieldsWebController contactUsFillFieldsWebController = new ContactUsFillFieldsWebController();
        contactUsFillFieldsWebController.setWebAction(webAction);
        contactUsFillFieldsWebController.fillIncompleteFieldsContactUs();
    }

    @Entonces("el usuario deberia poder visualizar un mensaje indicando que el mensaje no puede estar en blanco")
    public void elUsuarioDeberiaPoderVisualizarUnMensajeIndicandoQueElMensajeNoPuedeEstarEnBlanco() {

        AlertMessageWebController alertMessageWebController = new AlertMessageWebController();
        alertMessageWebController.setWebAction(webAction);
        Assert.Hard.thatString(alertMessageWebController.errorMessageAlert()).isEqualTo(MESSAJE_ERROR_ALERT);
    }


    @After
    public void tearDown() throws WebActionsException {
        webAction.pause(5, false);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }

    public void openOnlineStore() {
        LoginPageWebController loginPageWebController = new LoginPageWebController();
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    public void navToSignIn() {
        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaLoginPage();
    }

    public void createUserRegister() {
        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        customer = createAnAccountWebController.getCustomer();
    }

    public void navToContactUs() {
        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.navegateToContactUs();
    }
}