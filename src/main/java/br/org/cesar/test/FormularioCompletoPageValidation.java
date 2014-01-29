package br.org.cesar.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.FormularioCompletoPage;
import br.org.cesar.util.Utils;

/**
 * Classe de testes com cenários relacionados a página inicial
 */
public class FormularioCompletoPageValidation extends BaseTestcase{

	/**
	 * Antes de cada teste acessa a página de formulário simples
	 * @throws Exception
	 */
	@Before
	public void before() throws Exception {
		driver.navigate().to("http://classedetestes.wordpress.com/formulario-completo/");
	}


	/**
	 * Objective: Form is successfully sent
	 * 
	 * Steps: Fill out all mandatory fields, set gender to male and RSS to checked and submit form
	 * 
	 * Expected Results: Success message is displayed
	 */
	@Test
	public void submitFormSuccessfullyMaleGenderRSSChecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
		
	/**
	 * Objective: Form is successfully sent
	 * 
	 * Steps: Fill out all mandatory fields, set gender to male and RSS to unchecked and submit form
	 * 
	 * Expected Results: Success message is displayed
	 */
	@Test
	public void submitFormSuccessfullyMaleGenderRSSUnchecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, false);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objective: Form is successfully sent
	 * 
	 * Steps: Fill out all mandatory fields, set gender to female, RSS to checked and submit form
	 * 
	 * Expected Results: Success message is displayed
	 */
	@Test
	public void submitFormSuccessfullyFemaleGenderRSSChecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",false, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objective: Form is successfully sent
	 * 
	 * Steps: Fill out all mandatory fields, set gender to female, RSS to unchecked and submit form
	 * 
	 * Expected Results: Success message is displayed
	 */
	@Test
	public void submitFormSuccessfullyFemaleGenderRSSUnchecked() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",false, false);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	/**
	 * Objective: Error message is shown if name is empty
	 * 
	 * Steps: Fill out all mandatory fields and set name to empty value
	 * 
	 * Expected Results: Error message is displayed and form is not submitted
	 */
	@Test
	public void nameFieldEmpty(){
		FormularioCompletoPage.fillOutFormularioCompleto("", "Pernambuco", true, true);
		FormularioCompletoPage.assertErrorMessageIsShown();
		FormularioCompletoPage.assertDetailedErrorMessageIsShown("Nome é obrigatório");
	}
	
	
}
