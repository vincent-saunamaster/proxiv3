package metier;

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

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte {
	
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
	
}