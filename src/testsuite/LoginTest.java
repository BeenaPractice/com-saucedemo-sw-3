package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";
@Before
    // browser setup
    public void browserSetUp() {
        openBrowser(baseUrl);
    }
@Test
    //userShouldLoginSuccessfullyWithValid Credentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //  Enter “standard_user” username
   sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
    // Enter “secret_sauce” password
    sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
    // Click on ‘LOGIN’ button
    clickOnElement(By.xpath("//input[@id='login-button']"));
    // Verify the text “PRODUCTS”
    String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
    String expectedText = "Products";
    Assert.assertEquals("failed!",expectedText,actualText);
    }

    // verifyThatSixProductsAreDisplayedOnPage
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        //  Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));


        // Verify that six products are displayed on page

        List<WebElement> image = driver.findElements(By.className("inventory_item"));
        System.out.println("The number of image is" + image.size());
        int  expectedImage = 6;
        int actualImage = image.size();
        Assert.assertEquals("",expectedImage,actualImage);

    }
    @After
    public void tearDown(){
    closeBrowser();
    }
}