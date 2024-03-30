package lucky_Package1;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class lucky_class1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//system.setproperty("webdriver.chrome.driver", "C:\\Users\\gunda\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\chromedriver.exe")
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("121.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "akhila.p2103");
		ltOptions.put("accessKey", "G8sonQP7xHLdcjqPwgWLeLr2VnvQaukf2Pc5h6fGTDfVkiXjuc");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("project", "lucky_Project1");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		browserOptions.setCapability("LT:Options", ltOptions);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Submit')]")).click();
		String ErrorMessage = driver.findElement(By.id("name")).getAttribute("validationMessage");
//		System.out.println(ErrorMessage);
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
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//driver.close();
		
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"))).build().perform();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[contains(text(),'Meet and Assist')]"));
		//Thread.sleep(3000);
		//driver.close();
		
		
		
		
		
	}


}
