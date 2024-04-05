package LambdatestAssessment.LambdatestAssessment;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action; 
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;


public class Test_Scenario2 {
	
	public static RemoteWebDriver driver = null; 
	@BeforeMethod 
	public void SetCapabilities() {
		FirefoxOptions browserOptions = new FirefoxOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("125.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "dswathi2101");
		ltOptions.put("accessKey", "jHNTQNt1RGaxPkVZ1vEAARmgfdCu27C5eoiMH4flmqfAmOMiqo");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("build", "LT_Sel_Build");
		ltOptions.put("project", "LT_Sel_Project");
		ltOptions.put("name", "LT_Sel_Scenario2");
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
	public void Scenario2() throws InterruptedException {

	//WebDriver driver = new ChromeDriver(); 
	driver.get("https://www.lambdatest.com/selenium-playground");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.findElement(By.linkText("Drag & Drop Sliders")).click();
	WebElement slider = driver.findElement(By.xpath("//div[contains(@id, 'slider3')]"));
	Actions move = new Actions(driver);
	Action action = (Action)move.dragAndDropBy(slider, 195, 0).build();
	action.perform();
	String range2 = driver.findElement(By.id("rangeSuccess")).getText();
	System.out.println("dragged the slider till " + range2);
	driver.executeScript("lambda-status=passed");

}
	
	@AfterMethod
	public void rearDown() {
		driver.close();
	}
}
