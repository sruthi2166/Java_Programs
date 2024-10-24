package PAC_Webdriver;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Google {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Implicity wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		driver.get(" https://www.google.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('Search Testing method');");
		
		Thread.sleep(30000);
		
		//pageload timeout
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		System.out.println("Title of the page is:"+driver.getTitle());
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));	
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		
		Wait wait1=new FluentWait(driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(5))
		.ignoring(NoSuchElementException.class);
		
		ele.sendKeys("Testing Method");
		ele.submit();
		
		
		 //Thread.sleep(3000);
	
		System.out.println("Title of the page is:"+driver.getTitle());
		
		driver.navigate().to("https://in.yahoo.com/");
		System.out.println("Title of the page is:"+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Title of the page is:"+driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("Title of the page is:"+driver.getTitle());
		
		System.out.println("URL is:"+driver.getCurrentUrl());
		
		System.out.println("page source:"+driver.getPageSource());
		
		
		System.out.println("page source is:"+driver.getPageSource().contains("yahoo"));
		
		
		
		
		
		
		 //driver.close();

	}
	
}