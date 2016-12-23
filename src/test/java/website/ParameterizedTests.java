package website;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTests {

	private String browser;

	public ParameterizedTests(String browser) {
		this.browser = browser;
	}

	@Parameters
	public static String[] data() {
		return new String[] { "FIREFOX", "CHROME" };
	}

	@Before
	public void before() {
		System.out.println("Iniciando testes com o navegador: " + this.browser);
	}

	@Test
	public void test() {
		System.out.println(this.browser);
	}

	@After
	public void after() {

		System.out.println(String.format("Finalizando testes com o navegador %s'", this.browser));
	}
}
