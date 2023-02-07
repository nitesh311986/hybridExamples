package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pageBase {
   public HomePage(WebDriver driver)
    {
    super(driver);
    }
    @FindBy(xpath = "//ul[@class='list-inline']/li[2]/div/a")
    WebElement myAccount;
   @FindBy(linkText = "Register")
    WebElement registerTag;

    public void clickMyAccount()
    {
        myAccount.click();
    }
    public void clickRegister()
    {
        registerTag.click();
    }
}
