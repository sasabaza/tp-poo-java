package fr.base.models;

/**
 * Classe qui définit le modèle Pouvoir
 * <br>- Attribut nom de la classe String
 * <br>- Attribut force de type entier
 * 
 * @author Stéphane Abaza
 *
 */
public class Pouvoir {

	private String _nom;
	private int _force;

	public Pouvoir(String nom, int force) {
		super();
		this._nom = nom;
		this._force = force;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String nom) {
		this._nom = nom;
	}

	public int get_force() {
		return _force;
	}

	public void set_force(int force) {
		this._force = force;
	}
}
