package fr.base.models;

/**
 * Classe abstraite qui définit le modèle Personnage
 * <br>- Attribut pointDeVie de type entier
 * <br>- Attribut pointAction de type entier
 * <br>- Attribut prénom de la classe String
 * <br>- Attribut nom de la classe String
 * <br>Le constructeur initialise les attributs pointDeVie et pointAction à 10
 * 
 * @author Stéphane Abaza
 *
 */
public abstract class Personnage {

	private int _pointDeVie;
	private int _pointAction;
	private String _prenom;
	private String _nom;

	public Personnage(String prenom, String nom) {
		this._pointDeVie = 10;
		this._pointAction = 10;
		this._prenom = prenom;
		this._nom = nom;
	}

	/**
	 * Méthode abstraite qui simule l'attaque d'un personnage à redéfinir dans les
	 * classes enfants.
	 * 
	 * @param personnage objet Personnage
	 */
	public abstract void attaquer(Personnage personnage);

	public int get_pointDeVie() {
		return _pointDeVie;
	}

	public void set_pointDeVie(int pointDeVie) {
		this._pointDeVie = pointDeVie;
	}

	public int get_pointAction() {
		return _pointAction;
	}

	public void set_pointAction(int pointAction) {
		this._pointAction = pointAction;
	}

	public String get_prenom() {
		return _prenom;
	}

	public void set_prenom(String prenom) {
		this._prenom = prenom;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String nom) {
		this._nom = nom;
	}
}
