package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;


public class UspsStepdefs {
    @When("I go to usps {string} store")
    public void iGoToUspsStore(String store) throws InterruptedException {
        //new UspsHome().clickStamps();
        switch (store) {
            case "stamps":
                Thread.sleep(2000);
                new UspsHome().clickStamps();
                new UspsStore().selectStampsCategory();
                break;
            case "boxes":
                Thread.sleep(2000);
                new UspsHome().clickBoxes();
                break;

            default:
                throw new RuntimeException("Invalid store: " + store); //optional
        }
        //switch or if else - variable
    }

    @And("I sort usps results by {string}")
    public void iSortUspsResultsBy(String sortBy) {
        new UspsStore().selectSortBy(sortBy);
    }

    @Then("I verify that usps {string}  is cheapest")
    public void iVerifyThatUspsIsCheapest(String item) {
        //   String actualItem = new UspsStore().getFirstResultItemName();
        assertThat(new UspsStore().getFirstResultItemName()).containsIgnoringCase(item);
    }


    @When("I go to {string} under {string} menu")
    public void iGoToUnderMenu(String menuItem, String menu) throws InterruptedException {
        UspsHome home = new UspsHome();

        home.mouseOverMenu(menu);
        home.clickMenuItem(menuItem);
        Thread.sleep(5000);

    }

    @Then("I verify that {string} is required")
    public void iVerifyThatIsRequired(String arg0) {
        UspsShipPage ship = new UspsShipPage();
      //  ship.clickSignIn();
      //  ship.isSignInErrorDisplayed();
        //Ajax call - partial upload
    }

    @Given("I go to usps page object")
    public void iGoToUspsPageObject() {

        // creare new instance

        new UspsHeader().open();


    }

    @When("I go to Lookup ZIP page object by address")
    public void iGoToLookupZIPPageObjectByAddress() throws InterruptedException {

        //create new variable - type is a class name

        UspsHeader usps = new UspsHeader();

        usps.mouseOverMailAndShip();
        usps.clickLookupByZip();

        new LookUpByZip().clickFindByAddress();

    }

    @And("I fill out {string} street, {string} city, {string} state page object")
    public void iFillOutStreetCityStatePageObject(String street, String city, String state) {

  FormZipCodeByAddress form = new FormZipCodeByAddress();
  form.fillStreetAddress(street);
  form.fillCity(city);
  form.fillState(state);
  form.clickFindButton();


    }

    @Then("I validate {string} zip code exists in the result page object")
    public void iValidateZipCodeExistsInTheResultPageObject(String zip) {

        String results = new ByAdressResult().getSearchResultText();
        assertThat(results).contains(zip);
    }

    @When("I go to Calculate Price page object")
    public void iGoToCalculatePricePageObject() {
    }
}
