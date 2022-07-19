package fr.base.models;

/**
 * Classe qui définit le modèle Soigneur et hérite de classe abstraite
 * Personnage
 * 
 * @author Stéphane Abaza
 *
 */
public class Soigneur extends Personnage {

	public Soigneur(String prenom, String nom) {
		super(prenom, nom);
	}

	/**
	 * Méthode qui redéfinit la méthode abstraite attaquer de la classe Personnage
	 * <br>- Diminue le nombre de points de vie du personnage attaqué de 1
	 * <br>- Augmente de 1 le nombre de points de vie de l'attaquant Soigneur
	 */
	@Override
	public void attaquer(Personnage personnage) {
		personnage.set_pointDeVie(personnage.get_pointDeVie() - 1);
		this.set_pointDeVie(this.get_pointDeVie() + 1);
	}
}
