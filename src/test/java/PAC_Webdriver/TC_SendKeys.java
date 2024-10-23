package PAC_Webdriver;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC_SendKeys {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/en-gb?route=account/register");
		
		driver.findElement(By.id("input-firstname")).sendKeys("Sruthi");
		
		driver.findElement(By.id("input-firstname")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("input-lastname")).sendKeys("Keys.NUMPAD7");
		
		WebElement subscribe=driver.findElement(By.name("newsletter"));
		
		
		if(subscribe.isSelected())
		{
			System.out.println("Subscribe");
		}
		else
			System.out.println("Not Subscribe");
		
	}
	
	
}
