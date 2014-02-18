package br.org.cesar.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

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
	 * Objective: Open home screen and verify title
	 * 
	 * Steps: Navigate to home screen and assert title text
	 * 
	 * Expected Results: Home screen title is correct
	 */
	@Test
	public void assertHomeScreenTitle() {
//		Utils.takeScreenshot("maximized");
		HomePage.clickHomeMenuItem();
		HomePage.isTitleCorrect("Classe de Testes | Testes e Qualidade de Software");
	}
	
	
	/**
	 * Objective: Navigates to Curso Selenium Page and verify displayed title
	 * 
	 * Steps: Navigate to  Curso Selenium Page and assert displayed title text
	 * 
	 * Expected Results: Curso Selenium Page  title is correct
	 */
	@Test
	public void navigateToCursoSeleniumPage() {
		HomePage.clickSeleniumMenuItem();
		HomePage.clicksubMenuItem("Curso Selenium");
		HomePage.isHeaderTitleCorrect("Curso Selenium");
	}
	
	
	/**
	 * Objective: Navigates to Formulario Simples Pageand verify displayed title
	 * 
	 * Steps: Navigate to  Formulario Simples Page and assert displayed title text
	 * 
	 * Expected Results: Formulario Simples Page title is correct
	 */
	@Test
	public void navigateToFormularioSimplesPage() {
		HomePage.clickSeleniumMenuItem();
		HomePage.clicksubMenuItem("Formulário Simples");
		HomePage.isHeaderTitleCorrect("Formulário Simples");
	}
	
	
	/**
	 * Objective: Search results screen is properly displayed
	 * 
	 * Steps: Performs a search with fixed text and assert displayed title text
	 * 
	 * Expected Results: Search results Page title is correct
	 */
	@Test
	public void performSimpleSearch() {
		HomePage.showHiddenOptions();
		HomePage.performSearch("teste");
		HomePage.clickSearchButton();
		HomePage.isSearchResultCorrect("Resultados da pesquisa por: teste");
	}

	
	/**
	 * Objective: Specific page is loaded when empty text is used on search
	 * 
	 * Steps: Performs a search with empty text and assert displayed page
	 * 
	 * Expected Results: User is redirected to proper Page
	 */
	@Test
	public void searchEmptyText(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Olá, mundo!");
	}
			
	/**
	 * Objective:  Performs a search that does not return results
	 * 
	 * Steps:  Performs a search that does not return results and assert displayed page
	 * 
	 * Expected Results: Search results title indicates that no results were found
	 */
	@Test
	public void searchWithoutResults(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("futebol");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Nada Encontrado");
	}
	
	/**
	 * Objective: Search results screen is properly displayed (capturing screenshot)
	 * 
	 * Steps: Performs a search with fixed text and assert displayed title text
	 * 
	 * Expected Results: Search results Page title is correct
	 */
	@Test
	public void performSimpleSearchScrenshot() {
		HomePage.showHiddenOptions();
		HomePage.performSearch("teste");
		Utils.takeScreenshot(this.getClass().getName().substring(19));
		HomePage.clickSearchButton();
		HomePage.isSearchResultCorrect("Resultados da pesquisa por: teste");
	}
	
	
	/**
	 * Objective: Fill out response with different user info
	 * 
	 * Steps: Clicks on "deixe uma resposta", changes user info
	 * 
	 * Expected Results: User info can be modified prior to submitting response
	 */
	@Test
	public void changeUserInfo() {
		HomePage.clickDeixeUmaRespostaBox();
//		HomePage.fillOutComment("comentario");
		HomePage.fillOutNome("novo nome");
		HomePage.fillOutEmail("novoemail@tste.com");
		HomePage.fillOutURL("novaurl");
		HomePage.publishComment();
	}
	@After
	public void after() throws Exception {
	}
}
