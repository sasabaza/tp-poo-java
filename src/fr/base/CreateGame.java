package fr.base;

import fr.base.models.Arme;
import fr.base.models.Guerrier;
import fr.base.models.Personnage;
import fr.base.models.Pouvoir;
import fr.base.models.Soigneur;
import fr.base.models.Sorcier;
import fr.base.utils.Utils;
import fr.base.view.DisplayConsole;

/**
 * Classe qui permet de créer et lancer le jeu
 * 
 * @author Stéphane Abaza
 *
 */
public class CreateGame {

	// Nombre total de personnages
	private static final int NOMBRE_PERSONNAGE = 2;

	private static Personnage[] _personnageTableau;

	public CreateGame() {
		CreateGame._personnageTableau = new Personnage[NOMBRE_PERSONNAGE];
	}

	/**
	 * Méthode qui lance le jeu
	 */
	public void runGame() {

		boolean continueGame = true;

		// Tant que la variable continueGame vaut true le jeu se relance à nouveau
		while (continueGame) {

			CreateGame.initilisation();
			CreateGame.combat();
			DisplayConsole.affichageEndGame(_personnageTableau);

			continueGame = DisplayConsole.endGame();
		}
	}

	/**
	 * Méthode qui initialise le tableau de personnages suivant les choix entrés par
	 * l'utilisateur dans la console
	 */
	private static void initilisation() {
		for (int i = 0; i < NOMBRE_PERSONNAGE; i++) {
			int choix = DisplayConsole.choixPersonnage(i);
			CreateGame.initPersonnages(choix, i);
		}
	}

	/**
	 * Méthode qui crée un nouveau personnage et insère le personnage dans le
	 * tableau de personnages
	 * 
	 * @param choix int: Numéro de choix (1=Guerrier, 2=Sorcier, 3=Soigneur,
	 *              4=Aléatoire, default=Aléatoire)
	 * @param i     int: Numéro de personnage
	 */
	private static void initPersonnages(int choix, int i) {
		switch (choix) {
		case 1:
			CreateGame._personnageTableau[i] = new Guerrier("Prénom Guerrier " + (i + 1), "Nom Guerrier " + (i + 1),
					new Arme("Arme " + (i + 1), 2));
			break;
		case 2:
			CreateGame._personnageTableau[i] = new Sorcier("Prénom Sorcier " + (i + 1), "Nom Sorcier " + (i + 1),
					new Pouvoir("Pouvoir " + (i + 1), 2));
			break;
		case 3:
			CreateGame._personnageTableau[i] = new Soigneur("Prénom Soigneur " + (i + 1), "Nom Soigneur " + (i + 1));
			break;
		case 4:
			CreateGame._personnageTableau[i] = CreateGame.randomPersonnage(i);
			break;
		default:
			CreateGame._personnageTableau[i] = CreateGame.randomPersonnage(i);
		}
	}

	/**
	 * Méthode qui réalise le combat entre les 2 personnages jusqu'à ce qu'un des 2
	 * personnages n'a plus de vie
	 */
	private static void combat() {
		while (CreateGame._personnageTableau[0].get_pointDeVie() > 0
				&& CreateGame._personnageTableau[1].get_pointDeVie() > 0) {
			int nombreAleatoire = (int) Utils.nombreAleatoire(0, 1);

			if (nombreAleatoire == 0 && CreateGame._personnageTableau[0].get_pointAction() > 0) {
				CreateGame._personnageTableau[0].attaquer(CreateGame._personnageTableau[1]);
			}

			if (nombreAleatoire == 1 && CreateGame._personnageTableau[1].get_pointAction() > 0) {
				CreateGame._personnageTableau[1].attaquer(CreateGame._personnageTableau[0]);
			}

			// Affichage du nombre de points de vie et points d'attaque pour chaque
			// personnage
			DisplayConsole.affichePointDeViePointAttaque(CreateGame._personnageTableau);
		}
	}

	/**
	 * Méthode qui génére un personnage aléatoire de type Guerrier, Sorcier ou
	 * Soigneur
	 * 
	 * @param i int: correspond au numéro du personnage
	 * @return objet Personnage
	 */
	private static Personnage randomPersonnage(int i) {
		int nombreAleatoire = (int) Utils.nombreAleatoire(1, 3);

		Personnage personnage = null;

		switch (nombreAleatoire) {
		case 1:
			personnage = new Guerrier("Prénom Guerrier " + (i + 1), "Nom Guerrier " + (i + 1),
					new Arme("Arme " + (i + 1), 2));
			break;
		case 2:
			personnage = new Sorcier("Prénom Sorcier " + (i + 1), "Nom Sorcier " + (i + 1),
					new Pouvoir("Pouvoir " + (i + 1), 2));
			break;
		case 3:
			personnage = new Soigneur("Prénom Soigneur " + (i + 1), "Nom Soigneur " + (i + 1));
			break;
		}

		return personnage;
	}
}
