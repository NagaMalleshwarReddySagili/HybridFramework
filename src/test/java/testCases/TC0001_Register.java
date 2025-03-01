package testCases;

//import java.time.Duration;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0001_Register extends BaseClass {
	
	@Test(groups= {"regression", "master"})
	public void verify_account_registration() {
		logger.info("*********** TC0001_ Account Register started *********** ");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.Ac_Click();
		logger.info("here Clicked My account element");
		hp.rg_Click();
		logger.info(" here Clicked register element");
		
		AccountRegisterPage arp=new AccountRegisterPage(driver);
		logger.info("here providing customer details for account registration");
		arp.setFirstName(randomString());
		arp.setLastName(randomString());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTelephone(randomnumberic());
		String pwd=alphanumeric();
		arp.setPassword(pwd);
		arp.confirmPwd(pwd);
		arp.subscribebtn();
		arp.Agreebtn();
		arp.submit_btn();
		
		logger.info("Validationg conformation Message");
		String Confirm_account=arp.msg();
		Assert.assertEquals(Confirm_account,"Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed....");
			logger.debug("Debug logs....");
			Assert.fail();
		}
		logger.info("*********** TC0001_ Account Register Finished ***********");
	}
}
