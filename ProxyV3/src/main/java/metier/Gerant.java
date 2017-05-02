package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@ManagedBean
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
