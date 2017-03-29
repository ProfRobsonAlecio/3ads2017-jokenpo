package jokenpo;

public class Papel extends Simbolo {

	private static Papel instance;

	public static Papel instance() {
		if (instance == null)
			instance = new Papel();
		
		return instance;
	}

	private Papel() {
	}
	
	@Override
	protected Simbolo simboloMaisFraco() {
		return Pedra.instance();
	}

}
