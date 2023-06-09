package basecontainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class basecontainers {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties datasaver = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis; 
	public static String browser;
	Utility utils = new Utility();
	String projectlocation = System.getProperty("user.dir");
	
	@BeforeTest
	public void setup() throws IOException {
		if(driver==null) {
			try {
			fis = new FileInputStream(projectlocation+"\\src\\test\\resources\\propertyfile\\config.properties");	
			} catch(FileNotFoundException m) {
				m.printStackTrace();
			}
			try {
				config.load(fis);
			} catch(FileNotFoundException f) {
				f.printStackTrace();
			}
			
			
			try {
				fis = new FileInputStream(projectlocation+"\\src\\test\\resources\\propertyfile\\OR.properties");
			} catch(FileNotFoundException j) {
				j.printStackTrace();
			}
			try {
				OR.load(fis); 
			} catch(FileNotFoundException h) {
				h.printStackTrace();
			}
			
			
			try {
				fis = new FileInputStream(projectlocation+"\\src\\test\\resources\\propertyfile\\datasaver.properties");
			} catch(FileNotFoundException g) {
				g.printStackTrace();
			}
			try {
				datasaver.load(fis);
			} catch(FileNotFoundException k) {
				k.printStackTrace();
			}
					
		}
		
		
		
		if(System.getenv("browser") != null && System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
		}
		else {
			browser = config.getProperty("browser");
		}
		config.setProperty("browser", browser);
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(config.getProperty("baseurl"));
		}
		
		
	}
	
	
	 
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
}

