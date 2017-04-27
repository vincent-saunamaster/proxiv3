package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Personne {

	@OneToMany(mappedBy = "gerant")
	Collection<ConseillerClient> conseillers = new ArrayList<ConseillerClient>();
	private String nomAgence;
	private String dateCreation;

	// ---------------------------------------------------------

	public Collection<ConseillerClient> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Collection<ConseillerClient> conseillers) {
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
