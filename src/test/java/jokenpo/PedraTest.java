package jokenpo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class PedraTest {

	@Test
	public void ganhaDeTesoura() {
		assertThat(Pedra.instance().ganhaDe(Tesoura.instance())).isTrue();
	}
	
	@Test
	public void perdeDePapel() {
		assertThat(Pedra.instance().ganhaDe(Papel.instance())).isFalse();
	}
	
}
