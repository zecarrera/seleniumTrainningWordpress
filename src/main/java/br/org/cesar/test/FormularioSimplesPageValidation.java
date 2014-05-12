package br.org.cesar.test;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioSimplesPage;
import br.org.cesar.common.HomePage;

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
		HomePage.clickMenuElement("selenium", "formulário simples");
	}


	/**
	 * Objetivo: Enviar um comentario com sucesso
	 * 
	 * Passos: Preencher campos do formulario com informações validas e submeter
	 * 
	 * Resultado Esperado: Mensagem de sucesso exibida
	 */
	@Test
	public void sendCommentSuccessfully() {
		FormularioSimplesPage.fillOutFormularioSimples("jose", "email@email.com", "website", "mensagem");
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o nome
	 * 
	 * Passos: Preencher campos do formulario (sem informar o nome) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro é exibida
	 */
	@Test
	public void sendCommentWithoutName() {
		FormularioSimplesPage.fillOutFormularioSimples("", "email@email.com", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Nome é obrigatório");
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o email
	 * 
	 * Passos: Preencher campos do formulario (sem informar o email) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro é exibida
	 */
	@Test
	public void sendCommentWithoutEmail() {
		FormularioSimplesPage.fillOutFormularioSimples("josé", "", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endereço de e-mail válido");
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o website
	 * 
	 * Passos: Preencher campos do formulario (sem informar o website) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro é exibida
	 */
	@Test
	public void sendCommentWithoutWebsite() {
		FormularioSimplesPage.fillOutFormularioSimples("josé", "email@email.com", "", "mensagem");
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o comentario
	 * 
	 * Passos: Preencher campos do formulario (sem informar o comentario) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro é exibida
	 */
	@Test
	public void sendCommentWithoutMessage() {
		FormularioSimplesPage.fillOutFormularioSimples("josé", "email@email.com", "website", "");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Comentário é obrigatório");
	}
	
	
	/**
	 * Objetivo:  Enviar um comentario com email invalido
	 * 
	 * Passos: Preencher campos do formulario (usando email invalido) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro é exibida
	 */
	@Test
	public void sendCommentWithInvalidEmail(){
		FormularioSimplesPage.fillOutFormularioSimples("josé", "jjj@ccc", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endereço de e-mail válido");
	}
}
