package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC0002_Login extends BaseClass {
	
	@Test(groups= {"sanity", "master"})
	public void LoginTest() {
		logger.info("*********************TC0002_Login Test Case Started***********************");
		try {
		HomePage hp=new HomePage(driver);
		hp.Ac_Click();
		hp.login_Click();
		logger.info("Sending user details like email password");
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(p.getProperty("email"));
		lp.SetPassword(p.getProperty("password"));
		lp.Click_login();
		
		MyAccountPage map=new MyAccountPage(driver);
		Boolean status=map.verifyMsg();
		logger.info("Verifying My account page is opend or not");
		//Assert.assertEquals(status,true);
		Assert.assertTrue(status);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("**************************TC0002_Login Test Case finished*********************");
	}

}
