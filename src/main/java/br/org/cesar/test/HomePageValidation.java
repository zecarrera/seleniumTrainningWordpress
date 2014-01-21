package br.org.cesar.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;

/**
 * Classe de testes com cenários relacionados a página inicial
 */
public class HomePageValidation extends BaseTestcase{

	@Before
	public void before() throws Exception {
	}


	/**
	 *  Open home screen and verify page title 
	 */
	@Test
	public void assertHomeScreenTitle() {
//		Utils.takeScreenshot("maximized");
		HomePage.clickHomeMenuItem();
		HomePage.isTitleCorrect("Classe de Testes | Testes e Qualidade de Software");
	}
	
	
	/**
	 *  Navigates to Curso Selenium Page
	 */
	@Test
	public void navigateToCursoSeleniumPage() {
		HomePage.clickSeleniumMenuItem();
		HomePage.clicksubMenuItem("Curso Selenium");
		HomePage.isHeaderTitleCorrect("Curso Selenium");
	}
	
	
	/**
	 *  Navigates to Formulario Simples Page
	 */
	@Test
	public void navigateToFormularioSimplesPage() {
		HomePage.clickSeleniumMenuItem();
		HomePage.clicksubMenuItem("Formulário Simples");
		HomePage.isHeaderTitleCorrect("Formulário Simples");
	}
	
	
	/**
	 *  Performs a search with fixed text on page 
	 */
	@Test
	public void performSimpleSearch() {
		HomePage.showHiddenOptions();
		HomePage.performSearch("teste");
		HomePage.clickSearchButton();
		HomePage.isSearchResultCorrect("Resultados da pesquisa por: teste");
	}

	
	/**
	 * Performs a search with empty text
	 */
	@Test
	public void searchEmptyText(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Olá, mundo!");
	}
			
	
	/**
	 * Performs a search that does not return results
	 */
	@Test
	public void searchWithoutResults(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("futebol");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Nada Encontrado");
	}
	
	/**
	 *  Performs a search with fixed text on page (with screenshot) 
	 */
	@Test
	public void performSimpleSearchScrenshot() {
		HomePage.showHiddenOptions();
		HomePage.performSearch("teste");
		Utils.takeScreenshot(this.getClass().getName().substring(19));
		HomePage.clickSearchButton();
		HomePage.isSearchResultCorrect("Resultados da pesquisa por: teste");
	}
	
	@After
	public void after() throws Exception {
	}
}
