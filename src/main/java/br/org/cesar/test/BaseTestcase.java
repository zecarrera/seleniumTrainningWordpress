package br.org.cesar.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;




import br.org.cesar.common.HomePage;
import br.org.cesar.common.Property;
import br.org.cesar.common.Selenium;
import br.org.cesar.test.suite.AllTests;

/**
 * Classe base de testes, que inicializa o driver no início dos testes e encerra o driver ao final da execução.
 * @author jcan
 *
 */
public class BaseTestcase {
	protected static HomePage homePage;
	protected static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() throws Exception {	
		if (!AllTests.isAllTestsExecution){
			driver = Selenium.getDriver();
			driver.navigate().to(Property.SITE_ADDRESS);
			driver.manage().window().maximize();
		}
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		if (!AllTests.isAllTestsExecution){
			driver.quit();
		}
	}
	
}
