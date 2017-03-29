package jokenpo;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

import org.junit.Test;

public class AnalisadorJokenpoTest {
	
	@Test
	public void naoPermiteAnalisarJogoSemRodadas() {
		try {
			AnalisadorJokenpo.processar();
			fail("Não deveria ter aceito jogo sem rodadas");
		} catch (RuntimeException e) {
			assertThat(e.getMessage()).isEqualTo("Não é permitido um jogo sem rodadas.");
		}
	}
	
	@Test
	public void naoPermiteRodadasComUmaRodadaComUmJogadorAMenos() {
		try {
			AnalisadorJokenpo.processar("pPt", "Pp");
			fail("Não deveria ter aceito rodadas incompatíveis com as outras em número de jogadores.");
		} catch (RuntimeException e) {
			assertThat(e.getMessage()).isEqualTo("Rodada #2 tem 2 jogadores enquanto as anteriores tem 3 jogadores.");
		}
	}

	@Test
	public void naoPermiteRodadasComUmaRodadaComUmJogadorAMais() {
		try {
			AnalisadorJokenpo.processar("pPt", "Pptp");
			fail("Não deveria ter aceito rodadas incompatíveis com as outras em número de jogadores.");
		} catch (RuntimeException e) {
			assertThat(e.getMessage()).isEqualTo("Rodada #2 tem 4 jogadores enquanto as anteriores tem 3 jogadores.");
		}
	}
	
	@Test
	public void permiteJogoComApenasUmaRodada() {
		AnalisadorJokenpo.processar("pPt");
	}
	
	@Test
	public void naoPermiteSimbolosEstranhos() {
		try {
			AnalisadorJokenpo.processar("xt");
			fail("Não deveria ter aceito rodadas símbolos inválidos.");
		} catch (RuntimeException e) {
			assertThat(e.getMessage()).isEqualTo("Rodada #1 tem algum símbolo que não é reconhecido pelo jogo.");
		}
	}
	
	@Test
	public void naoPermiteSimbolosEstranhosSegundaRodada() {
		try {
			AnalisadorJokenpo.processar("pP", "xt");
			fail("Não deveria ter aceito rodadas símbolos inválidos.");
		} catch (RuntimeException e) {
			assertThat(e.getMessage()).isEqualTo("Rodada #2 tem algum símbolo que não é reconhecido pelo jogo.");
		}
	}
	
	@Test
	public void papelGanhaDePedra() {
		String resultado = AnalisadorJokenpo.processar("pP");
		assertThat(resultado).isEqualTo(
				"Jogador 1 -> 1 ponto(s)\n" + 
				"Jogador 2 -> 0 ponto(s)\n" + 
				"-----------------------\n" + 
				"Campeão => Jogador 1");
	}
	
	@Test
	public void pedraGanhaDeTesoura() {
		String resultado = AnalisadorJokenpo.processar("tP");
		assertThat(resultado).isEqualTo(
				"Jogador 2 -> 1 ponto(s)\n" + 
				"Jogador 1 -> 0 ponto(s)\n" + 
				"-----------------------\n" + 
				"Campeão => Jogador 2");
	}
	
	@Test
	public void tesouraGanhaDePapel() {
		String resultado = AnalisadorJokenpo.processar("tp");
		assertThat(resultado).isEqualTo(
				"Jogador 1 -> 1 ponto(s)\n" + 
				"Jogador 2 -> 0 ponto(s)\n" + 
				"-----------------------\n" + 
				"Campeão => Jogador 1");
	}
	
	@Test
	public void tresJogadoresPorCincoRodadas() {
		String resultado = AnalisadorJokenpo.processar(
				"tpP",
				"ptp",
				"tPp",
				"Ppt",
				"Ptp"
				);
		assertThat(resultado).isEqualTo(
				"Jogador 3 -> 4 ponto(s)\n" + 
				"Jogador 2 -> 1 ponto(s)\n" + 
				"Jogador 1 -> 0 ponto(s)\n" + 
				"-----------------------\n" + 
				"Campeão => Jogador 3");
	}
	
}
