package LambdatestAssessment.LambdatestAssessment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Scenario3 {
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
		ltOptions.put("name", "LT_Sel_Scenario3");
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
	public void scenario3() throws InterruptedException {
		
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Submit')]")).click();
		String ErrorMessage = driver.findElement(By.id("name")).getAttribute("validationMessage");
		System.out.println(ErrorMessage);
		Assert.assertEquals(ErrorMessage, "Please fill out this field.");
		driver.findElement(By.id("name")).sendKeys("Name1");
		driver.findElement(By.id("inputEmail4")).sendKeys("email@abc.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.id("company")).sendKeys("Com1 LLP");
		driver.findElement(By.id("websitename")).sendKeys("https://lanmbdatest.com");
		Select select = new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText("United States");
		driver.findElement(By.name("city")).sendKeys("India");
		driver.findElement(By.name("address_line1")).sendKeys("Independence pkwy");
		driver.findElement(By.id("inputAddress2")).sendKeys("FortWorth");
		driver.findElement(By.id("inputState")).sendKeys("Texas");
		driver.findElement(By.name("zip")).sendKeys("12345");
	    driver.findElement(By.xpath("//*[contains(text(), 'Submit')]")).click();
	    String msg = driver.findElement(By.xpath("//*[contains(@class, 'success-msg hidden')]")).getText();
		System.out.println(msg);
		WebElement msg1 = driver.findElement(By.xpath("//*[contains(text(), 'Thanks for contacting us, we will get back to you shortly.')]"));
		Assert.assertTrue(msg1.isDisplayed());
		driver.executeScript("lambda-status=passed");
		
	}

 @AfterMethod
 public void tearDown() {
	 driver.close();
	 
 }
}
