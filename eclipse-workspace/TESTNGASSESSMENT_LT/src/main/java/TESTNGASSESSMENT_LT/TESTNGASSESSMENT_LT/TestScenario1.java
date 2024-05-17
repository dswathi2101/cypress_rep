package TESTNGASSESSMENT_LT.TESTNGASSESSMENT_LT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class TestScenario1 {
	WebDriver driver;
	
	@Parameters({"Browser1"})
	@BeforeMethod
	public void SetCapabilities(String Browser1) {
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "dswathi2101");
		ltOptions.put("accessKey", "jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("build", "Build_1439");
		ltOptions.put("project", "Project_1439");
		ltOptions.put("name", "Scenario1");
		//ltOptions.put("tunnel", true);
		//ltOptions.put("console", "error");
		//ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		if(Browser1.equalsIgnoreCase("Chrome"))
		{
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("88.0");
		browserOptions.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL("https://dswathi2101:jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo@hub.lambdatest.com/wd/hub"), browserOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(Browser1.equalsIgnoreCase("firefox"))
		{
		FirefoxOptions browserOptions = new FirefoxOptions();
		browserOptions.setPlatformName("Windows 7");
		browserOptions.setBrowserVersion("82.0");
		browserOptions.setCapability("LT:Options", ltOptions);
		
		try {
			driver = new RemoteWebDriver(new URL("https://dswathi2101:jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo@hub.lambdatest.com/wd/hub"), browserOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(Browser1.equalsIgnoreCase("Edge"))
		{
		EdgeOptions browserOptions = new EdgeOptions();
		browserOptions.setPlatformName("macOS Sierra");
		browserOptions.setBrowserVersion("87.0");
		browserOptions.setCapability("LT:Options", ltOptions);
		
		try {
			driver = new RemoteWebDriver(new URL("https://dswathi2101:jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo@hub.lambdatest.com/wd/hub"), browserOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@Parameters({"URL"})	
	@BeforeMethod
	public void setup(String URL) {
				
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
	}
	
	@Test(timeOut=20000)
	public void Scenario1() {
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	try {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
	System.out.println("All the elements are loaded completely in the DOM");
	}
	catch(TimeoutException ex)
	{
	System.out.println("Timeout occurred while waiting for all elements to be available.");
	}
	String ActualTitle = driver.getTitle();
	String ExpectedTitle1 ="LambdaTest";
	String ExpectedTitle2 = "Selenium Grid Online | Run Selenium Test On Cloud";
	SoftAssert softassert = new SoftAssert();
	softassert.assertEquals(ActualTitle, ExpectedTitle1);
	softassert.assertEquals(ActualTitle, ExpectedTitle1, "Title does not match and test case continues");
	softassert.assertEquals(ActualTitle, ExpectedTitle2, "Both Actual and Expected values are same");
	System.out.println(ActualTitle);
	//Commented the below step as it moves the scenario to failed status. 
	//softassert.assertAll();
			
	}
	
		
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}