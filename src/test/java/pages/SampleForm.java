package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getExecutor;

public class SampleForm extends Page {
    public SampleForm() {     //CONSTRUCTOR 1
        setUrl("http://skryabin.com/webdriver/html/sample.html");
    }

   /* public SampleForm(String url) {     //CONSTRUCTOR 2
        setUrl(url);
    }*/
    //DEFINE FIELDS FOR PAGE OBJECT BY USING ANNOTATIONS FROM WEBDRIVER TO DECLARE ANY ELEMENTS AS A PART OF THE PAGE
    // WE HAVE TO PUT ALL THE SELECTORS / FIELDS that belongs to the PAGE:
    // DECLARE FIELDS

    @FindBy(xpath = "//input[@name='username']")   // Specific annotation for WebDriver
    private WebElement username;    //define the name-give name for the field

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    public void fillUserName(String text) {
        sendKeys(username,text);
    }

    public void fillEmail(String text) {
        sendKeys(email, text);        //this.email.sendKeys(email); // or change email.sendKeys(text);
    }

    public void clickSubmitButton() {
       click(submitButton);

        //Before optimization
        // submitButton.click(); // microfunctions
      //  waitForVisible(submitButton);
      //  clickWithJS(submitButton);
    }

    public void fillName(String firstName, String middleName, String lastName) {
        click(name);

        SampleFormNameDialogue dialogue = new SampleFormNameDialogue();
        dialogue.fillFirstName(firstName);
        dialogue.fillMiddleName(middleName);
        dialogue.fillLastName(lastName);
        dialogue.clickSaveButton();
    }
   public void fillPassword(String text){
        sendKeys(password, text);
   }

   public void fillConfirmPassword(String text){
        sendKeys(confirmPassword,text);
   }

   public void clickPrivacyPolicy(){
     click(privacyPolicy);

        //Before optimization
      /*  waitForVisible(privacyPolicy);
        clickWithJS(privacyPolicy);*/
      //  privacyPolicy.click();
   }

  /* public void click(WebElement element) {
        waitForVisible(element);
        try{
            element.click();
            catch(WebDriverException e){
                clickWithJS(element);
            }
        }
   }*/
}
