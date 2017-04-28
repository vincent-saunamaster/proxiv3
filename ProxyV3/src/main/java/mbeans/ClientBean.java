package mbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import metier.Client;
import service.ConseillerClientService;
import service.IConseillerClientService;

@ManagedBean
// @Named
@ViewScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Inject
	private IConseillerClientService service = new ConseillerClientService();

	// placeholder
	private Client client = new Client();

	private ConseillerBean auth;

	private boolean editMode;

	public ConseillerBean getAuth() {
		return auth;
	}

	public void setAuth(ConseillerBean auth) {
		this.auth = auth;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// public IConseillerClientService getServices() {
	// return service;
	// }
	//
	// public void setServices(IConseillerClientService services) {
	// this.service = services;
	// }

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	

	public ClientBean() {
		this.setEditMode(false);
	}

	public void add() {
		if (!client.getNom().equalsIgnoreCase("") && !client.getPrenom().equalsIgnoreCase("")) {
			if (editMode == false) {
				
				client.setConseiller(auth.getConseiller());

				service.addClient(client);
			} else {
				service.majClient(client);
				editMode = false;
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les valeurs non nulles", null));
		}
		client = new Client();
		//return "accueilConseiller";
	}

	// public Collection<Client> list() {
	//
	// return auth.getConseiller().getClient();
	//
	// // return service.listerClient();
	// }

	public void delete() {
		service.deleteClient(client);
		client = new Client();
	}

	public void maj() {
		this.editMode = true;
	}
}