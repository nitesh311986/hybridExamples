package testBase;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging



public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public ResourceBundle rb;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String br)
    {
        logger= LogManager.getLogger(this.getClass());
       rb= ResourceBundle.getBundle("config");
        //WebDriverManager.chromedriver().setup();
        if(br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(rb.getString("appURL"));

        driver.manage().window().maximize();

    }
   @AfterClass

    public void tearDown()
        {
        driver.quit();
        }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }
}
