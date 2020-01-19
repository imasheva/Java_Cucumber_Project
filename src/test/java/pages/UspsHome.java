package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getActions;
import static support.TestContext.getDriver;
public class UspsHome extends Page {
    public UspsHome(){url ="https://www.usps.com/";}

    @FindBy (xpath = "//a[@id='mail-ship-width']")
//a[text()=
    private WebElement mailAndShipMenu;

    @FindBy(xpath = "//a[contains(text(),'ZIP')]") ////a[contains(text(),'Look Up a ZIP Code')]
    private WebElement lookupZipSubmenu;
    @FindBy(xpath = "//a[contains(text(),'Find Cities by ZIP')]")
    private WebElement findByZipBtn;
    @FindBy (xpath = "//a[@data-gtm-section='quicktools'][text()='Stamps & Supplies']")
    private WebElement stamps;
    @FindBy(xpath = "(//div[@class='article col-12 align-self-center']//strong[contains(text(),'Order Now')])")
    private WebElement orderBoxes;

    @FindBy (xpath = "//a[contains(text(),'Click-N-Ship')]")
    private WebElement clickAndShip;


    public void clickStamps() {
        stamps.click();
    }




    public void navigateToFindCitiesByZip () throws InterruptedException {
        new Actions(getDriver()).click(mailAndShipMenu).click(lookupZipSubmenu).perform();
        findByZipBtn.click();
        Thread.sleep(5000);
    }
    //1st Action Mouse Over
    public void mouseOverMenu(String name){
        WebElement menu = getDriver().findElement(By.xpath("//a[text()='" +name+"']"));
        getActions().moveToElement(menu).perform();
    }

    //2nd click menu
    public void clickMenuItem(String name){
        getDriver().findElement(By.xpath("//li/a[text()='"+name+"']")).click();
    }




    public void clickBoxes() {
        orderBoxes.click();
    }
    public void navigateToClickNShip() throws InterruptedException{
        new Actions(getDriver()).click(mailAndShipMenu).click(clickAndShip).perform();

    }



}