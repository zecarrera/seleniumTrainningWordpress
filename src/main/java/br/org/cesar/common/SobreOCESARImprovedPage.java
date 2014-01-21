package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/**
 * Página que representa os serviços disponíveis no sub-menu sobre o CESAR
 * @author jcan
 *
 */
public class SobreOCESARImprovedPage {

	/**
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/**
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	static By sobreOCesarMenuLocator = By.linkText("SOBRE O C.E.S.A.R");
	static By pageSubTitleLocator = By.cssSelector("h2");
	
	public SobreOCESARImprovedPage() {
	}

	/**
	 * Clicks Sobre o Cesar Menu item
	 */
	public static void clickSobreOCESARMenu(){
		driver.findElement(sobreOCesarMenuLocator).click();
	}	
	
	/**
	 * Clicks Sub-menu item
	 */
	public static void clickSubMenu(String subMenu) { 
		Utils.isVisible(By.linkText(subMenu));
		driver.findElement(By.linkText(subMenu)).click(); 
	}
	
	/**
	 * Checks if page sub title is the one expected
	 * @param texto
	 */
	public static void assertSubTitle(String texto){
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageSubTitleLocator));
		String subTitle = driver.findElement(pageSubTitleLocator).getText();
		Assert.assertEquals(texto, subTitle);
	}


}