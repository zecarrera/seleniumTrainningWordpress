package br.org.cesar.test;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioCompletoPage;
import br.org.cesar.common.HomePage;

/**
 * Classe de testes com cenários relacionados a página de formulario completo
 */
public class FormularioCompletoPageValidation extends BaseTestcase{

	/**
	 * Antes de cada teste acessa a página de formulário completo
	 * @throws Exception
	 */
	@Before
	public void before() throws Exception {
		HomePage.clickMenuElement("selenium", "Formulário Completo");
	}


	/**
	 * Objetivo: Formulario é submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para masculino e marcar opcao RSS em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso é exibida
	 */
	@Test
	public void submitFormSuccessfullyMaleGenderRSSChecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
		
	/**
	 * Objetivo: Formulario é submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para masculino e RSS desmarcado em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso é exibida
	 */
	@Test
	public void submitFormSuccessfullyMaleGenderRSSUnchecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, false);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo: Formulario é submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para feminino e marcar opcao RSS em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso é exibida
	 */
	@Test
	public void submitFormSuccessfullyFemaleGenderRSSChecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",false, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo: Formulario é submetido com sucesso
	 * 
	 * Passos: Preencher campos obrigatorios, definir sexo para feminino e RSS desmarcado em seguida submeter formulario
	 * 
	 * Resultados Esperados: Mensagem de sucesso é exibida
	 */
	@Test
	public void submitFormSuccessfullyFemaleGenderRSSUnchecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",false, false);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objetivo: Mensagem de erro é exibida se nome estiver vazio
	 * 
	 * Passos: Preencher campos, porém deixar nome vazio e submeter formulário
	 * 
	 * Resultado Esperado: Mensagem de erro é exibida e formulário não é enviado
	 */
	@Test
	public void nameFieldEmpty(){
		FormularioCompletoPage.fillOutFormularioCompleto("", "Pernambuco", true, true);
		FormularioCompletoPage.assertErrorMessageIsShown();
		FormularioCompletoPage.assertDetailedErrorMessageIsShown("Nome é obrigatório");
	}
	
	
}
