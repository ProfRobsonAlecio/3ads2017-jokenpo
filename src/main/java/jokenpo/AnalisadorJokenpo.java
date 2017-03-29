package jokenpo;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AnalisadorJokenpo {

	public static String processar(String... rodadasRaw) {
		validarRodadas(rodadasRaw);
		
		Jogador[] jogadores = criarJogadores(rodadasRaw[0].length());
		Rodada[] rodadas = renderizarRodadas(rodadasRaw, jogadores);
		
		avaliarRodadas(rodadas);
		
		return montarResultado(jogadores);
	}

	private static String montarResultado(Jogador[] jogadores) {
		ArrayList<Jogador> jogadoresOrdenados = new ArrayList<>(Arrays.asList(jogadores));
		jogadoresOrdenados.sort((o1, o2) -> {
			if (o1.getVitorias() == o2.getVitorias())
				return 0;
			
			return o1.getVitorias() < o2.getVitorias() ? 1 : -1;
		});
		
		String resultado = "";
		for (Jogador jogador : jogadoresOrdenados)
			resultado += jogador.imprimir() + '\n';
		
		resultado += "-----------------------\n";
		
		resultado += "Campeão => Jogador " + jogadoresOrdenados.get(0).getNumero();
		
		return resultado;
	}

	private static void avaliarRodadas(Rodada[] rodadas) {
		for (Rodada rodada : rodadas) {
			Jogada jogadaVitoriosa = rodada.encontrarJogadaVitoriosa();
			jogadaVitoriosa.notificarVitoria();
		}
	}

	private static Rodada[] renderizarRodadas(String[] rodadasRaw, Jogador[] jogadores) {
		Rodada[] rodadas = new Rodada[rodadasRaw.length];
		
		for (int numeroRodada = 0; numeroRodada < rodadasRaw.length; numeroRodada++)
			rodadas[numeroRodada] = new Rodada(rodadasRaw[numeroRodada], jogadores);
		
		return rodadas;
	}

	private static Jogador[] criarJogadores(int quantidadeJogadores) {
		Jogador[] jogadores = new Jogador[quantidadeJogadores];
		
		for (int i = 0; i < quantidadeJogadores; i++)
			jogadores[i] = new Jogador(i+1);
		
		return jogadores;
	}

	private static void validarRodadas(String[] rodadasRaw) {
		if (rodadasRaw.length == 0)
			throw new RuntimeException("Não é permitido um jogo sem rodadas.");
		
		int jogadoresNaPrimeiraRodada = rodadasRaw[0].length();
		validarSimbolosRodada(0, rodadasRaw[0]);
		for (int numeroRodada = 1; numeroRodada < rodadasRaw.length; numeroRodada++) {
			String rodadaRaw = rodadasRaw[numeroRodada];
			int jogadoresNaRodadaAtual = rodadaRaw.length();
			
			if (jogadoresNaPrimeiraRodada != jogadoresNaRodadaAtual) {
				String message = String.format("Rodada #%d tem %d jogadores enquanto as anteriores tem %d jogadores.", numeroRodada + 1, jogadoresNaRodadaAtual, jogadoresNaPrimeiraRodada);
				throw new RuntimeException(message);
			}
			
			validarSimbolosRodada(numeroRodada, rodadaRaw);
		}
	}

	private static void validarSimbolosRodada(int numeroRodada, String rodadaRaw) {
		if (!rodadaRaw.matches("[ptP]*")) {
			String message = String.format("Rodada #%d tem algum símbolo que não é reconhecido pelo jogo.", numeroRodada + 1);
			throw new RuntimeException(message);
		}
	}
	
}
