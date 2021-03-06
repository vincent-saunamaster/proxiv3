package metier;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
@ManagedBean
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
public class Compte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCompte")
	private int id;
	@ManyToOne(cascade=CascadeType.PERSIST)
	protected Client client;
	protected int numerocompte;
	protected int solde;
	protected int dateOuverture;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNumerocompte() {
		return numerocompte;
	}
	public void setNumerocompte(int numerocompte) {
		this.numerocompte = numerocompte;
	}
	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}
	public int getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(int dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	public void retirer(int somme) {
		this.solde = this.solde - somme;
	}

	public void ajouter(int somme) {
		this.solde = this.solde + somme;
	}
	
}