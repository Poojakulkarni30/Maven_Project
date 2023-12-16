package day35;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerrClass implements ITestListener{
	
	
	public  ExtentSparkReporter SparkReporter;
	public ExtentReports extent ;
	public ExtentTest test;
	
	
	public void onStart(ITestContext context) {

		SparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/POMTestReport/myReport.html");//specify location of the report
		SparkReporter.config().setDocumentTitle("Automation Report");
		SparkReporter.config().setReportName("Functional Testing");
		SparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(SparkReporter);

		extent.setSystemInfo("PC Name", "Pooja K Computer");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Pooja Kulkarni");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome,Firefox,Edge");

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test is Passed" + result.getName());

	}

	public void onTestfailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is Failed" + result.getName());

		//test.log(Status.FAIL, "Test is Failed" + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is Skipped" + result.getName());

	//	test.log(Status.SKIP, "Test is Failed" + result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	
	

}
