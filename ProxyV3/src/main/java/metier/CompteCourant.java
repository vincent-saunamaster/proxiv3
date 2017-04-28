package metier;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("COMPTE_COURANT")
public class CompteCourant extends Compte {

	private int decouverteAutorise = 1000;

	public CompteCourant(int decouverteAutorise) {
		super();
		this.decouverteAutorise = decouverteAutorise;
	}

	public int getDecouverteAutorise() {
		return decouverteAutorise;
	}

	public void setDecouverteAutorise(int decouverteAutorise) {
		this.decouverteAutorise = decouverteAutorise;
	}

	@Override
	public int getSolde() {
		return super.getSolde() + decouverteAutorise;

	}

}