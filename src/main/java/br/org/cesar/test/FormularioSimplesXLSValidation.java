package br.org.cesar.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.org.cesar.common.FormularioSimplesPage;
import br.org.cesar.util.SpreadsheetData;

@RunWith(Parameterized.class)
public class FormularioSimplesXLSValidation extends BaseTestcase{
	/**
	 * Example app is Selenium Simplified book given example
	 * Tests for calculation example
	 */

	private String nome;
	private String email;
	private String assunto;
	private String mensagem;
	
	/**
	 * Class constructor
	 * @param num1
	 * @param function
	 * @param num2
	 * @param answer
	 */
	public FormularioSimplesXLSValidation(String nome, String email, String assunto,
			String mensagem) {
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}

	@Parameters
	public static Collection spreadsheetData() throws IOException {
		InputStream spreadsheet = new FileInputStream("src\\main\\resources\\faleConoscoInput.xls");
		return new SpreadsheetData(spreadsheet).getData();
	}

	/**
	 * Opens an fills out fale conosco form
	 */
	@Test
	public void openFaleConoscoPage(){
		driver.navigate().to("http://classedetestes.wordpress.com/formulario-simples/");
		FormularioSimplesPage.fillOutFormularioSimples(this.nome, this.email, this.assunto, this.mensagem);
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
}
