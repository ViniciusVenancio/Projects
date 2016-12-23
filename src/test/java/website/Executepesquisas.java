package website;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import website.Pesquisarduck;
import website.Pesquisastackoverflow;
import website.PrimesearchChecker;


@RunWith(Parameterized.class)
public class Executepesquisas {
	private String inputsearch;
	private Boolean expectedResult;
	private Executepesquisas primesearchChecker;

	@Parameters
	public static Collection primesearch() {
		Pesquisarduck p = new Pesquisarduck();
		Pesquisastackoverflow x = new Pesquisastackoverflow();
		return Arrays.asList(new Object[][] { { p, true }, { x, true },

		});
	}

	@Before

	public void initialize() {
		primesearchChecker = new Executepesquisas();
	}

	public Executepesquisas(String inputsearch, Boolean expectedResult) {
		this.inputsearch = inputsearch;
		this.expectedResult = expectedResult;
	}

	@Test
	   public void testPrimesearchChecker() {
	      System.out.println("Parameterized search is : " + inputsearch);
	      assertEquals(expectedResult, 
	      primesearchChecker.validate(inputsearch));
	   }

	@After
	public void after() {

		System.out.println(String.format("Finalizando testes com o navegador '%s'", this.expectedResult));
	}
}
