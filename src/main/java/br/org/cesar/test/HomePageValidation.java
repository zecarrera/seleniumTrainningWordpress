package br.org.cesar.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;

/**
 * Classe de testes com cen�rios relacionados a p�gina inicial
 */
public class HomePageValidation extends BaseTestcase{

	@Before
	public void before() throws Exception {
	}


	/**
	 * Objetivo: Abrir a home screen e verificar o titulo
	 * 
	 * Passos: Navegar para a home screen e verificar o titulo
	 * 
	 * Resultado Esperado: Titulo da home screen est� correto
	 */
	@Test
	public void assertHomeScreenTitle() {
		HomePage.clickHomeMenuItem();
		HomePage.isTitleCorrect("Classe de Testes | Testes e Qualidade de Software");
	}
	
	
	/**
	 * Objetivo: Navegar para a pagina Curso Selenium e verificar o titulo exibido
	 * 
	 * Passos: Navegar para a pagina Curso Selenium, em seguida verificar o titulo exibido
	 * 
	 * Resultado Esperado:Titulo da p�gina est� correto
	 */
	@Test
	public void navigateToCursoSeleniumPage() {
		HomePage.clickMenuElement("selenium", "curso selenium");
		HomePage.isHeaderTitleCorrect("Curso Selenium");
	}
	
	
	/**
	 * Objetivo: Navegar para a pagina Formulario Simples e verificar o titulo
	 * 
	 * Passos: Navegar para a pagina Formulario Simples e verificar o titulo exibido
	 * 
	 * Resultado Esperado:Titulo da p�gina est� correto
	 */
	@Test
	public void navigateToFormularioSimplesPage() {
		HomePage.clickMenuElement("selenium", "formul�rio simples");
		HomePage.isHeaderTitleCorrect("Formul�rio Simples");
	}
	
	
	/**
	 * Objetivo: P�gina de resultados da busca � exibida corretamente
	 * 
	 * Passos: Realiza busca com texto fixo e verifica o t�tulo da p�gina de resultados
	 * 
	 * Resultado Esperado: T�tulo da p�gina de resultados est� correto
	 */
	@Test
	public void performSimpleSearch() {
		HomePage.showHiddenOptions();
		HomePage.performSearch("teste");
		HomePage.clickSearchButton();
		HomePage.isSearchResultCorrect("Resultados da pesquisa por: teste");
	}

	
	/**
	 * Objetivo: P�gina Ol� mundo � exibida quando buscamos por texto vazio
	 * 
	 * Passos: Realiza busca com texto vazio e verifica o t�tulo da p�gina
	 * 
	 * Resultado Esperado: Usu�rio � redirecionado para a p�gina adequada
	 */
	@Test
	public void searchEmptyText(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Ol�, mundo!");
	}
			
	/**
	 * Objetivo:  Realizar busca que n�o retorna resultados
	 * 
	 * Passos:  Realizar busca utilizando termo que n�o retorne resultados e verificar p�gina exibida
	 * 
	 * Resultado Esperado: T�tulo informa que nenhum resultado foi encontrado
	 */
	@Test
	public void searchWithoutResults(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("futebol");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Nada encontrado");
	}
	
	/**
	 * Objetivo: P�gina de resultados � exibida corretamente
	 * 
	 * Passos: Realiza busca com termo que retorne resultados e verifica t�tulo exibido
	 * 
	 * Resultados Esperados: P�gina de resultados exibe t�tulo correto
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
	 * Objetivo: Preencher coment�rio com dados de usuario
	 * 
	 * Pr�-Condi��o: Usu�rio n�o est� logado no wordpress
	 * 
	 * Passos: Clicar na caixa de comentario e preencher os campos de usuario
	 * 
	 * Resultados Esperados: Informa��es de usu�rio podem ser inseridas e comentario publicado
	 */
	@Test
	public void changeUserInfo() {
		HomePage.clickDeixeUmaRespostaBox();
		HomePage.fillOutComment("comentario");
		HomePage.fillOutNome("novo nome");
		HomePage.fillOutEmail("novoemail@tste.com");
		HomePage.fillOutURL("novaurl");
		HomePage.publishComment();
	}
	@After
	public void after() throws Exception {
	}
}
