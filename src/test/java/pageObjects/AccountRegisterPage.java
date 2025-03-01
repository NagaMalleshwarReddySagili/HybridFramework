package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class AccountRegisterPage extends BasePage {
//	WebDriver driver;
	//constructors
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//Locatores
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirm_pwd;
	@FindBy(xpath="//label[@class=\"radio-inline\"]//input[@value='1']") WebElement subscribe_radiobtn;
	@FindBy(xpath="//input[@name='agree']") WebElement agree_radiobtn;
	@FindBy(xpath="//input[@type='submit']") WebElement submit_btn;
	@FindBy(xpath="//div[@id=\"content\"]/h1") WebElement confirm_msg;
	
	
	//Action methods
	
	public void setFirstName(String fname) {
		txt_firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txt_lastname.sendKeys(lname);
	}
	
	public void setEmail(String mail) {
		txt_email.sendKeys(mail);
	}
	
	public void setTelephone(String num) {
		txt_telephone.sendKeys(num);
	}
	
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void confirmPwd(String pwd) {
		txt_confirm_pwd.sendKeys(pwd);
	}
	
	public void subscribebtn() {
		subscribe_radiobtn.click();
	}
	
	public void Agreebtn() {
		agree_radiobtn.click();
	}
	
	public void submit_btn() {
		submit_btn.click();
	}
	
	public String msg() {
		try {
			return confirm_msg.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
}
