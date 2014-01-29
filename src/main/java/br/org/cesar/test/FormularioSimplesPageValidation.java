package br.org.cesar.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioSimplesPage;
import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;

/**
 * Classe de testes com cen�rios relacionados a p�gina inicial
 */
public class FormularioSimplesPageValidation extends BaseTestcase{

	/**
	 * Antes de cada teste acessa a p�gina de formul�rio simples
	 * @throws Exception
	 */
	@Before
	public void before() throws Exception {
		driver.navigate().to("http://classedetestes.wordpress.com/formulario-simples/");
	}


	/**
	 *  Enviar um comentario com sucesso
	 */
	@Test
	public void sendCommentSuccessfully() {
		FormularioSimplesPage.fillOutFormularioSimples("jose", "zecarrera@gmail.com", "website", "mensagem");
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
	
	/**
	 *  Enviar um comentario sem preencher o nome
	 */
	@Test
	public void sendCommentWithoutName() {
		FormularioSimplesPage.fillOutFormularioSimples("", "zecarrera@gmail.com", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Nome � obrigat�rio");
	}
	
	/**
	 *  Enviar um comentario sem preencher o email
	 */
	@Test
	public void sendCommentWithoutEmail() {
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endere�o de e-mail v�lido");
	}
	
	/**
	 *  Enviar um comentario sem preencher o website
	 */
	@Test
	public void sendCommentWithoutWebsite() {
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "zecarrera@gmail.com", "", "mensagem");
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
	
	/**
	 *  Enviar um comentario sem preencher o coment�rio
	 */
	@Test
	public void sendCommentWithoutMessage() {
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "zecarrera@gmail.com", "website", "");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Coment�rio � obrigat�rio");
	}
	
	
	/**
	 * Enviar um coment�rio com um email invalido
	 */
	@Test
	public void sendCommentWithInvalidEmail(){
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "zecarrera", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endere�o de e-mail v�lido");
	}
}
