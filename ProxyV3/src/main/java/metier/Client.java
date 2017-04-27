package metier;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
@DiscriminatorValue("CLIENT")
public class Client extends Personne {

	@ManyToOne(cascade=CascadeType.PERSIST)
	private ConseillerClient conseiller;
	private String typeClient;

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	
	public ConseillerClient getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerClient conseiller) {
		this.conseiller = conseiller;
	}

	@Override
	public String toString() {
		return "Client [typeClient=" + typeClient + "]";
	}

}
