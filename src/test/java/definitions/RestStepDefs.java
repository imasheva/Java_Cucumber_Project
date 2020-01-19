
package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import support.RestWrapperFinal;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RestStepDefs {

    @Given("I login via REST as {string}")

    public void iLoginViaRESTAs(Map<String, String> role) {
        RestWrapperFinal rest = new RestWrapperFinal();
        rest.login(role);
    }


    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(Map <String, String> position) {
        new RestWrapperFinal().createPosition(position);



    }
}
