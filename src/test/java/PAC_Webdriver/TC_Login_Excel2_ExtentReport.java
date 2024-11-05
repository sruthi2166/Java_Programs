package PAC_Webdriver;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xwpf.usermodel.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC_Login_Excel2_ExtentReport {
	@Test		
	 public void login() throws InterruptedException,IOException, ParserConfigurationException, SAXException
	{
		String projectpath=System.getProperty("user.dir");
		
	/*Properties prob=new Properties();
	InputStream input=new FileInputStream(projectpath+"\\login.properites");
	prob.load(input);
	String opencart_url=prob.getProperty("url");
	String uname=prob.getProperty("username");
	String pword=prob.getProperty("password");
	*/	
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("r1.html");
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title");
		
		
		FileInputStream input=new FileInputStream("C:\\Users\\sruthi.katapally\\eclipse-workspace\\oct2024\\login.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet("login");
		
		int noofrows=sheet.getPhysicalNumberOfRows();
		
		System.out.println("rows:"+noofrows);
		
		
		for(int j=0;j<noofrows;j++)
		{
		String url=sheet.getRow(j).getCell(0).getStringCellValue();
		String uname=sheet.getRow(j).getCell(1).getStringCellValue();
		String pword=sheet.getRow(j).getCell(2).getStringCellValue();	
		System.out.println("username:"+uname);
		System.out.println("password:"+pword);
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		LOGIN_POM obj=new LOGIN_POM(driver);
		
		
		driver.get(url);
		Thread.sleep(3000);
		if(driver.getTitle().equals("Your Store "))
		{
			test.pass("title is matched");
		}
		else
		{
//			test.fail("title is not matched");
			
			File ssfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ssfile, new File("f1.jpg"));
			test.fail("Title is not matched"+test.addScreenCaptureFromPath("C:\\Users\\sruthi.katapally\\eclipse-workspace\\oct2024\\s1.jpg"));
		}
		
		
		//Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(20000);
		//driver.findElement(By.id("input-email")).sendKeys("katapallysruthi@gmail.com");
		obj.enterusername(uname);
		//driver.findElement(By.id("input-password")).sendKeys("Sruthi21");
		obj.enteruserpassword(pword);
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		obj.clickloginbutton();
		
		
		
//	driver.quit();
	extent.flush();

	}

}
}