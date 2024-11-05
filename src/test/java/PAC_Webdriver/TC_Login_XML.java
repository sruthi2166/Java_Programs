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

//import org.apache.poi.xwpf.usermodel.Document;
import org.openqa.selenium.By;
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

public class TC_Login_XML {
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
		
		File xmlfile=new File("C:\\Users\\sruthi.katapally\\eclipse-workspace\\oct2024\\login.XML");
		DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder DBBuilder=DBFactory.newDocumentBuilder();
		Document DBDoc=(Document) DBBuilder.parse(xmlfile);
		
		NodeList NL=((Node)DBDoc).getChildNodes();
		System.out.println("Node list count:"+NL.getLength());
		Node n=NL.item(0);
		System.out.println("Node:"+n.getNodeName());
		Element ele=(Element)n;
		
		String url=ele.getElementsByTagName("url1").item(0).getTextContent();
		String uname=ele.getElementsByTagName("username1").item(0).getTextContent();
		String pword=ele.getElementsByTagName("password1").item(0).getTextContent();
		
		System.out.println("username:"+uname);
		System.out.println("password:"+pword);
		
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		LOGIN_POM obj=new LOGIN_POM(driver);
		
		
		driver.get(url);
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
