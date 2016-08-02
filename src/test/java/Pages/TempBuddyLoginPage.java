package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempBuddyLoginPage {
	
	WebDriver driver;
	
	//Idriver always comes from our Testcase
	public TempBuddyLoginPage(WebDriver Idriver){
		
		//global driver is assigned to the local driver
		this.driver = Idriver;
	}
	
	@FindBy(id="username") WebElement LoginUsername;
	@FindBy(id="password") WebElement LoginPassword;
	@FindBy(xpath="//input[@value='Log In']") WebElement LogIn;
	
	public void LogInAgencyPortal(String user, String password){
		
		LoginUsername.sendKeys(user);
		LoginPassword.sendKeys(password);
		LogIn.click();
	}

}
