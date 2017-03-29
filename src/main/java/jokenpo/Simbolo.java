package jokenpo;

public abstract class Simbolo {

	public boolean ganhaDe(Simbolo outroSimbolo) {
		return simboloMaisFraco() == outroSimbolo;
	}
	
	protected abstract Simbolo simboloMaisFraco();

}
