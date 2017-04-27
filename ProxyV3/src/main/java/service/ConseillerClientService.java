package service;

import java.util.Collection;

import javax.inject.Inject;

import dao.IDao;
import metier.Client;
import metier.Compte;
import metier.ConseillerClient;

public class ConseillerClientService implements IConseillerClientService {
	
	@Inject
	private IDao idao;

	@Override
	public ConseillerClient authentification(String login, int password) {
		return idao.authentification(login,password);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClient(Client cl) {
		// TODO Auto-generated method stub
		idao.addClient(cl);
		
	}

	@Override
	public void majClient(Client cl) {
		// TODO Auto-generated method stub
		idao.majClient(cl);
		
	}

	@Override
	public void deleteClient(Client c) {
		// TODO Auto-generated method stub
		idao.deleteClient(c);
	}

	@Override
	public void infoClient(int idclient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Client> listerClient() {
		return idao.listerClient();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simulerCreditConsommation(int montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simulerCreditImmobilier(int montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void virement(Compte crediteur, Compte debiteur, float somme) {
		// TODO Auto-generated method stub
		
	}

}