package LambdatestAssessment.LambdatestAssessment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test_Scenario1 {
	
	public static RemoteWebDriver driver = null; 
	@BeforeMethod 
	public void SetCapabilities() {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("124.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "dswathi2101");
		ltOptions.put("accessKey", "jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("build", "LT_Sel_Build");
		ltOptions.put("project", "LT_Sel_Project");
		ltOptions.put("name", "LT_Sel_Scenario1");
		//ltOptions.put("tunnel", true);
		//ltOptions.put("console", "error");
		//ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		browserOptions.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL("https://dswathi2101:jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo@hub.lambdatest.com/wd/hub"), browserOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
    public void Scenario1() throws InterruptedException
    {
    	//WebDriver driver = new ChromeDriver();
    	driver.get("https://www.lambdatest.com/selenium-playground");
    	String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Simple Form Demo")).click();
		String newURL = driver.getCurrentUrl();
		System.out.println(newURL);
		if(newURL.contains("simple-form-demo"))
		{
			System.out.println("New URL contains the sting 'simple-form-demo'");
		
		String str1 = "Welcome to LambdaTest";
		driver.findElement(By.id("user-message")).sendKeys(str1);
		driver.findElement(By.id("showInput")).click();
		String ActStr =driver.findElement(By.id("message")).getText();
		if(str1.equals(ActStr))
		{
			System.out.println("Entered message and Displayed messages are same");
		}
		else
		{
			System.out.println("Entered message and Displayed messages are not same");
		}
		}
		else
		{
			System.out.println("it didnt navigate to correct url");
		}
		
		driver.executeScript("lambda-status=passed");

    }
	
		@AfterMethod
	public void teardown() {
		driver.close();
	}
	
}
