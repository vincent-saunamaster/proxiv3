package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@ManagedBean
@Entity
@NamedQuery(name = "Conseiller.findByPWD", query = "SELECT c FROM Conseiller c where c.login=:etiquette1 AND c.password=:etiquette2")
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Gerant gerant;

	@OneToMany(mappedBy = "conseiller", fetch=FetchType.EAGER)
	private Collection<Client> client = new ArrayList<Client>();
	private String login;
	private String password;

	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, String adresse, String codePostale, String ville,
			String telephone) {
		super(nom, prenom, adresse, codePostale, ville, telephone);
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Collection<Client> getClient() {
		return client;
	}

	public void setClient(Collection<Client> client) {
		this.client = client;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}