package website;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class Pesquisarduck {
	private String browser;

	public Pesquisarduck(String browser) {
		this.browser = browser;
	}

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private WebDriverWait wait;

	@Parameters
	public static String[] data() {
		return new String[] { "FIREFOX", "CHROME" };
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando testes com o navegador: ");
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "/Users/Vinicius/Downloads/geckodrivers/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "/Users/Vinicius/Downloads/geckodrivers/chromedriver");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("BLA");
			System.exit(0);
			break;
		}
		baseUrl = "https://duckduckgo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void testScripPesquisa() throws Exception {
		try {
			driver.get(baseUrl);
			driver.findElement(By.id("search_form_input_homepage")).clear();
			driver.findElement(By.id("search_form_input_homepage")).sendKeys("apple.com");
			driver.findElement(By.id("search_button_homepage")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple")));
			driver.findElement(By.linkText("Apple")).click();
			Thread.sleep(5000);
			System.out.println("SUCESSO");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO");
		}
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(String.format("Finalizando testes com o navegador"));
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
