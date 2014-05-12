package br.org.cesar.test;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioSimplesPage;
import br.org.cesar.common.HomePage;

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
		HomePage.clickMenuElement("selenium", "formul�rio simples");
	}


	/**
	 * Objetivo: Enviar um comentario com sucesso
	 * 
	 * Passos: Preencher campos do formulario com informa��es validas e submeter
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
	 * Resultado Esperado: Mensagem de erro � exibida
	 */
	@Test
	public void sendCommentWithoutName() {
		FormularioSimplesPage.fillOutFormularioSimples("", "email@email.com", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Nome � obrigat�rio");
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o email
	 * 
	 * Passos: Preencher campos do formulario (sem informar o email) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro � exibida
	 */
	@Test
	public void sendCommentWithoutEmail() {
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endere�o de e-mail v�lido");
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o website
	 * 
	 * Passos: Preencher campos do formulario (sem informar o website) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro � exibida
	 */
	@Test
	public void sendCommentWithoutWebsite() {
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "email@email.com", "", "mensagem");
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo:  Enviar um comentario sem preencher o comentario
	 * 
	 * Passos: Preencher campos do formulario (sem informar o comentario) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro � exibida
	 */
	@Test
	public void sendCommentWithoutMessage() {
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "email@email.com", "website", "");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Coment�rio � obrigat�rio");
	}
	
	
	/**
	 * Objetivo:  Enviar um comentario com email invalido
	 * 
	 * Passos: Preencher campos do formulario (usando email invalido) e submeter
	 * 
	 * Resultado Esperado: Mensagem de erro � exibida
	 */
	@Test
	public void sendCommentWithInvalidEmail(){
		FormularioSimplesPage.fillOutFormularioSimples("jos�", "jjj@ccc", "website", "mensagem");
		FormularioSimplesPage.assertErrorMessageIsShown();
		FormularioSimplesPage.assertDetailedErrorMessageIsShown("Email requer um endere�o de e-mail v�lido");
	}
}
