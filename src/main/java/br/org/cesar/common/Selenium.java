package br.org.cesar.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



/**
 * Classe Utils para o Selenium
 * Identifica qual o browser escolhido no config.properties e inicializa o webdriver correspondente
 */
public class Selenium {
	
	private static WebDriver driver = null;
	
	
	
	public static WebDriver getDriver() {
		String browser = Property.BROWSER_NAME;
		if (driver == null) {
			if (Browser.CHROME.equals(browser)) {
				File file = new File(Property.CHROME_DRIVE_PATH);
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
			} else if (Browser.IE.equals(browser)) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				File file = new File(Property.IE64_DRIVE_PATH);
				
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
			}else  if (Browser.FIREFOX.equals(browser)){
				driver = new FirefoxDriver();
			}/*else if (Browser.PHANTOMJS.equals(browser)){
				DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
				File file = new File(Property.PHANTOMJS_DRIVE_PATH);
				System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
				desiredCapabilities.setJavascriptEnabled(true);
				desiredCapabilities.setCapability("takesScreenshot", true);
				driver = new PhantomJSDriver(desiredCapabilities);
			} else if(Browser.HTMLDRIVER.equals(browser)){
				driver = new HtmlUnitDriver();
			}*/
		}
		return driver;
	}
	
}
