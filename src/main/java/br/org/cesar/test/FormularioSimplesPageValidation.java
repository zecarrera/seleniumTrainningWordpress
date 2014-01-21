package br.org.cesar.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioSimplesPage;
import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;

/**
 * Classe de testes com cenários relacionados a página inicial
 */
public class FormularioSimplesPageValidation extends BaseTestcase{

	/**
	 * Antes de cada teste acessa a página de formulário simples
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
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Nome é obrigatório");
	}
	
	/**
	 *  Enviar um comentario sem preencher o email
	 */
	@Test
	public void sendCommentWithoutEmail() {
		FormularioSimplesPage.fillOutFormularioSimples("josé", "", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endereço de e-mail válido");
	}
	
	/**
	 *  Enviar um comentario sem preencher o website
	 */
	@Test
	public void sendCommentWithoutWebsite() {
		FormularioSimplesPage.fillOutFormularioSimples("josé", "zecarrera@gmail.com", "", "mensagem");
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
	
	/**
	 *  Enviar um comentario sem preencher o comentário
	 */
	@Test
	public void sendCommentWithoutMessage() {
		FormularioSimplesPage.fillOutFormularioSimples("josé", "zecarrera@gmail.com", "website", "");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Comentário é obrigatório");
	}
	
	
	/**
	 * Enviar um comentário com um email invalido
	 */
	@Test
	public void sendCommentWithInvalidEmail(){
		FormularioSimplesPage.fillOutFormularioSimples("josé", "zecarrera", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endereço de e-mail válido");
	}
}
