package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.*;

public class Page {

    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public Page() {

        PageFactory.initElements(getDriver(), this);
    }

    public void open() {

        getDriver().get(url);
    }

    protected WebElement byXpath(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }


    public void mouseOver(WebElement element) {
        getActions().moveToElement(element).perform();
    }


    public void moveToElement(WebElement element) {
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void click(WebElement element){
        waitForVisible(element);
        try{
            element.click();
        } catch (ElementClickInterceptedException e){
            clickWithJS(element);
        }
    }

    protected void mouseOverMenu(String name){
        mouseOver (byXpath("//a[text()='" + name + "']"));
    }

    protected void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click();", element);
    }
    public void waitForVisible(WebElement element){
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        waitForVisible(element);
        try {
            element.click();
        } catch (WebDriverException e) {
            clickWithJS(element);
        }
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisible(element);
        element.sendKeys(text);
    }


    protected WebElement byId(String id) {
        return getDriver().findElement(By.id(id));
    }





}
