package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class SampleVerify extends Page {

    public SampleVerify(){
    } //there is no specific url, so leave it empty.


    @FindBy(xpath = "//div[@id='samplePageResult']")
    private WebElement result;

    @FindBy(xpath ="//b[@name='password']" )
    private WebElement passwordResult;

    //function to interact with the webelement




    public String getResult(){
     //   new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(result));
        //1.we created method , 2. we call function

        waitForVisible(result);
        return result.getText();
    }
    public String getPasswordResult(){
        return passwordResult.getText();
    }






//on eki, 2:21

    //encapsulation, abstraction, poilymorfism, static or dynamic polimorfism, constructor

}

