package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Client;
import metier.ConseillerClient;

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxiV3-pu");

	@Override
	public void addClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
	}

	@Override
	public Collection<Client> listClients() {
		EntityManager em = emf.createEntityManager();
		Collection<Client> clients = em.createNamedQuery("Client.findAll").getResultList();
		em.close();
		return clients;
	}

	@Override
	public void deleteClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(c) ? c : em.merge(c));
		tx.commit();
		em.close();
	}

	@Override
	public Client findClientById(long idClient) {
		EntityManager em = emf.createEntityManager();
		Client client = em.find(Client.class, idClient);
		em.close();
		return client;
	}

	@Override
	public void majClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

	@Override
	public Collection<Client> listerClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConseillerClient authentification(String login, int password) {
		// TODO Auto-generated method stub
		return null;
	}

}
