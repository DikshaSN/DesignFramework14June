package DesignFramework.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DesignFramework.Pages.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landing;
	
	public void initDriver() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		String jsondata = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsondata, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\Selenium\\Scripts\\DesignFramework\\Reports\\"+testcasename+".png");
		FileUtils.copyFile(src, file);
		return 	"D:\\Selenium\\Scripts\\DesignFramework\\Reports\\"+testcasename+".png";
	}
	
	
	@BeforeMethod(alwaysRun =true)
	public void initBrowser() {
		initDriver();
		landing = new LandingPage(driver);
		landing.goTo();	
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		driver.close();
	}
}
