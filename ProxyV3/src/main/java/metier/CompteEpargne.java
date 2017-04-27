package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COMPTE_EPARGNE")
public class CompteEpargne extends Compte {

	public CompteEpargne() {
		super();
	}

	private int tauxRemuneration = 3;

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

}