package TESTNGASSESSMENT_LT.TESTNGASSESSMENT_LT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class TestScenario2 {
	WebDriver driver;
	
	@Parameters({"Browser2"})
	@BeforeMethod
	public void SetCapabilities(String Browser2) {
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "dswathi2101");
		ltOptions.put("accessKey", "jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("build", "Build_1439");
		ltOptions.put("project", "Project_1439");
		ltOptions.put("name", "Scenario2");
		//ltOptions.put("tunnel", true);
		//ltOptions.put("console", "error");
		//ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		if(Browser2.equalsIgnoreCase("Chrome"))
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
		else if(Browser2.equalsIgnoreCase("firefox"))
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
		else if(Browser2.equalsIgnoreCase("Edge"))
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
	public void Scenario2() {

		driver.findElement(By.linkText("Checkbox Demo")).click();
		WebElement element = driver.findElement(By.id("isAgeSelected"));
// here we click the checkbox and verify that it is selected or not. 		
		element.click();
		if(element.isSelected())
		{
			System.out.println("Checkbox is selected");
		}
		else {
			System.out.println("Checkbox is not selected");
		}
//here we unclick the checkbox and verify that it is selected or not.
		element.click();
		if(element.isSelected())
		{
			System.out.println("Checkbox is selected");
		}
		else {
			System.out.println("Checkbox is  not selected");
		}

	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}