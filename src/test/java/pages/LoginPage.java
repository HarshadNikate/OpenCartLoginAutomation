package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submit")
	WebElement submitbtn;
	
	@FindBy(xpath="//p[@class='has-text-align-center']/strong")
	WebElement actualText;
	
	@FindBy(linkText="Log out")
	WebElement logoutbtn;
	
	@FindBy(id="error")
	WebElement Errormsg;
	

	
   public void login(String usern,String pass)
   {
	  username.sendKeys(usern);
	  password.sendKeys(pass);
   }
   
   public void clickSubmitBtn()
   {
	   submitbtn.click();
   }
   
   public String getSuccessfullmsg()
   {
	  return actualText.getText();
   }
   
   public String getLoginPageUrl()
   {
	  return driver.getCurrentUrl();
   }
   
   public boolean isLoginBtnDisplayed()
   {
	 return  logoutbtn.isDisplayed();
   }
   
   public boolean isErrorMsgDisplayed()
   {
	  return Errormsg.isDisplayed();
   }
   
   public String getErrorMsg()
   {
	   return Errormsg.getText();
   }
   
	

	
}
