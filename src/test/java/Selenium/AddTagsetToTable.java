package Selenium;

import BaseTest.Setup;
import Utilities.TakeScreenshotListener;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

/*
This Test case will login to application
Then create a new tag & add tagset
Then Navigate to Table detail page & add newly created tags to table
 */
@Listeners(TakeScreenshotListener.class)
public class AddTagsetToTable extends Setup {
    @Test(priority = 1)
    public void loginToApplication() throws InterruptedException {          //In this method user will login to application using valid credentials

        LoginPage loginPage = new LoginPage( driver );
        loginpage.clickSingInBtn();
        loginPage.enterUserEmail( "usama.aslam+36@emumba.com" );
        loginPage.enterPassword( "Aa@12345678" );
        loginPage.clickLoginBtn();
        String HomePageTitle = driver.getTitle();
        Assert.assertEquals( HomePageTitle , "Data Intelligence" , "Error!!! Login is not Successful" ); // Assert that the home page title is as expected

    }
    @Test(priority = 2)
    public void createTagset() throws InterruptedException {                //In this method user will navigate to Tags & create a new tagset
        CreateTagsetPage createTagset = new CreateTagsetPage( driver );
        createTagset.clickSideMenu();
        createTagset.clickSubMenu();
        createTagset.createTagSet();
    }

    @Test(priority = 3)
    public void addTagsForTagset() throws InterruptedException {            // In this method user will add tags to the tagset and verify tags are created successfully
        AddTagsetPage addtags = new AddTagsetPage(driver);
        addtags.saveTagInfo();
        addtags.addTags();
        Assert.assertNotNull( driver.findElement( By.xpath( "//*[text() = 'AutomationTagset']" ) ), "Tag not Created , Test case Failed!!!" ); // Assert that the tag is created

    }
    @Test(priority = 4)
    public void GoToTableDetailPage() throws InterruptedException{          // In this method user will search table and navigate to table detail page
        OpenTableDetailPage tableDetailPage = new OpenTableDetailPage( driver );
        tableDetailPage.searchTable();
        tableDetailPage.openTable();
        String detailPageUrl = driver.getCurrentUrl();
        Assert.assertTrue( detailPageUrl.contains( "tables" ) && detailPageUrl.contains( "overview" ), "Unable to Open table detail page. Test case Failed!!!"); // Assert that the tags is created
    }
    @Test(priority = 5)
    public void linkTagset(){                  // In this method user will link new tag to the table and verify tags gets added successfully
        LinkTagPage tagPage = new LinkTagPage( driver );
        tagPage.linkTagWithTable();
        tagPage.saveTableChanges();
        Assert.assertTrue( driver.findElement( By.xpath( "(//*[text() = 'FirstTag'])" ) ).isDisplayed(), "Tagset Not linked with Table, Test Case Failed!!" ); // Assert that the tagset is linked with the table
    }
}
