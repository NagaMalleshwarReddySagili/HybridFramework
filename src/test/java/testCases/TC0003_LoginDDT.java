package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
//-->Data is valid - login sucess - test passed - logout
//					 login failed - test fail
//-->Data is invalid - login sucesses - test fail - logout
// 					    login failed -  test pass

public class TC0003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven")
	public void verify_LoginDDT(String email,String pwd,String expr) {
		logger.info("*********************TC0003_LoginDDT testcase started*******************");
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.Ac_Click();
		hp.login_Click();
		
		//loginpage
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(email);
		lp.SetPassword(pwd);
		lp.Click_login();
		
		//MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		Boolean targetPage=map.verifyMsg();
		
		if(expr.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				map.Logout_Click();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(expr.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				map.Logout_Click();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*************************TC0003_LoginDDT test case finished*******************");
	}
}
