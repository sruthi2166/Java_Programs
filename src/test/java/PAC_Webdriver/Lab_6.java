package PAC_Webdriver;


import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class Lab_6 {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.in/");
		//Login
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("7680969526");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Sruthi21");
		driver.findElement(By.id("signInSubmit")).click();
		//Search
		WebElement Search=driver.findElement(By.id("twotabsearchtextbox"));
		Search.sendKeys("Monitors");
		Search.submit();
		//Dropdown
		driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
		driver.findElement(By.id("s-result-sort-select_1")).click();
		//Scroll
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300);");
		Thread.sleep(8000);
		//AddToCart
		WebElement item=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a"));
		item.click();
		String itemName=item.getText();
		ArrayList<String> list=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.navigate().back();
		driver.findElement(By.id("add-to-wishlist-button-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement monitor=driver.findElement(By.xpath("//a[@id='huc-item-link']/span"));
		System.out.println(monitor.getText());
		System.out.println(itemName);
		//Product Wishlist verification
		if(monitor.getText().equals(itemName)) {
			System.out.println("Success You have added "+itemName);
			js.executeScript("alert('Success You have added '+ arguments[0])",itemName);
		}
		Thread.sleep(2000);
		Alert Alt=driver.switchTo().alert();
		Alt.accept();
		//close Wishlist
		driver.findElement(By.xpath("//*[@id=\"a-popover-3\"]/div/header/button")).click();
		//Search Mobile in SearchBox
		WebElement SearchMobile=driver.findElement(By.id("twotabsearchtextbox"));
		SearchMobile.clear();
//		SearchMobile.sendKeys("");
		SearchMobile.sendKeys("Mobile");
		SearchMobile.submit();
		//checkBox
		WebElement Apple=driver.findElement(By.xpath("//*[@id=\"p_123/110955\"]/span/a"));
		Apple.click();
		driver.findElement(By.id("nav-cart")).click();

//		js.executeScript("'//*[@id=\"nav-link-accountList\"]'.hover()");


 
	}
 
}
