package BaseTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import java.io.File;
import java.io.IOException;

/*
Initialize the Chrome browser before the Test class
created a method to take screenshot and save in the folder when Test case gets failed
a tear down method to quit the chrome browser when test class execution gets finihed
 */
public class Setup {
    public static WebDriver driver;
    public LoginPage loginpage;

    @BeforeClass
    public void setUp(){

        System.setProperty( "webdriver.chrome.driver", "src/main/resources/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://www.app-dev.dvsum.ai/" );
        loginpage = new LoginPage( driver );
    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }

    public void failed(String testMethodName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs( OutputType.FILE );
        try {
            FileUtils.copyFile( scrFile, new File( "src/test/ScreenShots/"+testMethodName+".jpg" ) );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }

    }

}
