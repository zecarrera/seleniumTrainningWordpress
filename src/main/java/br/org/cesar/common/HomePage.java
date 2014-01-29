package br.org.cesar.common;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/**
 * P�gina que disponibiliza os servi�os (a��es) presentes na home page do CLASSEDETESTES.WORDPRESS.COM
 * @author jcan
 *
 */
public class HomePage {

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
	
	/**
	 * Defini��o �nica dos locators utilizados na p�gina
	 */
//	static By homeMenuItem = By.id("menu-item-103"); //O item de menu pode ser acessado por id ou pelo texto exibido no link
	static By homeMenuItem = By.linkText("HOME");
	static By seleniumMenuItem = By.linkText("SELENIUM");
	static By cursoSeleniumSubMenuItem = By.linkText("CURSO SELENIUM");
	static By formularioSimplesMenuItem = By.linkText("FORMUL�RIO SIMPLES");

	
	static By hiddenOptionsButton = By.cssSelector("a.widget-handle.genericon");
	static By searchField = By.name("s");
	
	static By pageHeaderTitle = By.className("entry-title");
	static By searchResultsTitle = By.cssSelector("h1.page-title");
	
	public HomePage() {
	}

	/**
	 * Clicar no link HOME do menu
	 */
	public static void clickHomeMenuItem(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(homeMenuItem));
		driver.findElement(homeMenuItem).click();
	}	
	
	/**
	 * Clicar no link SELENIUM do menu
	 */
	public static void clickSeleniumMenuItem(){
		Utils.isClickable(seleniumMenuItem);
		driver.findElement(seleniumMenuItem).click();
	}	
	
	/**
	 * Clicar no item de subMenu indicado
	 */
	public static void clicksubMenuItem(String subMenu){
		By correctLocator = null;
		if (subMenu.equalsIgnoreCase("Curso Selenium")){
			correctLocator = cursoSeleniumSubMenuItem;
		} else if (subMenu.equalsIgnoreCase("Formul�rio Simples")){
			correctLocator = formularioSimplesMenuItem;
		}
		Utils.isVisible(correctLocator);
		driver.findElement(correctLocator).click();
	}	
	
	/**
	 * Clicar no item que abre as opcoes escondidas
	 */
	public static void showHiddenOptions(){
		driver.findElement(hiddenOptionsButton).click();
	}	
	
	
	/**
	 * Digita o texto passado no campo de busca
	 */
	public static void performSearch(String searchText) { 
		Utils.isClickable(searchField);
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(searchText);
	}
	
	/**
	 * Realizar Busca (pressionar tecla ENTER)
	 */
	public static void clickSearchButton() { 
		driver.findElement(searchField).sendKeys(Keys.RETURN); 
	}

	
	/**
	 * Checks if page header displayed title is correct
	 */
	public static void isHeaderTitleCorrect(String expectedTitle){
		assertThat("T�tulo da p�gina Incorreto", driver.findElement(pageHeaderTitle).getText(), is(expectedTitle)); 
	}
	
	
	/**
	 * Asserts page title value
	 */
	public static void isTitleCorrect(String expectedTitle){
		assertThat("T�tulo Incorreto", driver.getTitle(), is(expectedTitle)); 
		 // em caso de falha:
	     // messagem de erro:
	     // T�tulo Incorreto
	     // valor esperado: expectedTitle
	     // valor capturado: driver.getTitle()

		//Assert.assertEquals("C.E.S.A.R (English version)", driver.getTitle()); //Deprecated, mas pode ser utilizada.
	}
	
	/**
	 * Asserts page result title value
	 */
	public static void isSearchResultCorrect(String expectedTitle){
		assertThat("T�tulo Incorreto",  driver.findElement(searchResultsTitle).getText(), is(expectedTitle)); 
	}

}