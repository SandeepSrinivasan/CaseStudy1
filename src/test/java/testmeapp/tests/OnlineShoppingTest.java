package testmeapp.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	WebDriver drive;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	 @AfterMethod
	 public void getResultAfterMethod(ITestResult result) {
	  if (result.getStatus() == ITestResult.FAILURE) {
	   logger.log(Status.FAIL, "The Method" + result.getName() + " has failed due to" + result);
	  } else if (result.getStatus() == ITestResult.SKIP) {
	   logger.log(Status.SKIP, "The method" + result.getName() + " has skipped due to" + result);
	  }
	 }

	 @BeforeTest
	 public void startReportBeforeTest() {
	  System.out.println("before test");
	  System.setProperty("webdriver.chrome.driver", "C:\\NexGen Testing Stream NEW\\chromedriver_win32\\chromedriver.exe");
	  drive = new ChromeDriver();
	  drive.manage().window().maximize();
	  drive.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  String timeStamp = new SimpleDateFormat("yyyyMMdd.HHmmss").format(new Date());
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/" + timeStamp + ".html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Batch", "30th july");
	  extent.setSystemInfo("Training", "Selenium");
	  extent.setSystemInfo("Topic", "Extent reports");
	  htmlReporter.config().setDocumentTitle("Title of the extent report");
	  htmlReporter.config().setReportName("Name of the report");
	 }

	 @AfterTest
	 public void endReportAfterTest() {
	  extent.flush();
	 }



	 @Test(priority=2)
	 public void testLogin() {
	 //drive.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
	  drive.findElement(By.id("userName")).sendKeys("lalitha");
	  drive.findElement(By.id("password")).sendKeys("Password123");
	  drive.findElement(By.name("Login")).click();
	  
	 }
	 
