package PAC_Webdriver;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab_5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
//part-1-LAUNCH APP
        driver.get("https://demo.opencart.com/en-gb?route=account/register");
        
        
//part-2-PERSONAL DETAILS
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("sruthi");
 
        String longFirstName = "sruthi";
        firstName.clear();
        firstName.sendKeys(longFirstName);
        String enteredFirstName = firstName.getAttribute("value");
 
        if (enteredFirstName.length() > 32) {
            System.out.println("Exceeded character limit for First Name.");
        } else {
            System.out.println("First Name accepted: " + enteredFirstName);
        }
 
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Katapally");
 
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("sruthik@example.com");
        
        
//part-4-PASSWORD
        WebElement password = driver.findElement(By.id("input-password"));
        String passwordValue = "Pass1234";
        password.sendKeys(passwordValue);
 
        if (passwordValue.length() < 4 || passwordValue.length() > 20) {
            System.out.println("Password must be between 4 and 20 characters.");
        } else {
            System.out.println("Password is valid.");
        }
 
//NEWSLETTER
        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsletterYes);
 
        WebElement agreePrivacy = driver.findElement(By.name("agree"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreePrivacy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreePrivacy);
      
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(Exception.class);
 
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit' or @value='Continue' or contains(text(), 'Continue')]")));
 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
 
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), 'Your Account Has Been Created!')]")));
            System.out.println("Account successfully created.");
        } catch (Exception e) {
            System.out.println("Account creation failed. Please check for errors.");
        }
 
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
 