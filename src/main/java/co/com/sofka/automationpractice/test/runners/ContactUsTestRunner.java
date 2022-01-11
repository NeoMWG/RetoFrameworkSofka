package co.com.sofka.automationpractice.test.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = {"src/main/resources/features/ContactUsForm.feature"},
        glue = {"co.com.sofka.automationpractice.test.stepdefinition"},
        tags = {""}
)
public class ContactUsTestRunner {
}
