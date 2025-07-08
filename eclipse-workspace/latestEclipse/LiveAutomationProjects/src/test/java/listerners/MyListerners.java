package listerners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.CommonUtils;

public class MyListerners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	public WebDriver driver;

	@Override
	public void onStart(ITestContext context) {
		extentReport = CommonUtils.getExtentReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + "Test Execution Started");
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + "Test Got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.FAIL, result.getName() + "Test Got Failed");

		File scrScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshot = System.getProperty("user.dir"+"\\ScreenShot\\"+testName+".png");
		try {
			FileHandler.copy(scrScreenshot, new File(destinationScreenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getName() + "Test Got Skiled");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
//		try {
//			Desktop.getDesktop().browse(null);
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
	}

}
