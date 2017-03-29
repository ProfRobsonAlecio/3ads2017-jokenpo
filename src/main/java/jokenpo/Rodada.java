package jokenpo;

public class Rodada {

	private Jogada[] jogadas;
	
	public Rodada(String rodadaRaw, Jogador[] jogadores) {
		jogadas = new Jogada[jogadores.length];
		
		for (int i = 0; i < rodadaRaw.length(); i++) {
			char letra = rodadaRaw.charAt(i);
			Simbolo simbolo = SimboloFactory.getSimbolo(letra);
			
			jogadas[i] = new Jogada(jogadores[i], simbolo);
		}
	}

	public Jogada encontrarJogadaVitoriosa() {
		Jogada jogadaVitoriosa = jogadas[0].competeCom(jogadas[1]);
		
		for (int i = 2; i < jogadas.length; i++) 
			jogadaVitoriosa = jogadaVitoriosa.competeCom(jogadas[i]);
		
		return jogadaVitoriosa;
	}

}
