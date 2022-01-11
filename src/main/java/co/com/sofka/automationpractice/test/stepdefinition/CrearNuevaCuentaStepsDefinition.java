package co.com.sofka.automationpractice.test.stepdefinition;

import co.com.sofka.automationpractice.test.controllers.CreateAnAccountWebController;
import co.com.sofka.automationpractice.test.controllers.LoginPageWebController;
import co.com.sofka.automationpractice.test.controllers.MyAccountWebController;
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

import static co.com.sofka.automationpractice.test.helpers.Dictionary.SPACE_STRING;

public class CrearNuevaCuentaStepsDefinition extends GeneralSetup{

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente esta en la página de inicio")
    public void queElClienteEstaEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente registra sus datos para una cuenta en línea de forma exitosa")
    public void elClienteRegistraSusDatosParaUnaCuentaEnLineaDeFormaExitosa() {
        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        customer = createAnAccountWebController.getCustomer();
    }

    @Entonces("como resultado el usuario quedará logueado dentro de su respectiva sesión per se.")
    public void comoResultadoElUsuarioQuedaraLogueadoDentroDeSuRespectivaSesionPerSe() {
        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(myAccountWebController.obtenerNombreDeNuevoUsuario())
                .isEqualTo(customer.getFirstName() + SPACE_STRING + customer.getLastName());
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

}
