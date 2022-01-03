package com.Tudu.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+"TuduReport_"+ dateName +".html");
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+"TuduReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "shopomate");
		extent.setSystemInfo("ProjectName", "TUDU Application");
		extent.setSystemInfo("Tester", "Vikesh");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
	
	
}
