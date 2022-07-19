package fr.base.models;

/**
 * Classe qui définit le modèle Sorcier et hérite de classe abstraite Personnage
 * <br>- Attribut pouvoir de la classe Pouvoir
 * 
 * @author Stéphane Abaza
 *
 */
public class Sorcier extends Personnage {

	private Pouvoir _pouvoir;

	public Sorcier(String prenom, String nom, Pouvoir pouvoir) {
		super(prenom, nom);
		this._pouvoir = pouvoir;
	}

	/**
	 * Méthode qui redéfinit la méthode abstraite attaquer de la classe Personnage
	 * <br>- Diminue le nombre de points de vie du personnage attaqué suivant la force de
	 * l'arme de l'attaquant Sorcier
	 * <br>- Diminue de 1 le nombre de points d'action de l'attaquant Sorcier
	 */
	@Override
	public void attaquer(Personnage personnage) {
		personnage.set_pointDeVie(personnage.get_pointDeVie() - this.get_pouvoir().get_force());

		this.set_pointAction(this.get_pointAction() - 1);
	}

	public Pouvoir get_pouvoir() {
		return _pouvoir;
	}

	public void set_pouvoir(Pouvoir pouvoir) {
		this._pouvoir = pouvoir;
	}
}
