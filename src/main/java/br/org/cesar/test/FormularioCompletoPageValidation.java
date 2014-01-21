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
	 *  Enviar um formulario com sucesso
	 */
	@Test
	public void submitFormSuccessfully() {
		FormularioCompletoPage.fillOutFormularioCompleto("jose", "Pernambuco",true, true);
		FormularioCompletoPage.assertSuccessMessageIsShown();
	}
	
	
}
