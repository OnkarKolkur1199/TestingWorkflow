package failedScreenshots;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCalss extends BaseTest {

	@Test(priority = 1)
	public void testDemoBlazeProductCOunt() throws Exception {
//		driver.get("https://www.amazon.in/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("T-Shirts", Keys.ENTER);
//               
//        SoftAssert softAssert = new SoftAssert();
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Amazon.in : T-Shirts";       
//        softAssert.assertEquals(actualTitle, expectedTitle, "Amazon title is mismatched");
//        softAssert.assertAll();
//        Thread.sleep(3000);

		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Phones
		driver.findElement(By.xpath("//a[@id='itemc'][1]")).click();
		List<WebElement> myPhones = driver.findElements(By.xpath("//a[@class='hrefch']"));
		int phoneCount = myPhones.size();
		System.out.println("There are " + phoneCount + " phones present on the website.");

		// Laptops
		driver.findElement(By.xpath("//a[@id='itemc'][2]")).click();
		List<WebElement> myLaptops = driver.findElements(By.xpath("//a[@class='hrefch']"));
		int laptopCounts = myLaptops.size();
		System.out.println("There are " + laptopCounts + " laptops present on the website.");

		// Monitors
		driver.findElement(By.xpath("//a[@id='itemc'][3]")).click();
		List<WebElement> myMonitors = driver.findElements(By.xpath("//a[@class='hrefch']"));
		int monitorCounts = myMonitors.size();
		System.out.println("There are " + monitorCounts + " monitores present on the website.");

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testTricentisLogin() throws Exception {
//		driver.get("https://www.ajio.com/shop/kids");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        
//        SoftAssert softAssert = new SoftAssert();
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Kids Fashion - Shop for Kids Clothes, Accessories & More";       
//        softAssert.assertEquals(actualTitle, expectedTitle, "Ajio title is mismatched");
//        softAssert.assertAll();
//        Thread.sleep(3000);

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[@class='ico-login']")).click();

		driver.findElement(By.xpath("//input[@type='text' and @class='email']")).sendKeys("onkarkolkur1999@gmail.com");
		driver.findElement(By.xpath("//input[@type='password' and @class='password']")).sendKeys("Happy@1199");
		driver.findElement(By.xpath("//input[@type='submit' and @class='button-1 login-(button)']")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testSauceDemoDummyLogin() throws Exception {
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//		SoftAssert softAssert = new SoftAssert();
//
//		// Title assertion
//		String actualTitle = driver.getTitle();
//		String expectedTitle = "OrangeHRM";
//		softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
//
//		// URL assertion
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//		softAssert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");
//
//		// Text assertion
//		String actualText = driver.findElement(By.name("username")).getAttribute("value");
//		String expectedText = "Admin";
//		softAssert.assertEquals(actualText, expectedText, "Username Text is mismatched");
//
//		// Text assertion
//		String actualBorder = driver.findElement(By.name("password")).getCssValue("border");
//		String expectedBorder = "0.690647px solid rgb(235, 9, 16)";
//		softAssert.assertEquals(actualBorder, expectedBorder, "Border is mismatched");
//
//		// ErrorMessage assertion
//		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//span")).getText();
//		String expectedErrorMessage = "Required";
//		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message is mismatched");
//
//		softAssert.assertAll();
//		Thread.sleep(3000);

		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);

		Boolean logo = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if (logo == true) {
			System.out.println("Login Success");
		} else {
			System.out.println("Login Fail");
		}
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}
}
