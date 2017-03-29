package jokenpo;

public class Pedra extends Simbolo {
	
	private static Pedra instance;

	public static Pedra instance() {
		if (instance == null)
			instance = new Pedra();
		
		return instance;
	}

	private Pedra() {
	}

	@Override
	protected Simbolo simboloMaisFraco() {
		return Tesoura.instance();
	}

}
