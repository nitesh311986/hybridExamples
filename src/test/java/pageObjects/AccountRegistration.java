package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends pageBase {
  public AccountRegistration(WebDriver driver)
    {
     super(driver);
    }

    @FindBy(css = "input[id='input-firstname']")
    WebElement firstName;
    @FindBy(css = "input[id='input-lastname']")
    WebElement lastName;
    @FindBy(css = "input[id='input-email']")
    WebElement Email;
    @FindBy(css = "input[id='input-password']")
    WebElement Password;
    @FindBy(css = "input[id='input-newsletter-yes']")
    WebElement newsletterRadio;
    @FindBy(css = "input[name='agree']")
    WebElement termsCondition;
    @FindBy(css = "button[type='submit']")
    WebElement submitButton;
    @FindBy(css = "div[id='content']>h1")
    WebElement verifyText;


    public void setFirstName(String fName)
    {
        firstName.sendKeys(fName);
    }
    public void setLastName(String lName)
    {
        lastName.sendKeys(lName);
    }
    public void setEmail(String email)
    {
        Email.sendKeys(email);
    }
    public void setPassword(String pass)
    {
        Password.sendKeys(pass);
    }
    public void clickNews()
    {
        newsletterRadio.click();
    }
    public void clickTerm()
    {
        termsCondition.click();
    }
    public void clickSubmit()
    {
        submitButton.click();
    }
    public String verifyPage() {
        try {
            return (verifyText.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }

    }
}
