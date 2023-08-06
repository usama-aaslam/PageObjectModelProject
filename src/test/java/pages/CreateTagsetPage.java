package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

/*
Navigate to tagset detail page
Add two tags to the newly created tagset
 */
public class CreateTagsetPage {
    private WebDriver driver;
    private JavascriptExecutor js;

    public CreateTagsetPage(WebDriver driver){
        this.driver = driver;
    }

    private By sideMenu = By.xpath( "//*[@class = 'ant-menu-submenu-title']" );

    private By subMenu = By.xpath( "//*[contains(text(), 'Tags')]" );

    private By createTagButton = By.xpath( "//*[contains(text(), 'Add')]" );

    private By tagNameField = By.cssSelector( "div.ant-form-item-control-input-content > div > input" );

    private By tagDescriptionField = By.cssSelector( "div.ant-form-item-control-input-content > div  >textarea" );

    private By addTagButton = By.xpath( "//*[@class = 'ant-btn sc-dIvrsQ dQyBhd']" );


    public void clickSideMenu (){
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 25 ) ) ;
        driver.findElement( sideMenu ).click();
    }

    public void clickSubMenu (){
        js = (JavascriptExecutor)driver;
        js.executeScript( "window.scrollBy(0,500)" );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) ) ;
        driver.findElement( subMenu ).click();

    }
    public  void createTagSet() throws InterruptedException {
        Thread.sleep( 10000 );
        driver.findElement( createTagButton ).click();
        driver.findElement( tagNameField ).sendKeys( "AutomationTagset" );
        driver.findElement( tagDescriptionField ).sendKeys( "Automation Tag Description" );
        driver.findElement( addTagButton ).click();
    }

}
