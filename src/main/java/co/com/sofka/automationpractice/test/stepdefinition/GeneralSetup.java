package co.com.sofka.automationpractice.test.stepdefinition;

import co.com.sofka.automationpractice.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

public class GeneralSetup {

    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setIncognito(true);

        browserConfiguration.setDriverVersion("");

        browserConfiguration.setChromeOptions(chromeOptions());

        return browserConfiguration;
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
