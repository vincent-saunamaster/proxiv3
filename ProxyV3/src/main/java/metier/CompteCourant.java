package metier;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@ManagedBean
@Entity
@DiscriminatorValue("COMPTE_COURANT")
public class CompteCourant extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String typeCompte = "courant";
	private int decouverteAutorise = 1000;

	public CompteCourant() {
		super();
	}

	public CompteCourant(int decouverteAutorise) {
		super();
		this.decouverteAutorise = decouverteAutorise;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public int getDecouverteAutorise() {
		return decouverteAutorise;
	}

	public void setDecouverteAutorise(int decouverteAutorise) {
		this.decouverteAutorise = decouverteAutorise;
	}

	@Override
	public int getSolde() {
		return this.solde + this.decouverteAutorise;
	}

	public void retirer(int somme) {
		this.solde = this.solde - somme;
	}

	public void ajouter(int somme) {
		this.solde = this.solde + somme;
	}

}