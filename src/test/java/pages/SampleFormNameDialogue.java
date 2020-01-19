package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleFormNameDialogue extends Page{

    // SELECTORS
    @FindBy (xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy (xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy (xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy (xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;


    //METHODS

    public void fillFirstName(String text){
        firstName.sendKeys("Slava");
    }
    public void fillMiddleName(String text){
        middleName.sendKeys("Vlad");
    }
    public void fillLastName(String text){
        lastName.sendKeys("Skryabin");
    }

    public void clickSaveButton(){
        saveButton.click();
    }
}




