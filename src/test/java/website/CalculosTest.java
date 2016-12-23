package website;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculosTest {

	private Calculo calc;

	public CalculosTest(Calculo calc) {
		this.calc = calc;
	}

	@Parameters(name="{index}")
	public static Calculo[] data() {

		Calculo calc1 = new Calculo();
		calc1.setValorA(1);
		calc1.setValorB(2);
		calc1.setResultado(3);

		Calculo calc2 = new Calculo();
		calc2.setValorA(2);
		calc2.setValorB(2);
		calc2.setResultado(4);

		return new Calculo[] { calc1, calc2 };
	}

	@Before
	public void before() {
		// System.out.println("Iniciando testes com o navegador: " + this.calc);
	}

	@Test
	public void script() {
		Assert.assertEquals(calc.getValorA() + calc.getValorB(), calc.getResultado());
	}

	@After
	public void after() {
		// System.out.println(String.format("Finalizando testes com o navegador
		// '%s'", this.calc));
	}
}
