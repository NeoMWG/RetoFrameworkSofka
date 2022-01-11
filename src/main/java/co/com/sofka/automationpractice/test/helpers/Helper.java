package co.com.sofka.automationpractice.test.helpers;


import co.com.sofka.automationpractice.test.models.Customer;
import co.com.sofka.test.evidence.reports.Report;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.*;


public class Helper {

    private Helper() {
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure("Fallo al consultar una propiedad del archivo "
                    + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static Customer generateCustomer(String language, String country, String emailDomain){

        Faker faker =  Faker.instance(
                new Locale(language, country),
                new Random()
        );

        Customer customer = new Customer();
        customer.setEmail(
                faker.name()
                        .username()
                        .concat(emailDomain)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );

        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setPassword(faker.number().digits(8));
        customer.setDayBirth(String.valueOf(faker.number().numberBetween(1, 28)));
        customer.setMonthBirth(String.valueOf(faker.number().numberBetween(1, 12)));
        customer.setYearBirth(String.valueOf(faker.number().numberBetween(1980, 2000)));

        customer.setAddress(faker.address().fullAddress());
        customer.setCity(faker.address().city());
        customer.setPostalCode(faker.address().zipCode());
        customer.setMobilePhone(
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(300000000, 399999999))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(1, 9)
                                )
                        )
        );
        customer.setState(STATE_BY_DEFAULT_FLORIDA);

        return customer;
    }
}
