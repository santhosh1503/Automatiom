package Z_Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

 

public class Base_Agent {
	public static WebDriver driver;
	public static Properties baseconf = new Properties();
	public static Properties baseloc = new Properties();
	public static Properties loc = new Properties();
	public static  FileReader basedata;
	public static  FileReader loginlogout;
	public static  FileReader Locators;
	
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\RegisteredCar.xlsx");

	
	@BeforeSuite
	public void setup() throws IOException, InterruptedException {
		
		if(driver==null) {
			  basedata = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\ConfigFiles\\Z.Base.Config.Properties"); 
			  loginlogout = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\ConfigFiles\\Z.Base.Locator.Properties");
			  Locators = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\ConfigFiles\\RegCar.Locator.Properties");
					  
			  baseconf.load(basedata);
			  baseloc.load(loginlogout);
			  loc.load(Locators);
		  }
		  if(baseconf.getProperty("browser").equalsIgnoreCase("ch")) {
			  WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(baseconf.getProperty("testurl"));
				System.out.println("URL opened successfully");
				Thread.sleep(5000);
				driver.findElement(By.id(baseloc.getProperty("unm"))).sendKeys(baseconf.getProperty("agentID"));
				Thread.sleep(1000);
				System.out.println("Username Entered successfully");
				Thread.sleep(1000);
				driver.findElement(By.id(baseloc.getProperty("psd"))).sendKeys(baseconf.getProperty("password"));
				System.out.println("Password Entered successfully");
				Thread.sleep(2000);
				driver.findElement(By.xpath(baseloc.getProperty("Login"))).click();
				System.out.println("Login Button clicked successfully");
				System.out.println("User log in successfully");
				Thread.sleep(6000);
				System.out.println("Home Page opend successfully");

		  }
		  else if(baseconf.getProperty("browser").equalsIgnoreCase("ff")) {
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver(); 
			  driver.manage().window().maximize();
			  driver.get(baseconf.getProperty("testurl"));
				System.out.println("URL opened successfully");
				Thread.sleep(5000);
				driver.findElement(By.id(baseloc.getProperty("unm"))).sendKeys(baseconf.getProperty("agentID"));
				Thread.sleep(1000);
				System.out.println("Username Entered successfully");
				Thread.sleep(1000);
				driver.findElement(By.id(baseloc.getProperty("Psd"))).sendKeys(baseconf.getProperty("password"));
				System.out.println("Password Entered successfully");
				Thread.sleep(2000);
				driver.findElement(By.xpath(baseloc.getProperty("Login"))).click();
				System.out.println("Login Button clicked successfully");
				System.out.println("User log in successfully");
				Thread.sleep(6000);
				System.out.println("Home Page opend successfully");
		  }
		  else if(baseconf.getProperty("browser").equalsIgnoreCase("ms")) {
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
			  driver.manage().window().maximize();
			  driver.get(baseconf.getProperty("testurl"));
				System.out.println("URL opened successfully");
				Thread.sleep(5000);	
				driver.findElement(By.id(baseloc.getProperty("unm"))).sendKeys(baseconf.getProperty("agentID"));
				Thread.sleep(1000);
				System.out.println("Username Entered successfully");
				Thread.sleep(1000);
				driver.findElement(By.id(baseloc.getProperty("psd"))).sendKeys(baseconf.getProperty("password"));
				System.out.println("Password Entered successfully");
				Thread.sleep(2000);
				driver.findElement(By.xpath(baseloc.getProperty("Login"))).click();
				System.out.println("Login Button clicked successfully");
				System.out.println("User log in successfully");
				Thread.sleep(6000);
				System.out.println("Home Page opend successfully");
		  }
	  }
	public void Baseclick(String locator) throws InterruptedException {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(baseloc.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			Thread.sleep(10000);
			driver.findElement(By.xpath(baseloc.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(baseloc.getProperty(locator))).click();
		}
		//CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + locator);
	}
	public void click(String locator) throws InterruptedException {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(loc.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			Thread.sleep(10000);
			driver.findElement(By.xpath(loc.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(loc.getProperty(locator))).click();
		}
		//CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + locator);
	}
	public void Enter(String locator, String value) throws InterruptedException {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(loc.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(loc.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(loc.getProperty(locator))).sendKeys(value);
		}

		//CustomListeners.testReport.get().log(Status.INFO, "Typing in : " + locator + " entered value as " + value);

	}
	
	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(loc.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(loc.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(loc.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		//CustomListeners.testReport.get().log(Status.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}
	public void output(String value){
		System.out.println(value);	
	}
	public void print(String locator) throws InterruptedException {
		
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(loc.getProperty(locator))).getText();
		} else if (locator.endsWith("_XPATH")) {
		    driver.findElement(By.xpath(loc.getProperty(locator))).getText();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(loc.getProperty(locator))).getText();
		}
		//CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + locator);

	}
	public void write(String result,Method m, int colNum, int rowNum) {
		String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\RegisteredCar.xlsx";
		try {
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = WorkbookFactory.create(inputStream);
		
		Sheet sheet = workbook.getSheet(m.getName());
		Cell cell2Update = sheet.getRow(rowNum).getCell(colNum);
		cell2Update.setCellValue(result);
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(
		System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\RegisteredCar.xlsx");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		}
	
	@AfterSuite
	  public void tearDown() throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(By.xpath(baseloc.getProperty("profile"))).click();
			System.out.println("Profile Clicked successfully");
			Thread.sleep(5000);
			driver.findElement(By.xpath(baseloc.getProperty("Sobtn"))).click();
			System.out.println("Sign Out clicked successfully");
			System.out.println("User log Out successfully");
			Thread.sleep(3000);
			driver.close();
		    System.out.println("Browser Closed successfully");
	  }
		
	}

