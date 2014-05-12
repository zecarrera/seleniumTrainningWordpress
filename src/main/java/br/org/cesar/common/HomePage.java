package br.org.cesar.common;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;

/**
 * P�gina que disponibiliza os servi�os (a��es) presentes na home page do
 * CLASSEDETESTES.WORDPRESS.COM
 * 
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
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos
	 * metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Defini��o �nica dos locators utilizados na p�gina
	 */
	// static By homeMenuItem = By.id("menu-item-103"); //O item de menu pode
	// ser acessado por id ou pelo texto exibido no link
	static By homeMenuItem = By.linkText("HOME");
	static By seleniumMenuItem = By.linkText("SELENIUM");
	static By cursoSeleniumSubMenuItem = By.linkText("CURSO SELENIUM");
	static By formularioSimplesMenuItem = By.linkText("FORMUL�RIO SIMPLES");
	static By formularioCompletoMenuItem = By.linkText("FORMUL�RIO COMPLETO");

	static By hiddenOptionsButton = By.cssSelector("a.widget-handle.genericon");
	static By searchField = By.name("s");
	static By deixeUmaRespostaBox = By.id("comment");
	static By mudarLinkText = By.linkText("Mudar");
	static By emailField = By.id("email");
	static By authorField = By.id("author");
	static By urlField = By.id("url");
	static By submitCommentButton = By.id("comment-submit");
	static By pageHeaderTitle = By.className("entry-title");
	static By searchResultsTitle = By.cssSelector("h1.page-title");

	public HomePage() {
	}

	/**
	 * Clicar no link HOME do menu
	 */
	public static void clickHomeMenuItem() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(homeMenuItem));
		driver.findElement(homeMenuItem).click();
	}

	/**
	 * M�todo auxiliar que recebe o texto do menu desejado e retorna o webElement
	 * @param menu
	 * @return
	 */
	private static WebElement getMenuLocator(String menu){
		WebElement menuElement = null;
		if (menu.equalsIgnoreCase("home")) {
			menuElement = driver.findElement(homeMenuItem);
		} else if (menu.equalsIgnoreCase("selenium")) {
			menuElement = driver.findElement(seleniumMenuItem);
		}
		return menuElement;
	}
	
	/**
	 * M�todo auxiliar que recebe o texto do subMenu desejado e retorna o webElement
	 * @param subMenu
	 * @return
	 */
	private static WebElement getSubMenuLocator(String subMenu){
		WebElement subMenuElement = null;
		if (subMenu.equalsIgnoreCase("Curso Selenium")) {
			subMenuElement = driver.findElement(cursoSeleniumSubMenuItem);
		} else if (subMenu.equalsIgnoreCase("Formul�rio Simples")) {
			subMenuElement = driver.findElement(formularioSimplesMenuItem);
		} else if (subMenu.equalsIgnoreCase("Formul�rio Completo")) {
			subMenuElement = driver.findElement(formularioCompletoMenuItem);
		}
		return subMenuElement;
	}
	
	/**
	 * Clicar itens de menu utilizando a classe actions para
	 */
	public static void clickMenuElement(String menu, String subMenu) {
		Actions action = new Actions(driver);
		action.moveToElement(getMenuLocator(menu)).build()
				.perform();
//		Utils.isVisible(formularioSimplesMenuItem);
		action.moveToElement(getSubMenuLocator(subMenu))
				.click().build().perform();
	}

	/**
	 * Clicar no item que abre as opcoes escondidas
	 */
	public static void showHiddenOptions() {
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
		Utils.isClickable(searchField);
		driver.findElement(searchField).sendKeys(Keys.RETURN);
	}

	/**
	 * Clicar no box "Deixe uma resposta"
	 */
	public static void clickDeixeUmaRespostaBox() {
		driver.findElement(deixeUmaRespostaBox).click();
	}

	/**
	 * Preencher comentario no box "Deixe uma resposta"
	 */
	public static void fillOutComment(String comentario) {
		Utils.isVisible(deixeUmaRespostaBox);
		driver.findElement(deixeUmaRespostaBox).clear();
		driver.findElement(deixeUmaRespostaBox).sendKeys(comentario);
	}

	/**
	 * Clicar no link Mudar no box "Deixe uma resposta"
	 */
	public static void clickMudarLink() {
		driver.findElement(mudarLinkText).click();
	}

	/**
	 * Preencher nome no box "Deixe uma resposta"
	 */
	public static void fillOutNome(String autor) {
		Utils.isClickable(authorField);
		driver.findElement(authorField).clear();
		driver.findElement(authorField).sendKeys(autor);
	}

	/**
	 * Preencher url no box "Deixe uma resposta"
	 */
	public static void fillOutURL(String url) {
		Utils.isVisible(urlField);
		driver.findElement(urlField).clear();
		driver.findElement(urlField).sendKeys(url);
	}

	/**
	 * Preencher email no box "Deixe uma resposta"
	 */
	public static void fillOutEmail(String email) {
		Utils.isVisible(emailField);
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}

	/**
	 * Clicar no bot�o "publicar coment�rio"
	 */
	public static void publishComment() {
		driver.findElement(submitCommentButton).click();
	}

	/**
	 * Preencher dados de usuario no box "Deixe uma resposta"
	 */
	public static void fillUserInfo(String autor, String url, String email) {
		Utils.isVisible(authorField);
		fillOutNome(autor);
		fillOutEmail(email);
		fillOutURL(url);
	}

	/**
	 * Verifica se o titulo da p�gina (exibido no navegador) � o esperado
	 */
	public static void isHeaderTitleCorrect(String expectedTitle) {
		assertThat("T�tulo da p�gina Incorreto",
				driver.findElement(pageHeaderTitle).getText(),
				is(expectedTitle));
	}

	/**
	 * Verifica se o t�tulo exibido na p�gina possui o valor esperado
	 */
	public static void isTitleCorrect(String expectedTitle) {
		assertThat("T�tulo Incorreto", driver.getTitle(), is(expectedTitle));
		// em caso de falha:
		// messagem de erro:
		// T�tulo Incorreto
		// valor esperado: expectedTitle
		// valor capturado: driver.getTitle()

		// Assert.assertEquals("C.E.S.A.R (English version)",
		// driver.getTitle()); //Deprecated, mas pode ser utilizada.
	}

	/**
	 * Verifica se o t�tulo da p�gina de resultados de busca est� correto
	 */
	public static void isSearchResultCorrect(String expectedTitle) {
		assertThat("T�tulo Incorreto", driver.findElement(searchResultsTitle)
				.getText(), is(expectedTitle));
	}

}