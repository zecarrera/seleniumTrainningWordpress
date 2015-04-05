package br.org.cesar.test;

import org.junit.*;

import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;


/**
 * Classe de testes com cenários relacionados a página inicial
 */
public class HomePageValidation extends BaseTestcase{

	@Before
	public void before() throws Exception {
		//driver.manage().window().maximize();
	}


	/**
	 * Objetivo: Abrir a home screen e verificar o titulo
	 * 
	 * Passos: Navegar para a home screen e verificar o titulo
	 * 
	 * Resultado Esperado: Titulo da home screen está correto
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
	 * Resultado Esperado:Titulo da página está correto
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
	 * Resultado Esperado:Titulo da página está correto
	 */
	@Test
	public void navigateToFormularioSimplesPage() {
		HomePage.clickMenuElement("selenium", "formulário simples");
		HomePage.isHeaderTitleCorrect("Formulário Simples");
	}
	
	
	/**
	 * Objetivo: Página de resultados da busca é exibida corretamente
	 * 
	 * Passos: Realiza busca com texto fixo e verifica o título da página de resultados
	 * 
	 * Resultado Esperado: Título da página de resultados está correto
	 */
	@Test
	public void performSimpleSearch() {
		HomePage.showHiddenOptions();
		HomePage.performSearch("teste");
		HomePage.clickSearchButton();
		HomePage.isSearchResultCorrect("Resultados da pesquisa por: teste");
	}

	
	/**
	 * Objetivo: Página Olá mundo é exibida quando buscamos por texto vazio
	 * 
	 * Passos: Realiza busca com texto vazio e verifica o título da página
	 * 
	 * Resultado Esperado: Usuário é redirecionado para a página adequada
	 */
	@Test
	public void searchEmptyText(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Olá, mundo!");
	}
			
	/**
	 * Objetivo:  Realizar busca que não retorna resultados
	 * 
	 * Passos:  Realizar busca utilizando termo que não retorne resultados e verificar página exibida
	 * 
	 * Resultado Esperado: Título informa que nenhum resultado foi encontrado
	 */
	@Test
	public void searchWithoutResults(){
		HomePage.showHiddenOptions();
		HomePage.performSearch("futebol");
		HomePage.clickSearchButton();
		HomePage.isHeaderTitleCorrect("Nada encontrado");
	}
	
	/**
	 * Objetivo: Página de resultados é exibida corretamente
	 * 
	 * Passos: Realiza busca com termo que retorne resultados e verifica título exibido
	 * 
	 * Resultados Esperados: Página de resultados exibe título correto
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
	 * Objetivo: Preencher comentário com dados de usuario
	 * 
	 * Pré-Condição: Usuário não está logado no wordpress
	 * 
	 * Passos: Clicar na caixa de comentario e preencher os campos de usuario
	 * 
	 * Resultados Esperados: Informações de usuário podem ser inseridas e comentario publicado
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

	/**
	 * Exemplo utilização do screenshot apenas ao ocorrer exception
	 */
	@Test
	public void assertHomeScreenTitleWithScrenshot() {
		try{
			HomePage.clickHomeMenuItem();
			HomePage.isTitleCorrect("teste");
		} catch (AssertionError t) {
			Utils.takeScreenshot("failed");
			Assert.fail();
		}
	}

	@After
	public void after() throws Exception {
		//Dimension tamanhoJanela= new Dimension(400,400);
		//driver.manage().window().setSize(tamanhoJanela);
	}
}
