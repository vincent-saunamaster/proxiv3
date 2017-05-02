package metier;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@ManagedBean
@Entity
@DiscriminatorValue("COMPTE_EPARGNE")
public class CompteEpargne extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String typeCompte = "épargne"; 
	private int tauxRemuneration = 3;

	public CompteEpargne() {
		super();
	}
	public String getTypeCompte() {
		return typeCompte;
	}

	public int getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(int tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	public CompteEpargne(int tauxRemuneration) {
		super();
		this.tauxRemuneration = tauxRemuneration;
	}
	
	@Override
	public void retirer(int somme) {
		this.solde = this.solde - somme;
	}

	public void ajouter(int somme) {
		this.solde = this.solde + somme;
	}

}