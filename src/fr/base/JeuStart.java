package fr.base;

/**
 * Classe qui instancie la classe CreateGame et lance le jeu
 * 
 * @author Stéphane Abaza
 *
 */
public class JeuStart {

	/**
	 * Point d'entrée du programme
	 * 
	 * @param args tableau de String
	 */
	public static void main(String[] args) {

		CreateGame createGame = new CreateGame();
		createGame.runGame();
	}
}
