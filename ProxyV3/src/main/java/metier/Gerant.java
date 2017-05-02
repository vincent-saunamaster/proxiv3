package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Personne {

	@OneToMany(mappedBy = "gerant")
	Collection<Conseiller> conseillers = new ArrayList<Conseiller>();
	private String nomAgence;
	private String dateCreation;

	// ---------------------------------------------------------

	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	// ---------------------------------------------------------

	public Gerant() {
		super();
	}

}
