package selemvn;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleSampleApp {

	public String bname = "firefox";
	public String url = "https://selenium.dev";
	public WebDriver driver;
	
	@BeforeClass
	public void bc() {
		System.setProperty("webdriver.chrome.driver", "C:\\Sonal\\Softwares\\exe\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Sonal\\Softwares\\exe\\geckodriver.exe");
		
		
		if(bname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));//Global and applies all pages
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Global wait time applies to all elements
	}
	
	@Test(priority=2)
	public void launchDocumentation() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Documentation']")).click();
		System.out.println("Cliked on Documentation link");	
	}
	
	@Test(priority=3)
	public void launchWebDriver() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='WebDriver']")).click();
		System.out.println("Cliked on WebDriver link");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("In after class");
		driver.quit();
	}
}
