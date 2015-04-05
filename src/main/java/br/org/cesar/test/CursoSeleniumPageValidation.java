package br.org.cesar.test;

import br.org.cesar.common.CursoSeleniumPage;
import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes com cenários relacionados a página inicial
 */
public class CursoSeleniumPageValidation extends BaseTestcase{

	@Before
	public void before() throws Exception {
		//driver.manage().window().maximize();
	}


	/**
	 * Objetivo:
	 * 
	 * Passos:
	 * 
	 * Resultado Esperado:
	 */
	@Test
	public void ajaxLoading() {
		HomePage.clickMenuElement("Selenium", "Curso Selenium");
		CursoSeleniumPage.clickALink("Ajax Loading");
		CursoSeleniumPage.clickStartButton();
		CursoSeleniumPage.verifyMessageLoaded("Hello World!");
	}


	/**
	 * Objetivo:
	 *
	 * Passos:
	 *
	 * Resultado Esperado:
	 */
	@Test
	public void dragAndDrop() {
		HomePage.clickMenuElement("Selenium", "Curso Selenium");
		CursoSeleniumPage.clickALink("Drag and Drop");
		CursoSeleniumPage.dragAndDrop();
		CursoSeleniumPage.verifyMessageAfterDrag("Dropped!");
	}

	@After
	public void after() throws Exception {
		driver.get("http://www.classedetestes.wordpress.com");
	}
}
