package fr.base.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.base.models.Personnage;

/**
 * Classe qui gère les affichages dans la console
 * 
 * @author Stéphane Abaza
 *
 */
public final class DisplayConsole {
	
	private static BufferedReader _bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	private DisplayConsole() {
		
	}
	
	/**
	 * Méthode qui affiche le prénom, le nom du Personnage gagnant
	 * 
	 * @param gagnant objet Personnage
	 */
	public static void afficheGagnant(Personnage gagnant) {
		System.out.println(gagnant.get_prenom() + " " + gagnant.get_nom() + " a gagné.");
	}
	
	/**
	 * Méthode qui affiche le prénom, le nom, le nombre de points de vie et le nombre de points d'action pour chaque Personnage
	 * 
	 * @param personnageTableau tableau d'objets Personnage
	 */
	public static void affichePointDeViePointAttaque(Personnage[] personnageTableau) {
		
		for (Personnage personnage : personnageTableau) {
			System.out.println(personnage.get_prenom() + " " + personnage.get_nom() +
					" - ptnVie = " + personnage.get_pointDeVie() +
					" // pa = " + personnage.get_pointAction());
		}
	}
	
	/**
	 * Méthode qui affiche un menu et retourne le choix de l'utilisateur
	 * 
	 * @param i int: Numéro de personnage
	 * @return int: Numéro de choix
	 */
	public static int choixPersonnage(int i) {
		System.out.println("Choix du personnage " + (i + 1));
		System.out.println("[1] Guerrier");
		System.out.println("[2] Sorcier");
		System.out.println("[3] Soigneur");
		System.out.println("[4] Aléatoire");
		
		int choix = -1;
		
		try {
			choix = Integer.parseInt(_bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return choix;
	}
	
	/**
	 * Méthode qui affiche le prénom, le nom du gagnant et le prénom, le nom, le nombre de points de vie et le nombre de points d'action pour chaque Personnage
	 * 
	 * @param personnageTableau tableau d'objets Personnage
	 */
	public static void affichageEndGame(Personnage[] personnageTableau) {
		System.out.println();
		
		if (personnageTableau[0].get_pointDeVie() <= 0) {
			DisplayConsole.afficheGagnant(personnageTableau[1]);
		}
		
		if (personnageTableau[1].get_pointDeVie() <= 0) {
			DisplayConsole.afficheGagnant(personnageTableau[0]);
		}
		DisplayConsole.affichePointDeViePointAttaque(personnageTableau);
	}
	
	/**
	 * Méthode qui demande à l'utilisateur s'il souhaite relancer le jeu ou quitter le jeu
	 * 
	 * @return boolean true ou false: true si l'utilisateur souhaite relancer le jeu, false pour quitter le jeu
	 */
	public static boolean endGame() {
		
		boolean continueGame = true;
		
		System.out.println("Recommencer le jeu ? tapez Oui");
		
		try {
			if(!_bufferedReader.readLine().equalsIgnoreCase("Oui")) {
				continueGame = false;
				
				// Ferme le stream
				_bufferedReader.close();
				System.out.println("Fin jeu au revoir");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------------------------------");
		
		return continueGame;
	}
}
