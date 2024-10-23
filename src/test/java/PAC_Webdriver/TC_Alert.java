package PAC_Webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.id("login1")).sendKeys("uname1");
		
		driver.findElement(By.name("proceed")).click();
		
		Alert simplealert=driver.switchTo().alert();
		
		System.out.println("Alert message:"+simplealert.getText());
		simplealert.accept();
		
		driver.navigate().to("https://leetcode.com/alert");
		
		driver.findElement(By.id("accept"));
		Alert simplealert1=driver.switchTo().alert();
		System.out.println("Alert message:"+simplealert1.getText());
		simplealert1.accept();
		
		driver.findElement(By.id("confrim"));
		Alert confrim=driver.switchTo().alert();
		System.out.println("Alert message:"+confrim.getText());
		confrim.accept();
		
		driver.findElement(By.id("prompt")).click();
		Alert prompt=driver.switchTo().alert();
		System.out.println("Alert message:"+prompt.getText());
		prompt.sendKeys("kkkkkk");
		prompt.accept();
	}


}
