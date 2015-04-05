package br.org.cesar.common;

import br.org.cesar.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Página que disponibiliza os serviços (ações) presentes na pagina curso seleinum do
 * CLASSEDETESTES.WORDPRESS.COM
 * 
 * @author jcan
 * 
 */
public class CursoSeleniumPage {

	/**
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/**
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos
	 * metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Definição única dos locators utilizados na página
	 */
	static By ajaxLoadingLink = By.linkText("Ajax Loading");
	static By dragAndDropLink = By.linkText("Drag and Drop");
	static By startButton = By.cssSelector("button");
	static By finalMessage = By.id("finish");
	static By sourceLocator = By.id("draggable");
	static By targetLocator = By.id("droppable");



	public CursoSeleniumPage() {
	}

	/**
	 * Clicar no link HTML indicado
	 */
	public static void clickALink(String linkText) {
		By currentLocator = getLinkLocator(linkText);
		wait.until(ExpectedConditions.visibilityOfElementLocated(currentLocator));
		driver.findElement(currentLocator).click();
	}

	/**
	 * Metodo auxiliar para identificar locator
	 * @param htmlLink
	 * @return
	 */
	private static By getLinkLocator(String htmlLink) {
		if (htmlLink.equalsIgnoreCase("Ajax Loading")) {
			return ajaxLoadingLink;
		} else if (htmlLink.equalsIgnoreCase("Drag and Drop")) {
			return dragAndDropLink;
		} else {
			return null;
		}
	}

	/**
	 * Clicar no botão start
	 */
	public static void clickStartButton(){
		Utils.isClickable(startButton);
		driver.findElement(startButton).click();
	}

	/**
	 * Verificar se o texto passado como parametro é o mesmo exibido na tela
	 * @param expectedMessage
	 */
	public static void verifyMessageLoaded(String expectedMessage){
		Utils.isVisible(finalMessage);
		assertThat(driver.findElement(finalMessage).getText(), is(expectedMessage));
	}

	/**
	 * Realiza dragAndDrop para o link exemplo
	 */
	public static void dragAndDrop(){
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Utils.isClickable(sourceLocator);
		WebElement source = driver.findElement(sourceLocator);
		WebElement target = driver.findElement(targetLocator);
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target);
		action.build().perform();
	}

	/**
	 * Realiza drag and drop usando ações de mouse
	 */
	public static void dragAndDropDetailed(){
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement source = driver.findElement(sourceLocator);
		WebElement target = driver.findElement(targetLocator);
		Actions action = new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release();
		action.build().perform();
	}

	/**
	 * Verifies if message is updated on target location
	 * @param expectedMessage
	 */
	public static void verifyMessageAfterDrag(String expectedMessage){
		assertThat(driver.findElement(targetLocator).getText(), is(expectedMessage));
	}
}