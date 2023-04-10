package MyTestNGPakage;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
WebDriver driver;

@BeforeMethod
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Santoshkumar S\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
@Test
public void VerifyTitle()
{
String ActualTitle = driver.getTitle();	
String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

Assert.assertEquals(ActualTitle, ExpectedTitle);
}
@Test
public void VerifyLogo()
{
boolean flag = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();

Assert.assertTrue(flag);
} 

@Test
public void VerifyProduct()
{
driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Realme Mobiles");
driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
driver.findElement(By.linkText("realme C35 (Glowing Green, 4GB RAM, 64GB Storage)")).click();
}

@Test
public void Electronics()
{
driver.findElement(By.xpath("//a[@class='nav-a  ']")).click();
//driver.findElement(By.xpath("//a[.=' Electronics ']")).click();

}

@AfterMethod
	public void teardown()
	{
	driver.quit();	
	}
}
