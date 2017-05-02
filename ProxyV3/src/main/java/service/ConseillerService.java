package service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IDao;
import metier.Client;
import metier.Compte;
import metier.Conseiller;

@Named
public class ConseillerService implements IConseillerService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDao idao; // = new Dao();

	@Override
	public Conseiller authentification(Conseiller cons) {
		return idao.authentification(cons);
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
	public Collection<Client> listerClient() {
		return idao.listerClient();
		// TODO Auto-generated method stub

	}

	// @Override
	// public void simulerCreditConsommation(int montant) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void simulerCreditImmobilier(int montant) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public String virement(Compte aDebiter, Compte aCrediter, int somme) {
		String message = "";
		if (somme <= 0) {
			message = "montant demandé incorrect";
		} else {
			if (aDebiter.getSolde() < somme) {
				message = "Montant demandé supérieur au solde du compte à débiter";
			} else {
				if (aDebiter.equals(aCrediter)) {
					message = "Compte à créditer et à débiter identique";
				} else {
					idao.virement(aDebiter, aCrediter, somme);
				}

			}
		}
		return message;

	}

	@Override
	public Collection<Client> findClientByMC(String mc) {
		// TODO Auto-generated method stub
		return idao.findClientByMC(mc);
	}

}