package br.org.cesar.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.org.cesar.common.FormularioSimplesPage;
import br.org.cesar.util.SpreadsheetData;

@RunWith(Parameterized.class)
public class FormularioSimplesXLSValidation extends BaseTestcase {

	private String nome;
	private String email;
	private String assunto;
	private String mensagem;

	/**
	 * Construtor da classe
	 * 
	 * @param nome
	 * @param email
	 * @param assunto
	 * @param mensagem
	 */
	public FormularioSimplesXLSValidation(String nome, String email,
			String assunto, String mensagem) {
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}

	@Parameters
	public static Collection<Object[]> spreadsheetData() throws IOException {
		InputStream spreadsheet = new FileInputStream(
				"src\\main\\resources\\faleConoscoInput.xls");
		return new SpreadsheetData(spreadsheet).getData();
	}
	
/*
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { "jcan", "jcan@tes.tec", "assunto", "msg2" },
				{"jcan3", "jcan@tes.tec", "assunto3", "msg3" } });
	}*/

	/**
	 * Preenche o formulário simples e o submete
	 */
	@Test
	public void preencherFormularioSimples() {
		driver.navigate().to(
				"http://classedetestes.wordpress.com/formulario-simples/");
		FormularioSimplesPage.fillOutFormularioSimples(this.nome, this.email,
				this.assunto, this.mensagem);
		FormularioSimplesPage.assertSuccessMessageIsShown();
	}
}
