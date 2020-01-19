package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class UspsStore extends Page {


    @FindBy(xpath = "//div[@class='nav-table']//span[contains(text(),'Stamps')]")
    private WebElement stamps;

    @FindBy (id ="Ns")
    private WebElement sortBy;

    @FindBy(xpath = "(//div[@class='results-product-desc'])[1]")
    private WebElement firstFoundItem;


    public void selectStampsCategory(){
        stamps.click();
    }
    public void selectSortBy (String order) {
        new Select(sortBy).selectByVisibleText(order);
    }
    public String getFirstResultItemName() {
        return firstFoundItem.getText();
    }


}






