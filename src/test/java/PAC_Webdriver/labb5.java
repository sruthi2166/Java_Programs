package PAC_Webdriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 

public class labb5 {
    public static void main(String[] args) {
    	
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Set WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the registration page
        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        // Wait for the first name field to be visible
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstName.sendKeys("John");

        String longFirstName = "LZAAFEGSWVRHMUPKNDYIFDCQEBCTOXJB";
        firstName.clear();
        firstName.sendKeys(longFirstName);
        String enteredFirstName = firstName.getAttribute("value");

        if (enteredFirstName.length() > 32) {
            System.out.println("Exceeded character limit for First Name.");
        } else {
            System.out.println("First Name accepted: " + enteredFirstName);
        }

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Doe");
        
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("johndoer@example.com");
        
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Password12345");
        
        
        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
        newsletterYes.click();

        
        WebElement agreePrivacy = driver.findElement(By.name("agree"));
        agreePrivacy.click();
        
       
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        continueButton.click();
 
        
        if (driver.getPageSource().contains("Your Account Has Been Created!")) {
            System.out.println("Account successfully created.");
        } else {
            System.out.println("Account creation failed.");
        }
        
        
        WebElement orderHistoryLink = driver.findElement(By.linkText("View your order history"));
        orderHistoryLink.click();
        
        
        driver.quit();
    }
}
