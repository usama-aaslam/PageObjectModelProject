package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

/*
Go to Table attributes
Find the newly created tagset
Link tags to table
Save the changes
Publish the table
 */
public class LinkTagPage {
    private WebDriver driver;
    private JavascriptExecutor js;

    public LinkTagPage(WebDriver driver){
        this.driver = driver;
    }

    private By editButton = By.id("datdict-detpg-info-edt-btn");
    private By editAttribute = By.xpath( "(//button[@class ='ant-btn ant-btn-link sc-hBMUJo xOOiy'])[4]" );
    private By findTagset = By.xpath( "(//*[text() = 'AutomationTagset'])[1]" );
    private By findTag = By.xpath( "(//*[text() = 'FirstTag'])[1]" );
    private By applyBtn = By.xpath( "//button[@class ='ant-btn ant-btn-link sc-hBMUJo jJAyXm']" );
    private By tickMarkBtn = By.xpath( "//button[@class ='ant-btn ant-btn-link sc-hBMUJo dEuBgM']" );
    private  By doneBtn = By.id( " datdict-detpg-info-done-btn" );
    private  By publishBtn = By.xpath( "//button[@class ='ant-btn sc-dIvrsQ jfeApw']" );

    public void linkTagWithTable(){
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );
        driver.findElement( editButton ).click();
        driver.findElement( editAttribute ).click();
        driver.findElement( findTagset ).click();
        driver.findElement( findTag ).click();
        driver.findElement( applyBtn ).click();
        driver.findElement( tickMarkBtn ).click();
    }
    public void saveTableChanges(){
        js = (JavascriptExecutor)driver;
        js.executeScript( "scroll(0, -250);" );
        driver.findElement( doneBtn ).click();
        driver.findElement( publishBtn ).click();
    }
}
