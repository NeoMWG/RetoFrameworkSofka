package co.com.sofka.automationpractice.test.stepdefinition;

import co.com.sofka.automationpractice.test.controllers.*;
import co.com.sofka.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.automationpractice.test.data.objects.TestInfo;
import co.com.sofka.automationpractice.test.models.Customer;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class ShoppingCartStepDefinition extends GeneralSetup {

    private WebAction webAction;
    private String MESSAJE_ORDER = "Your order on My Store is complete.";
    private String MESSAJE_ORDER_CHEk = "Your order on My Store is complete.";
    Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente ingresa a la pagina inicial y realiza su registro exitosamente")
    public void queElClienteIngresaALaPaginaInicialYRealizaSuRegistroExitosamente() {
        //Open Online Store
        openOnlineStore();
        //Nav to Sign In Page
        navToSignIn();
        //User Register
        createUserRegister();
    }

    @Cuando("ingresa a la opcion T-Shirts elige la prenda y realiza su pedido por transferencia bancaria")
    public void ingresaALaOpcionTShirtsEligeLaPrendaYRealizaSuPedidoPorTransferenciaBancaria() {
        //Select Product
        ShoppingCartWebController shoppingCartWebController = new ShoppingCartWebController();
        shoppingCartWebController.setWebAction(webAction);
        shoppingCartWebController.selectProducts();
    }

    @Entonces("el usuario deberia poder visualizar un mensaje que indica que ha completado su orden")
    public void elUsuarioDeberiaPoderVisualizarUnMensajeQueIndicaQueHaCompletadoSuOrden() {
        //Assertion from Msg
        AlertMessageWebController alertMessageWebController = new AlertMessageWebController();
        alertMessageWebController.setWebAction(webAction);
        Assert.Hard.thatString(alertMessageWebController.orderMessage()).isEqualTo(MESSAJE_ORDER);
    }

    @Dado("que el cliente se encuentra registrado y avanza a la pagina principal del sitio web")
    public void queElClienteSeEncuentraRegistradoYAvanzaALaPaginaPrincipalDelSitioWeb() {
        //Open Online Store
        openOnlineStore();
        //Nav to Sign In Page
        navToSignIn();
        //User Register
        createUserRegister();
    }

    @Cuando("ingresa a la opcion T-Shirts elige la prenda y realiza su pedido mediante pago con cheque")
    public void ingresaALaOpcionTShirtsEligeLaPrendaYRealizaSuPedidoMediantePagoConCheque() {
        //Select Product
        ShoppingCartWebController shoppingCartWebController = new ShoppingCartWebController();
        shoppingCartWebController.setWebAction(webAction);
        shoppingCartWebController.selectProductsCheck();
    }

    @Entonces("el usuario deberia poder visualizar un mensaje indicando que la orden ha sido completada")
    public void elUsuarioDeberiaPoderVisualizarUnMensajeIndicandoQueLaOrdenHaSidoCompletada() {
        //Assertion from Msg
        AlertMessageWebController alertMessageWebController = new AlertMessageWebController();
        alertMessageWebController.setWebAction(webAction);
        Assert.Hard.thatString(alertMessageWebController.orderMessageChek()).isEqualTo(MESSAJE_ORDER_CHEk);
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
}
