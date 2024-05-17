package TESTNGASSESSMENT_LT.TESTNGASSESSMENT_LT;

import org.testng.annotations.Test;
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

public class TestScenario3 {
	WebDriver driver;
	
	@Parameters({"Browser3"})
	@BeforeMethod
	public void SetCapabilities(String Browser3) {
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "dswathi2101");
		ltOptions.put("accessKey", "jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("build", "Build_1439");
		ltOptions.put("project", "Project_1439");
		ltOptions.put("name", "Scenario3");
		//ltOptions.put("tunnel", true);
		//ltOptions.put("console", "error");
		//ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		if(Browser3.equalsIgnoreCase("Chrome"))
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
		else if(Browser3.equalsIgnoreCase("firefox"))
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
		else if(Browser3.equalsIgnoreCase("Edge"))
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
	public void Scenario3() {

		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Click Me')]")).click();
		Alert alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		System.out.println(alertmessage);
		if (alertmessage.equalsIgnoreCase("I am an alert box!"))
		{
			System.out.println("alert message displayed is correct");
		}
		else {
			System.out.println("alert message displayed is not correct");
		}
		alert.accept();
	
}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}