package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

/*
Search the table using enterprise search
Open the table ref page
Navigate to table detail page
 */
public class OpenTableDetailPage {
    private WebDriver driver;

    public OpenTableDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    private By searchBar =By.cssSelector("#entsrch-bar");
    private By resultCard = By.id("entsrch-tbl-res-val-1");
    private By refGoToIcon = By.id("datdict-detpg-info-ref-goto");

    public void searchTable (){
        driver.findElement( searchBar ).sendKeys( "CAR_SUPPLYCHAIN_MANAGEMENT" );
        driver.findElement( searchBar ).sendKeys( Keys.ENTER );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 25 ) );
        driver.findElement( resultCard ).click();

    }

    public void openTable(){
        driver.findElement( refGoToIcon ).click();
    }

}
