package PAC_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LOGIN_POM {

By username=By.id("input-email");
By userpassword=By.id("input-password");
By loginbutton=By.xpath("//button[@type='submit']");
WebDriver driver;



public LOGIN_POM(WebDriver driver) {
	this.driver=driver;
	
}
void enterusername(String email)
{
	driver.findElement(username).sendKeys(email);
}

void enteruserpassword(String password)
{
	driver.findElement(userpassword).sendKeys(password);
}

void clickloginbutton()
{
	driver.findElement(loginbutton).click();
}
}
