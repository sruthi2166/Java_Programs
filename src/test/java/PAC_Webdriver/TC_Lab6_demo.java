package PAC_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class TC_Lab6_demo {
 
 
	
	    public static void main(String[] args) throws InterruptedException {
	        // Set up WebDriver for Edge browser
	        WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        // Maximize the window and clear cookies
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        // Step 1: Login with credentials
	        driver.get("https://demo.opencart.com/en-gb?route=account/login");
	        driver.findElement(By.id("input-email")).sendKeys("katapallysruthi@gmail.com"); // Email from Lab 1
	        driver.findElement(By.id("input-password")).sendKeys("Opencart@2025");               // Password from Lab 1
	        // Perform login
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary')]")));
	        js.executeScript("arguments[0].click();", loginButton);
	        // Go to Components tab and click
	        WebElement componentsTab = driver.findElement(By.xpath("//a[text()='Components']"));
	        componentsTab.click();
	        // Step 3: Select 'Monitors' from the dropdown
	        WebElement monitorsLink = driver.findElement(By.xpath("//a[text()='Monitors (2)']"));
	        js.executeScript("arguments[0].click();", monitorsLink);
	        // Change the dropdown limit to 25
	        WebElement limitDropdown = driver.findElement(By.id("input-limit"));
	        js.executeScript("arguments[0].value='https://demo.opencart.com/en-gb/catalog/component/monitor?limit=25';", limitDropdown);
	        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", limitDropdown);
	        // Step 4: Click on Add to Cart for the first product
	        WebElement cartButton = driver.findElement(By.xpath("//div[@id='product-list']/div[1]//button[@type='submit' and @aria-label='Add to Cart']"));
	        js.executeScript("arguments[0].click();", cartButton);
	    }
}