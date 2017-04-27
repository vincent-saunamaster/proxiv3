package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.ConseillerClient;

public interface IConseillerClientService {

	public ConseillerClient authentification(String login , int password);
	public void addClient(Client cl);
	public void majClient(Client cl);
	public void deleteClient(Client cl);
	public Collection<Client> listerClient();
	public Collection<Client> findClientByMC(String mc);
//	public void simulerCreditConsommation(int montant);
//	public void simulerCreditImmobilier(int montant);
	public void virement(Compte crediteur, Compte debiteur, float somme);

}