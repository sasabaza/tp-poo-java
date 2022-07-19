package fr.base.utils;

/**
 * Classe utilitaire qui regroupe toutes les méthodes utilisées dans le
 * programme
 * 
 * @author Stéphane Abaza
 *
 */
public final class Utils {

	private Utils() {

	}

	/**
	 * Méthode qui génére un nombre aléatoire entre les nombres min et max
	 * 
	 * @param min double: nombre minimum
	 * @param max double: nombre maximum
	 * @return double aléatoire entre min et max
	 */
	public static double nombreAleatoire(double min, double max) {
		return Math.floor(Math.random() * (max - min + 1) + min);
	}
}