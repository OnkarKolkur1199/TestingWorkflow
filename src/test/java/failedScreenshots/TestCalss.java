package failedScreenshots;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCalss extends BaseTest{
	
	@Test
	public void testAmazon() throws Exception
	{
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("T-Shirts", Keys.ENTER);
               
        SoftAssert softAssert = new SoftAssert();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.in : T-Shirts";       
        softAssert.assertEquals(actualTitle, expectedTitle, "Amazon title is mismatched");
        softAssert.assertAll();
        Thread.sleep(3000);
	}
	
	@Test
	public void testAjio() throws Exception
	{
		driver.get("https://www.ajio.com/shop/kids");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        SoftAssert softAssert = new SoftAssert();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Online Kids fashion shopping site in India - AJIO";       
        softAssert.assertEquals(actualTitle, expectedTitle, "Ajio title is mismatched");
        softAssert.assertAll();
        Thread.sleep(3000);
	}
	
	@Test 
	public void assertOrangeHRMLoginTest() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        SoftAssert softAssert = new SoftAssert();
        
        // Title assertion
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";       
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
        
        // URL assertion
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";       
        softAssert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");
        
        // Text assertion
        String actualText = driver.findElement(By.name("username")).getAttribute("value");
        String expectedText = "Admin";
        softAssert.assertEquals(actualText, expectedText, "Username Text is mismatched");
        
        // Text assertion
        String actualBorder = driver.findElement(By.name("password")).getCssValue("border");
        String expectedBorder = "0.666667px solid rgb(235, 9, 16)";       
        softAssert.assertEquals(actualBorder, expectedBorder, "Border is mismatched");
        
        // ErrorMessage assertion
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//span")).getText();
        String expectedErrorMessage = "Required";       
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message is mismatched");

        softAssert.assertAll();
        Thread.sleep(3000);
	}
}
