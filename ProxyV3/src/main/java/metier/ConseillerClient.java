package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("CONSEILLER")
public class ConseillerClient extends Personne {
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Gerant gerant; 
	
	@OneToMany(mappedBy = "conseiller")
	private List<Client> client = new ArrayList<Client>();
	private int idclient;
	private String login;
	private String password;
	
	
	
	public ConseillerClient() {
		super();
	}

	public ConseillerClient(String nom, String prenom, String adresse, String codePostale, String ville,
			String telephone) {
		super(nom, prenom, adresse, codePostale, ville, telephone);
	}
	
	public Gerant getGerant() {
		return gerant;
	}
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	public List<Client> getClient() {
		return client;
	}
	public void setClient(List<Client> client) {
		this.client = client;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
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