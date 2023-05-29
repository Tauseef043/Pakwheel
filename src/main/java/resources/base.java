package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	protected WebDriver driver;
	protected Properties prop;
	private FileInputStream fis;
	private String browserName;

	
	public WebDriver InitializeDriver() throws IOException
	{
		prop=new Properties();
		
		 fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\inputData.properties");

		prop.load(fis);
		
		 browserName = prop.getProperty("browser");


			if (browserName.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

				
				ChromeOptions options = new ChromeOptions(); // for headless runing browser open nai hoga

//				options.addArguments("window-size=1366,768");

				if (browserName.contains("headless")) {
					options.addArguments("headless");
				}
				// execute browser

				driver = new ChromeDriver(options);
			} else if (browserName.contains("firefox")) {

			} else if (browserName.contains("IE")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
//				driver = new InternetExplorerDriver();

			}
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}
	

	
}
