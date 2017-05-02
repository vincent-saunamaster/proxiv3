package dao;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IDao {

	public void addClient(Client c);
	public void deleteClient(Client c);
	public void majClient(Client cl);
	public Collection<Client> listerClient();
	public Collection<Client> findClientByMC(String mc);
	public Conseiller authentification(Conseiller cons);
	public String virement(Compte aDebiter, Compte aCrediter, int somme);
}
