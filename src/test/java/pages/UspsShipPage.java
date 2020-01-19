package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsShipPage extends Page {

   /* @FindBy(xpath = "//input[@id='username']")
    private WebElement username;


    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;*/


    @FindBy(id = "btn-submit")
    private WebElement signIn;

    @FindBy(id = "sign-up-button")
    private WebElement signUp;

    @FindBy(id = "error-username")
    private WebElement errorUsername;


    @FindBy(id = "error-username")
    private WebElement errorPassword;









   /* public void fillUserName(String text) {
        username.sendKeys("Skryabin");

    }

    public void fillPassword(String text) {
        password.sendKeys("welcome");
    }*/

}