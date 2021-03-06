package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IConseillerService {

	public Conseiller authentification(Conseiller cons);
	public void addClient(Client cl);
	public void majClient(Client cl);
	public void deleteClient(Client cl);
	public Collection<Client> listerClient();
	public Collection<Client> findClientByMC(String mc);
//	public void simulerCreditConsommation(int montant);
//	public void simulerCreditImmobilier(int montant);
	public String virement(Compte aDebiter, Compte aCrediter, int somme);

}