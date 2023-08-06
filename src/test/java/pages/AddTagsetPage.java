package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

/*
Navigate to Tag listing
Add a new tag
 */
public class AddTagsetPage {
    private WebDriver driver;
    private JavascriptExecutor js;


    private By tickMarkBtn = By.cssSelector("button.ant-btn.ant-btn-link.sc-hBMUJo.dEuBgM");

    private By editTagBtn = By.xpath( "(//*[@class = 'ant-btn ant-btn-link sc-hBMUJo xOOiy'])[2]" );

    private By addTagBtn = By.cssSelector( "div.action-buttons-row > button:nth-child(1)" );

    private By tagNameField = By.xpath( "(//*[@class = 'ant-input sc-Arkif sc-khIgEk jriIZD hQhHpX'])[1]" );

    private By tickMarkBtn2 = By.xpath( "//*[@class = 'ant-btn ant-btn-link sc-hBMUJo dEuBgM']" );

    private By doneBtn = By.cssSelector( "button.ant-btn.sc-dIvrsQ.eQjHaU" );

    public AddTagsetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void saveTagInfo(){
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 15 ) ) ;
        driver.findElement( tickMarkBtn ).click();
    }

    public void addTags()  {
        driver.findElement( editTagBtn ).click();
        driver.findElement( addTagBtn ).click();
        js = (JavascriptExecutor)driver;
        js.executeScript( "window.scrollBy(0,500)" );
        driver.findElement( tagNameField ).sendKeys( "First Tag Name" );
        driver.findElement( addTagBtn ).click();
        driver.findElement( tagNameField ).sendKeys( "Second Tag Name" );
        driver.findElement( tickMarkBtn2 ).click();
        js.executeScript( "window.scrollBy(0,-500)" );
        driver.findElement( doneBtn ).click();
        driver.navigate().back();
        try {
            Thread.sleep( 5000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
    }

}
