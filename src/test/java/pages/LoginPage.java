package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Login the application
 */
public class LoginPage{
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private By signInBtn = By.xpath("//span[contains(text(), 'Sign In')]");

    private By email = By.xpath( "(//*[@id=\"signInFormUsername\"])[2]" );

    private By password = By.xpath( "(//input[@name=\"password\"])[2]" );

    private By loginBtn = By.xpath("(//*[@name=\"signInSubmitButton\"])[2]") ;

    public void clickSingInBtn(){
        driver.findElement( signInBtn ).click();
    }

    public void enterUserEmail(String uemail){
        driver.findElement( email ).sendKeys( uemail );
    }

    public void enterPassword(String upass){
        driver.findElement( password ).sendKeys( upass );
    }

    public void clickLoginBtn(){
        driver.findElement( loginBtn ).click();

    }

}
