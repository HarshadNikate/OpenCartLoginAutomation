package tests;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Login  {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		String browserName= "firefox";
		
		if(browserName.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equals("safari"))
		{
			driver= new SafariDriver();
		}
		else if(browserName.equals("ie"))
		{
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test(priority=3)
	public void testValidLogin()
	{
		LoginPage login=new LoginPage(driver);
		login.login("student", "Password123");
		
		login.clickSubmitBtn();
		
		
		String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(login.getLoginPageUrl(), expectedUrl);
		
		String expectedText = "Congratulations student. You successfully logged in!";	
		Assert.assertEquals(login.getSuccessfullmsg(), expectedText);
		
		Assert.assertTrue(login.isLoginBtnDisplayed());
		
		driver.quit();
	}
	
	@Test(priority=2)
	public void testInvalidusername()
	{
		LoginPage login=new LoginPage(driver);
		login.login("stude", "Password123");
		
		login.clickSubmitBtn();
		
		Assert.assertTrue(login.isErrorMsgDisplayed());
		
		String ExpectedErrormsg = "Your username is invalid!";
		Assert.assertEquals(login.getErrorMsg(),ExpectedErrormsg);
	}
	
	@Test(priority=1)
	public void testInvalidpassword()
	{
		LoginPage login=new LoginPage(driver);
		login.login("student", "sword123");
		login.clickSubmitBtn();
		
		Assert.assertTrue(login.isErrorMsgDisplayed());
		
		String ExpectedPasserromsg = "Your password is invalid!";
		Assert.assertEquals(login.getErrorMsg(),ExpectedPasserromsg);
	}

}
