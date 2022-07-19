package fr.base.models;

/**
 * Classe qui définit le modèle Guerrier et hérite de classe abstraite
 * Personnage
 * <br>- Attribut arme de la classe Arme
 * 
 * @author Stéphane Abaza
 *
 */
public class Guerrier extends Personnage {

	private Arme _arme;

	public Guerrier(String prenom, String nom, Arme arme) {
		super(prenom, nom);
		this._arme = arme;
	}

	/**
	 * Méthode qui redéfinit la méthode abstraite attaquer de la classe Personnage
	 * <br>- Diminue le nombre de points de vie du personnage attaqué suivant la force de
	 * l'arme de l'attaquant Guerrier
	 * <br>- Diminue de 1 le nombre de points d'action de l'attaquant Guerrier
	 */
	@Override
	public void attaquer(Personnage personnage) {
		personnage.set_pointDeVie(personnage.get_pointDeVie() - this.get_arme().get_force());

		this.set_pointAction(this.get_pointAction() - 1);
	}

	public Arme get_arme() {
		return _arme;
	}

	public void set_arme(Arme arme) {
		this._arme = arme;
	}
}
