package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	public Collection<Client> listerClient() {
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
	public Collection<Client> findClientByMC(String mc) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q1 = em.createNamedQuery("Client.findByMC");
		q1.setParameter("etiquette1", "%" + mc + "%");
		q1.setParameter("etiquette2", "%" + mc + "%");
		Collection<Client> clients = (Collection<Client>) q1.getResultList();
		em.close();
		return clients;
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
	public ConseillerClient authentification(String login, String password) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ConseillerClient leCon;

		Query q1 = em.createNamedQuery("Conseiller.findByPWD");
		q1.setParameter("etiquette1", login);
		q1.setParameter("etiquette2", password);
		try {
			leCon = (ConseillerClient) q1.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			leCon = null;
		}
		tx.commit();
		em.close();
		return leCon;
	}

}
