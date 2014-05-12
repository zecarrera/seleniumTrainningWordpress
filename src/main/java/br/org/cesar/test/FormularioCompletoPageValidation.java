package br.org.cesar.test;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioCompletoPage;
import br.org.cesar.common.HomePage;

/**
 * Classe de testes com cen�rios relacionados a p�gina de formulario completo
 */
public class FormularioCompletoPageValidation extends BaseTestcase{

	/**
	 * Antes de cada teste acessa a p�gina de formul�rio completo
	 * @throws Exception
	 */
	@Before
	public void before() throws Exception {
		HomePage.clickMenuElement("selenium", "Formul�rio Completo");
	}


	/**
	 * Objetivo: Formulario � submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para masculino e marcar opcao RSS em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso � exibida
	 */
	@Test
	public void submitFormSuccessfullyMaleGenderRSSChecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
		
	/**
	 * Objetivo: Formulario � submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para masculino e RSS desmarcado em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso � exibida
	 */
	@Test
	public void submitFormSuccessfullyMaleGenderRSSUnchecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, false);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo: Formulario � submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para feminino e marcar opcao RSS em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso � exibida
	 */
	@Test
	public void submitFormSuccessfullyFemaleGenderRSSChecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",false, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo: Formulario � submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para feminino e RSS desmarcado em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso � exibida
	 */
	@Test
	public void submitFormSuccessfullyFemaleGenderRSSUnchecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",false, false);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo: Mensagem de erro � exibida se nome estiver vazio
	 * 
	 * Passos: Preencher campos, por�m deixar nome vazio e submeter formul�rio
	 * 
	 * Resultado Esperado: Mensagem de erro � exibida e formul�rio n�o � enviado
	 */
	@Test
	public void nameFieldEmpty(){
		FormularioCompletoPage.fillOutFormularioCompleto("", "Pernambuco", true, true);
		FormularioCompletoPage.assertErrorMessageIsShown();
		FormularioCompletoPage.assertDetailedErrorMessageIsShown("Nome � obrigat�rio");
	}
	
	
}
