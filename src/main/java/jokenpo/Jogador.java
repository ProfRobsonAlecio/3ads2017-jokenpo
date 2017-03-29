package jokenpo;

public class Jogador {

	private int numero;
	private int vitorias;

	public Jogador(int numero) {
		this.numero = numero;
		
		vitorias = 0;
	}

	public int getNumero() {
		return numero;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void acumularVitoria() {
		vitorias++;
	}

	public String imprimir() {
		return String.format("Jogador %d -> %d ponto(s)", numero, vitorias);
	}
	
}
