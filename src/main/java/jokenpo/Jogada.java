package jokenpo;

public class Jogada {

	private Jogador jogador;
	private Simbolo simbolo;

	public Jogada(Jogador jogador, Simbolo simbolo) {
		this.jogador = jogador;
		this.simbolo = simbolo;
	}
	
	public Simbolo getSimbolo() {
		return simbolo;
	}

	public Jogada competeCom(Jogada outraJogada) {
		return simbolo.ganhaDe(outraJogada.getSimbolo()) ? this : outraJogada;
	}

	public void notificarVitoria() {
		jogador.acumularVitoria();
	}

}
