package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//	WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//span[text()='My Account']") WebElement account;
	@FindBy(xpath="//a[text()='Register']") WebElement register;
	@FindBy(xpath="//a[text()='Login']") WebElement loginbtn;
	
	//Action Methods
	public void Ac_Click() {
		account.click();
	}
	
	public void rg_Click() {
		register.click();
	}
	
	public void login_Click() {
		loginbtn.click();
	}

}
