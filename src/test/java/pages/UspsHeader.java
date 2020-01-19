package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

// class is always public
public class UspsHeader extends Page {

    //constructor is always public , same name as the class, the difference in syntax ()

    public UspsHeader(){
        setUrl("https://www.usps.com/"); //in constructor we provide url
    }


       //Header
       // To get anywhere in mail and ship

    @FindBy(xpath = "//a[@id='mail-ship-width']")
    private WebElement mailAndShip;

    //Submenu -> LookUpBy ZipCode DropDown    //li[@class='tool-zip']//a

    @FindBy(xpath = "//li[@class='tool-zip']//a")
    private WebElement lookupByZip;

    //generic method in Page
  /*  public void moveToElement(WebElement element) {
        new Actions(getDriver()).moveToElement(element).perform();
    }
    */

    public void mouseOverMailAndShip(){
       moveToElement(mailAndShip);
    }

    public void clickLookupByZip(){
        click(lookupByZip);
    }




}
