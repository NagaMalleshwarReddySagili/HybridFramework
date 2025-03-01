package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//for logmanager
import org.apache.logging.log4j.Logger;//for loggerclass
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger; //log4j
public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"OS", "Browser"})
	public void driverSteUp(String os,String br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("Linux")){
				capabilities.setPlatform(Platform.LINUX);
			}else
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			default: System.out.println("No matching browser"); return;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.29.159:4444/wd/hub"), capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			default : System.out.println("Browser is invalid .....");return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@SuppressWarnings("deprecation")
	public String randomString() {
		String random=RandomStringUtils.randomAlphabetic(5);
		return random;
	}
	
	@SuppressWarnings("deprecation")
	public String randomnumberic() {
		String number=RandomStringUtils.randomNumeric(10);
		return number;
	}
	
	@SuppressWarnings("deprecation")
	public String alphanumeric() {
		String random=RandomStringUtils.randomAlphabetic(5);
		String number=RandomStringUtils.randomNumeric(10);
		return random+"$"+number;
	}
	
	public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname + "_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
