package genericMethods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;

	public WebDriver BrowserInvoke(String browser, String Website) {
		// Method to choose the browser to Invoke
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(Website);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(Website);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver",
					"src/main/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(Website);
			driver.manage().window().maximize();
		} else {
			System.out.println("provide correct data");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void Screenshot() throws IOException {
		// Method to get the Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/Screen.png");
		FileUtils.copyFile(source, destination);
	}
}
