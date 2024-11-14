package failedScreenshots;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ITestListenerClass extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenshot(result.getTestContext().getName()+ "_"+ result.getMethod().getMethodName()+ ".jpg");
		
		Reporter.setCurrentTestResult(result);
		File img = new File("./Screenshots/"+ screenshotSubFolderName +"/"+ result.getTestContext().getName()+ "_"+ result.getMethod().getMethodName()+ ".jpg");
		FileOutputStream screenshotStream = null;
		try {
			screenshotStream = new FileOutputStream(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			screenshotStream.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
		try {
			screenshotStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Defect- "+result.getTestContext().getName()+ "_"+ result.getMethod().getMethodName() +" <a href='"+img.getAbsolutePath()+"'> <img src='"+ img.getAbsolutePath()+"' height='200' width='300'/> </a>");
	}
}
