package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Helpers;

import Pages.TempBuddyLoginPage;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeMethod
	public void setUp(){
		
		report = new ExtentReports("./Reports/LoginPageReport.html", true);
		logger = report.startTest("Login page method");
		
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void LoginPage(){
		TempBuddyLoginPage login = PageFactory.initElements(driver, TempBuddyLoginPage.class);
		login.LogInAgencyPortal(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			String path = Helpers.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
