package Lucks_Project1.Lucks_Project1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	
	RemoteWebDriver driver = null;
	@Parameters({"browser"})
	@BeforeMethod	
	public void setup(String browser) throws InterruptedException {
		if(browser.equals("chrome"))
		{
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("121.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "akhila.p2103");
		ltOptions.put("accessKey", "G8sonQP7xHLdcjqPwgWLeLr2VnvQaukf2Pc5h6fGTDfVkiXjuc");
		ltOptions.put("build", "SG_Build1");
		ltOptions.put("project", "Lucky_test_Assessment");
		ltOptions.put("name", "Test1");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		browserOptions.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL("https://akhila.p2103:G8sonQP7xHLdcjqPwgWLeLr2VnvQaukf2Pc5h6fGTDfVkiXjuc@hub.lambdatest.com/wd/hub"), browserOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("121.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "akhila.p2103");
			ltOptions.put("accessKey", "G8sonQP7xHLdcjqPwgWLeLr2VnvQaukf2Pc5h6fGTDfVkiXjuc");
			ltOptions.put("build", "SG_Build1");
			ltOptions.put("project", "Lucky_test_Assessment");
			ltOptions.put("name", "Test1");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			browserOptions.setCapability("LT:Options", ltOptions);
			try {
				driver = new RemoteWebDriver(new URL("https://akhila.p2103:G8sonQP7xHLdcjqPwgWLeLr2VnvQaukf2Pc5h6fGTDfVkiXjuc@hub.lambdatest.com/wd/hub"), browserOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}	
		@Test(priority = 1)
		public void test1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Submit')]")).click();
		String ErrorMessage = driver.findElement(By.id("name")).getAttribute("validationMessage");
		System.out.println(ErrorMessage);
		Assert.assertEquals(ErrorMessage, "Please fill out this field.");
	
}
		@Test(priority = 2)
		public void test2() {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.lambdatest.com/selenium-playground");
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
		}
		@Test(priority = 3)
		public void test3() {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.findElement(By.linkText("Drag & Drop Sliders")).click();
			WebElement slider = driver.findElement(By.xpath("//div[contains(@id, 'slider3')]"));
			Actions move = new Actions(driver);
			Action action = (Action)move.dragAndDropBy(slider, 195, 0).build();
			action.perform();
			String range2 = driver.findElement(By.id("rangeSuccess")).getText();
			System.out.println("dragged the slider till " + range2);	
	}
		@AfterMethod
		public void teardown() {
			driver.close();
		}
		}
