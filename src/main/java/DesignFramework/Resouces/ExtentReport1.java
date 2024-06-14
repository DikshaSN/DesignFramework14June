package DesignFramework.Resouces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {

	public static ExtentReports getreportobject() {
		String file ="D:\\Selenium\\Scripts\\DesignFramework\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setReportName("Design Framework");
		reporter.config().setDocumentTitle("Framework");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Diksha Kamdi");
		return extent;
	}
}