//	 @Test(priority=3)
//	 public void testorder() {
//		 drive.findElement(By.xpath("//span[contains(text(),'Orders')]")).click();
//		 String Price1 = drive.findElement(By.xpath("//h4[text()='Carpet']//ancestor::td//following-sibling::td[@data-th='Price']")).getText();
//		 
//		 
//	 }
//	 
	 @Test(enabled=false)
	 public void testabout() {
		 drive.findElement(By.xpath("//span[text()='AboutUs']")).click();
		   drive.findElement(By.xpath("//span[contains(text(),'Offices')]")).click();
		   drive.findElement(By.xpath("//span[contains(text(),'Chennai')]")).click();
		   
		   
		   Set<String> set=drive.getWindowHandles();
		   for (String string : set) {
		   drive.switchTo().window(string);
		   }
		   drive.switchTo().frame("menu_page");
		   String uname=drive.findElement(By.xpath("//ul[contains(text(),'Hi')]")).getText();
		   System.out.println("Name:"+uname);
		    drive.switchTo().defaultContent();
		   drive.switchTo().frame(drive.findElement(By.name("main_page")));
		   
		   String address=drive.findElement(By.tagName("address")).getText();
		   System.out.println(address);
		   
		   

		
//		 String add1=drive.findElement(By.xpath("//address[@id='demo3']//b//p[1]")).getText();
//		 System.out.println("Address:"+add1);
		   
		   
		    
		 
	 }
	 
	 @Test(priority=3)
	 public void testCart() throws Exception {
	  drive.findElement(By.xpath("//span[contains(text(),'Categories')]")).click();
	  drive.findElement(By.xpath("//span[contains(text(),'Appliances')]")).click();
	  Thread.sleep(1000);
	  drive.findElement(By.xpath("//span[contains(text(),'Floor')]")).click();
	  drive.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
	  
	  
	  drive.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	  drive.findElement(By.xpath("//span[contains(text(),'Categories')]")).click();
	  drive.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
	  Thread.sleep(1000);
	  drive.findElement(By.xpath("//span[contains(text(),'Head Phone')]")).click();
	  drive.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
	  
	  
	  drive.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	  drive.findElement(By.xpath("//span[contains(text(),'Categories')]")).click();
	  drive.findElement(By.xpath("//span[contains(text(),'Appliances')]")).click();
	  Thread.sleep(1000);
	  drive.findElement(By.xpath("//span[contains(text(),'Wall Decorat')]")).click();
	  drive.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
	  drive.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	  Thread.sleep(1000);
	   
      String item1,item2,item3,Price1,Price2,Price3,total;
	  item1 = drive.findElement(By.xpath("//h4[text()='Carpet']")).getText();
	  item2 = drive.findElement(By.xpath("//h4[text()='Headphone']")).getText();
	  item3 = drive.findElement(By.xpath("//h4[text()='Cylotains']")).getText();
	  Price1 = drive.findElement(By.xpath("//h4[text()='Carpet']//ancestor::td//following-sibling::td[@data-th='Price']")).getText();
	  Price2 = drive.findElement(By.xpath("//h4[text()='Headphone']//ancestor::td//following-sibling::td[@data-th='Price']")).getText();
	  Price3 = drive.findElement(By.xpath("//h4[text()='Cylotains']//ancestor::td//following-sibling::td[@data-th='Price']")).getText();
	  total = drive.findElement(By.xpath("//span[@id='total']")).getText();
	  
	  
//	  String prodprice1=drive.findElement(By.xpath("(//table[@id='cart']//td[@data-th='Price'])[1]")).getText();
//	  System.out.println("prodprice1: "+prodprice1);
//	  
	  System.out.println(item1+"="+Price1);
	  System.out.println(item2+"="+Price2);
	  System.out.println(item3+"="+Price3);
	  System.out.println("Total="+total);
	  
	  //drive.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	 }


	 
//	 @Test(priority=4)
//	 public void testPayment() throws Exception {
//	  drive.findElement(By.id("choice-dollar")).click();
//	  drive.findElement(By.id("add2")).sendKeys("Chennai");
//	  drive.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
//	  Thread.sleep(2000);
//	  drive.findElement(By.xpath("//label[contains(text(),'HDFC Bank')]//i")).click();
//	  drive.findElement(By.xpath("//*[@id='btn']")).click();
//	  drive.findElement(By.name("username")).sendKeys("123456");
//	  drive.findElement(By.name("password")).sendKeys("1234");
//	  drive.findElement(By.xpath("//input[@value='LOGIN']")).click();
//	 }

	

	 @Test(priority=1)
	 public void testRegistration() {
	  drive.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
			String timeStamp = new SimpleDateFormat("HHmmss").format(new Timestamp(System.currentTimeMillis()));
			drive.findElement(By.id("userName")).sendKeys("sandeep" + timeStamp);
			drive.findElement(By.id("firstName")).sendKeys("Sandeep");
			drive.findElement(By.id("lastName")).sendKeys("Srinivasan");
			drive.findElement(By.xpath("//*[@id='password']")).sendKeys("Sandeep1234");
			drive.findElement(By.xpath("//*[@id='pass_confirmation']")).sendKeys("Sandeep1234");
			drive.findElement(By.xpath("//input[@value='Male']")).click();
			drive.findElement(By.xpath("//*[@id='emailAddress']")).sendKeys("sandeepsandy731@gmail.com");
			drive.findElement(By.xpath("//*[@id='mobileNumber']")).sendKeys("7299865263");
			drive.findElement(By.xpath("//*[@id='dob']")).sendKeys("08/24/1997");
			//drive.findElement(By.xpath("//img[@title='ch']")).click();
			//WebElement month=drive.findElement(By.xpath("//select[@data-handler='select[@month]']"));
			drive.findElement(By.xpath("//*[@id='address']")).sendKeys("No.15,3rd street,Chennai");
			Select dropdown = new Select(drive.findElement(By.xpath("//select [@id='securityQuestion']")));
			dropdown.getOptions();
			dropdown.selectByValue("411010");
			drive.findElement(By.xpath("//*[@id='answer']")).sendKeys("SandeepS");
			drive.findElement(By.xpath("//*[@type='submit']")).click();
			
			//Assert.assertEquals("USERNAME already exists.. please register again with different USERNAME..",drive.findElement(By.xpath("//div[@id='errormsg']]")));
		
	 }
	}
