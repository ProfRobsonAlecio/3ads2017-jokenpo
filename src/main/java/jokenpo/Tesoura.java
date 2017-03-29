package jokenpo;

public class Tesoura extends Simbolo {

	private static Tesoura instance;

	public static Tesoura instance() {
		if (instance == null)
			instance = new Tesoura();
		
		return instance;
	}

	private Tesoura() {
	}
	
	@Override
	protected Simbolo simboloMaisFraco() {
		return Papel.instance();
	}

}
