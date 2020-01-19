package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class MarketStepDefs {


    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "usps":
                new UspsHome().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I fill out {string} fields")
    public void iFillOutFields(String scope) {
        QuoteForm form = new QuoteForm();
        form.fillUsername("skryabin");
        form.fillEmail("slava@skryabin.com");
        form.fillPassword("welcome");
        form.fillConfirmPassword("welcome");
        form.fillName("Slava", "Skryabin");
        form.acceptPrivacy();
        form.submitForm();
    }

    @Then("I verify {string} fields")
    public void iVerifyFields(String scope) {
        QuoteResult result = new QuoteResult();
        String resultText = result.getResult();

        assertThat(resultText).contains("skryabin");
        assertThat(resultText).contains("slava@skryabin.com");
        assertThat(resultText).contains("Slava Skryabin");
        assertThat(resultText).doesNotContain("welcome");
        assertThat(result.getPrivacy()).isEqualTo("true");
        assertThat(result.getPassword()).isEqualTo("[entered]");
        assertThat(result.areAllResultElementsBold()).isTrue();
    }

    @Given("I open sample page")
    public void iOpenSamplePage() {
        new SampleForm().open(); //function
    }

    @When("I fill out all page object fields")
    public void iFillOutAllPageObjectFields() {


        SampleForm form = new SampleForm();

        Map<String, String> customer = getData("customer");

        form.fillUserName(customer.get("username"));
        form.fillEmail(customer.get("email"));
        form.fillName(customer.get("firstName"), "middleName", "lastName");
        form.fillPassword(customer.get("password"));
        form.fillConfirmPassword(customer.get("password"));
        form.clickPrivacyPolicy();

    }

    @And("I submit page object form")
    public void iSubmitPageObjectForm() {
        new SampleForm().clickSubmitButton();

    }

    @Then("I verify all page object fields")
    public void iVerifyAllPageObjectFields() throws InterruptedException {


        SampleVerify verifyPage = new SampleVerify();

        Map<String, String> customer = getData("customer");

        String result = verifyPage.getResult();

        assertThat(result).contains(customer.get("username"));
        assertThat(result).contains(customer.get("email"));
        assertThat(result).contains(customer.get("firstName"));
        assertThat(result).contains(customer.get("lastName"));

        assertThat(verifyPage.getPasswordResult()).contains(customer.get("savedPasswordPlaceholder"));

    }
}

