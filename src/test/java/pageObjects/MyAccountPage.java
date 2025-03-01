package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//div[@id='content']/h2[1]") WebElement myAcc_Msg;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement Logout_btn;
	
	//Actions
	public Boolean verifyMsg() {
		try {
		return (myAcc_Msg.isDisplayed());
		} catch(Exception e) {
			return false;
		}
	}
	
	public void Logout_Click() {
		Logout_btn.click();
	}

}
