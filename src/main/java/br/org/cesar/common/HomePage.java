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
 * Página que disponibiliza os serviços (ações) presentes na home page do CLASSEDETESTES.WORDPRESS.COM
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
	 * Definição única dos locators utilizados na página
	 */
//	static By homeMenuItem = By.id("menu-item-103"); //O item de menu pode ser acessado por id ou pelo texto exibido no link
	static By homeMenuItem = By.linkText("HOME");
	static By seleniumMenuItem = By.linkText("SELENIUM");
	static By cursoSeleniumSubMenuItem = By.linkText("CURSO SELENIUM");
	static By formularioSimplesMenuItem = By.linkText("FORMULÁRIO SIMPLES");

	
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
		} else if (subMenu.equalsIgnoreCase("Formulário Simples")){
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
	 * Clicar no box "Deixe uma resposta"
	 */
	public static void clickDeixeUmaRespostaBox(){
		driver.findElement(deixeUmaRespostaBox).click();
	}
	
	/**
	 * Preencher comentario no box "Deixe uma resposta"
	 */
	public static void fillOutComment(String comentario){
		driver.findElement(deixeUmaRespostaBox).clear();
		driver.findElement(deixeUmaRespostaBox).sendKeys(comentario);
	}
	
	/**
	 * Clicar no link Mudar no box "Deixe uma resposta"
	 */
	public static void clickMudarLink(){
		driver.findElement(mudarLinkText).click();
	}
	
	/**
	 * Preencher nome no box "Deixe uma resposta"
	 */
	public static void fillOutNome(String autor){
		driver.findElement(authorField).clear();
		driver.findElement(authorField).sendKeys(autor);
	}
	
	/**
	 * Preencher url no box "Deixe uma resposta"
	 */
	public static void fillOutURL(String url){
		driver.findElement(urlField).clear();
		driver.findElement(urlField).sendKeys(url);
	}
	
	/**
	 * Preencher email no box "Deixe uma resposta"
	 */
	public static void fillOutEmail(String email){
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	
	/**
	 * Clicar no botão "publicar comentário"
	 */
	public static void publishComment(){
		driver.findElement(submitCommentButton).click();
	}
	
	/**
	 * Preencher dados de usuario no box "Deixe uma resposta"
	 */
	public static void fillUserInfo(String autor, String url, String email){
		Utils.isVisible(authorField);
		fillOutNome(autor);
		fillOutEmail(email);
		fillOutURL(url);
	}
	
	/**
	 * Verifica se o titulo da página (exibido no navegador) é o esperado
	 */
	public static void isHeaderTitleCorrect(String expectedTitle){
		assertThat("Título da página Incorreto", driver.findElement(pageHeaderTitle).getText(), is(expectedTitle)); 
	}
	
	
	/**
	 * Verifica se o título exibido na página possui o valor esperado
	 */
	public static void isTitleCorrect(String expectedTitle){
		assertThat("Título Incorreto", driver.getTitle(), is(expectedTitle)); 
		 // em caso de falha:
	     // messagem de erro:
	     // Título Incorreto
	     // valor esperado: expectedTitle
	     // valor capturado: driver.getTitle()

		//Assert.assertEquals("C.E.S.A.R (English version)", driver.getTitle()); //Deprecated, mas pode ser utilizada.
	}
	
	/**
	 * Verifica se o título da página de resultados de busca está correto
	 */
	public static void isSearchResultCorrect(String expectedTitle){
		assertThat("Título Incorreto",  driver.findElement(searchResultsTitle).getText(), is(expectedTitle)); 
	}

}