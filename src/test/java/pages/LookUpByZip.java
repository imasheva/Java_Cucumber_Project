package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookUpByZip extends UspsHeader {


    @FindBy(xpath = "//a[contains(text(),'Find by Address')]")
    private WebElement findByAddress;


    public void clickFindByAddress() {
        click(findByAddress);
    }

}