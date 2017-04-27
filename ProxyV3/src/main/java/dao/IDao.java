package dao;

import java.util.Collection;

import metier.Client;
import metier.ConseillerClient;

public interface IDao {

	public void addClient(Client c);
	public void deleteClient(Client c);
	public void majClient(Client cl);
	public Collection<Client> listerClient();
	public Collection<Client> findClientByMC(String mc);
	public ConseillerClient authentification(String login, String password);
}
