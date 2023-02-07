package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass {

    @Test
    public void accountRegistration() throws InterruptedException {
        logger.info("Started new test case TC_001_Registration");

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicke On My Account Link");
            homePage.clickRegister();
            logger.info("Clicke On Register Link");
            AccountRegistration accountRegistration = new AccountRegistration(driver);
            accountRegistration.setFirstName("Nitesh");
            logger.info("Enter First name");
            accountRegistration.setLastName("barot");
            logger.info("Enter Last name");
            accountRegistration.setEmail("nik@gmail.com");
            logger.info("Enter Email");
            accountRegistration.setPassword("Nik@barot");
            logger.info("Enter Password");
            Thread.sleep(3000);
           JavascriptExecutor js=(JavascriptExecutor)driver;
           js.executeScript("window.scrollBy(0,10000)");
           Thread.sleep(3000);

            accountRegistration.clickNews();
            accountRegistration.clickTerm();
            accountRegistration.clickSubmit();
            String tagName = accountRegistration.verifyPage();
            System.out.println(tagName);
            //Assert.assertEquals(tagName, "Register Account");
        }


    }


