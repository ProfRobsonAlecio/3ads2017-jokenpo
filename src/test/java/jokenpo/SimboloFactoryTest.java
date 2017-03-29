package jokenpo;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

import org.junit.Test;

public class SimboloFactoryTest {

	@Test
	public void reclamarDeSimboloEstranho() {
		try {
			SimboloFactory.getSimbolo('y');
			fail("Não deveria ter aceito esse simbolo.");
		} catch (RuntimeException e) {
			assertThat(e.getMessage()).isEqualTo("Que raios de simbolo é 'y'?");
		}
	}
}
