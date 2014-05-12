package br.org.cesar.common;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/*
 * Executa todas as acoes na pagina formulario completo
 */
public class FormularioCompletoPage {

	/*
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;

	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
	}
	
	 // The home page contains several HTML elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.
	static By nameField = By.id("g22-nome");
	static By estadoField = By.id("g22-estado");
	static By sexoMasculino = By.name("g22-sexo");
	static By sexoFeminino = By.xpath("(//input[@name='g22-sexo'])[2]");
	static By feedRSSField = By.name("g22-assinarfeedrss");
	static By enviarButtonLocator = By.xpath("//input[@value='Enviar »']");
	static By tituloMensagemFormularioCompleto = By.cssSelector("h3");
	static By mensagemDetalhadaFormularioCompleto = By.cssSelector("li.form-error-message");

	public FormularioCompletoPage() {
	}

	
	
	/**
	 * Preencher campo nome
	 */
	public static void fillOutNome(String nome){
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(nome);
	}
	
	/**
	 * Preencher campo Estado
	 */
	public static void fillOutEstado(String estado){
		new Select(driver.findElement(estadoField)).selectByVisibleText(estado);
	}
	
	/**
	 * Preencher campo Sexo
	 */
	public static void fillOutSexo(boolean isSexoMasculino){
		if (isSexoMasculino){
			driver.findElement(sexoMasculino).click();
		} else{
			driver.findElement(sexoFeminino).click();
		}
	}
	
	/**
	 * Marcar checkbox RSS
	 */
	public static void fillOutRSS(boolean isMarked){
		if(isMarked){
			driver.findElement(feedRSSField).click();
		} else {
			if (driver.findElement(feedRSSField).isSelected()){
				driver.findElement(feedRSSField).click();
			}
		}
	}
	
	/**
	 * Clicar botao enviar
	 */
	public static void clickEnviarButton(){
		driver.findElement(enviarButtonLocator).click();
	}
	
	/**
	 * Preencher formulario completo
	 */
	public static void fillOutFormularioCompleto(String nome, String estado, boolean isSexoMasculino, boolean RSSAtivo){
		fillOutNome(nome);
		fillOutEstado(estado);
		fillOutSexo(isSexoMasculino);
		fillOutRSS(RSSAtivo);
		clickEnviarButton();
	}
	
	
	/**
	 * Verificar se mensagem de sucesso é exibida corretamente
	 */
	public static void assertSuccessMessageIsShown(){
		Utils.isVisible(tituloMensagemFormularioCompleto);
		assertThat("Mensagem de Sucesso não está correta",  driver.findElement(tituloMensagemFormularioCompleto).getText(), is("A mensagem foi enviada (voltar)")); 
	}
	
	/**
	 * Verificar se mensagem de erro é exibida corretamente
	 */
	public static void assertErrorMessageIsShown() {
		Utils.isVisible(tituloMensagemFormularioCompleto);
		assertThat("Mensagem de Erro não está correta", driver.findElement(tituloMensagemFormularioCompleto).getText(), is("Erro!"));
	}

	/**
	 * Verificar se mensagem de erro detalhada é exibida corretamente
	 * Verifica a primeira mensagem detalhada
	 */
	public static void assertDetailedErrorMessageIsShown(String errorMessage){
		Utils.isVisible(mensagemDetalhadaFormularioCompleto);
		assertThat("Mensagem detalhada está errada", driver.findElement(mensagemDetalhadaFormularioCompleto).getText(), is(errorMessage));
	}
	
}