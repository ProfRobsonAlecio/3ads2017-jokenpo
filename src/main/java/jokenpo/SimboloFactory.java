package jokenpo;

public abstract class SimboloFactory {

	public static Simbolo getSimbolo(char letra) {
		switch (letra) {
		case 'P': return Pedra.instance();
		case 'p': return Papel.instance();
		case 't': return Tesoura.instance();
		default: throw new RuntimeException("Que raios de simbolo é '" + letra + "'?");
		}
	}

}
