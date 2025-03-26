package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	ExtentReports reports;//Populate common info like operating system,user,environment,platform etc..
	ExtentSparkReporter spark;//UI/Template of the Report
	ExtentTest extent;//Creating test case in the report and updating status of the test methods 
	
	//It executes only once and at the start of application/project
	public void onStart(ITestContext context){
		spark=new ExtentSparkReporter("./ExtentReports/report_"+(int)(Math.random()*1000000)+".html");
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(Theme.STANDARD);
		reports=new ExtentReports();
		
		reports.attachReporter(spark);
		reports.setSystemInfo("Operating System",System.getProperty("os.name"));
		reports.setSystemInfo("User Name",System.getProperty("user.name"));
		reports.setSystemInfo("Environment","QA");
		reports.setSystemInfo("Browser","Chrome");
		reports.setSystemInfo("Executed By","Kiran");
	}
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	public void onTestStart(ITestResult result) {
		extent=reports.createTest(result.getMethod().getMethodName());
		
	}
	public void onTestSuccess(ITestResult result) {
		extent.pass("Test Case is passed");
	}
	public void onTestFailure(ITestResult result) {
		extent.pass("Test Case is failed");
	}
	public void onTestSkipped(ITestResult result) {
		extent.pass("Test Case is skipped");
	}
}
