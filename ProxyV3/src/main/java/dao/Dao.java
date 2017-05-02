package dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxiV3-pu");

	@Override
	public void addClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.merge(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tx.commit();
		em.close();
	}

	@Override
	public Collection<Client> listerClient() {
		EntityManager em = emf.createEntityManager();
		Collection<Client> clients = new ArrayList<Client>();
		try {
			clients = em.createNamedQuery("Client.findAll").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		Collection<Client> clients = new ArrayList<Client>();
		try {
			clients = (Collection<Client>) q1.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
		return clients;
	}

	@Override
	public void majClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.merge(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tx.commit();
		em.close();
	}

	@Override
	public Conseiller authentification(Conseiller cons) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Conseiller leCons = null;
		Query q1 = em.createNamedQuery("Conseiller.findByPWD");
		q1.setParameter("etiquette1", cons.getLogin());
		q1.setParameter("etiquette2", cons.getPassword());
		try {
			leCons = (Conseiller) q1.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tx.commit();
		em.close();
		return leCons;
	}

	@Override
	public String virement(Compte aDebiter, Compte aCrediter, int somme) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		aDebiter.retirer(somme);
		aCrediter.ajouter(somme);
		em.merge(aDebiter);
		em.merge(aCrediter);
		tx.commit();
		em.close();
		return "";

	}

}
