package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@ManagedBean
@Entity
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
		@NamedQuery(name = "Client.findByMC", query = "SELECT c FROM Client c where c.nom LIKE :etiquette1 OR c.prenom LIKE :etiquette2") })
@DiscriminatorValue("CLIENT")
public class Client extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Conseiller conseiller;
	private String typeClient;
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Collection<Compte> comptes = new ArrayList<Compte>();

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "Client [typeClient=" + typeClient + "]";
	}

}
