package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ByAdressResult extends LookUpByZip{

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    private WebElement addressResult;


    public String getSearchResultText(){
        //   new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(result));
        //1.we created method , 2. we call function

        waitForVisible(addressResult);
        return addressResult.getText();
    }



 }




