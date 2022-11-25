package Mavenproject.extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void reports() {
		System.out.println("inside reports");
		String path = System.getProperty("user.dir");
		String compath = path +"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(compath);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Web Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Akshay Singhal");
		
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test =extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NEETU\\Documents\\AkshayProject\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://dev1.codepanda.in/");
		System.out.println(driver.getTitle());
		driver.close();
		// forcefully failing the test case
		test.fail("String do not match");
		
		extent.flush();
		
	}

}
