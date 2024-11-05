package PAC_Webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
 
public class TC_Login_PageFactory {
	@Test
 
		
	 public void login() throws InterruptedException,IOException
	{
		String projectpath=System.getProperty("user.dir");
		
	Properties prob=new Properties();
	InputStream input=new FileInputStream(projectpath+"\\login.properites");
	prob.load(input);
	String opencart_url=prob.getProperty("url");
	String uname=prob.getProperty("username");
	String pword=prob.getProperty("password");
		
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		LOGIN_PageFactory obj=PageFactory.initElements(driver,LOGIN_PageFactory.class);
		
		driver.get("https://demo.opencart.com/en-gb?route=account/login");
		//Thread.sleep(10000);
		driver.manage().window().minimize();
		Thread.sleep(20000);
		//driver.findElement(By.id("input-email")).sendKeys("katapallysruthi@gmail.com");
		obj.enterusername("uname");
		//driver.findElement(By.id("input-password")).sendKeys("Sruthi21");
		obj.enteruserpassword("pword");
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		obj.clickloginbutton();
 
	}
 
}
