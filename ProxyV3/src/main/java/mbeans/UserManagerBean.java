package mbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import metier.Client;
import metier.Compte;
import metier.Conseiller;
import service.IConseillerService;

@Named(value="userBean")
@SessionScoped
public class UserManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IConseillerService service; // = new ConseillerService();

	private String login;
	private String password;
	private String searchUser;
	private Collection<Client> searchUsersResults;
	private Client selectedUser;

	private Conseiller conseiller;

	private Compte compte;

	private Compte aCrediter;
	private Compte aDebiter;
	private int somme;

	private String currentView = "";

	// constructeur
	public UserManagerBean() {
		conseiller = new Conseiller();
	}

	// getters/setters
	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}

	public String getCurrentView() {
		if (this.currentView.equals("")) {
			this.currentView = "acceuilConseiller";
		}
		return currentView;
	}

	public void setCurrentView(String currentView) {
		this.currentView = currentView;
	}

	public Compte getACrediter() {
		return aCrediter;
	}

	public void setACrediter(Compte aCrediter) {
		this.aCrediter = aCrediter;
	}

	public Compte getADebiter() {
		return aDebiter;
	}

	public void setADebiter(Compte aDebiter) {
		this.aDebiter = aDebiter;
	}

	public Compte getCompte() {
		if (compte == null) {
			compte = new Compte();
		}
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getSelectedUser() {
		if (selectedUser == null) {
			selectedUser = new Client();
		}
		return selectedUser;
	}

	public void setSelectedUser(Client selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Collection<Client> getSearchUsersResults() {
		return searchUsersResults;
	}

	public void setSearchUsersResults(Collection<Client> searchUsersResults) {
		this.searchUsersResults = searchUsersResults;
	}

	public String getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}

	/**
	 * méthode qui vérifie le login/pwd en BDD et remplit le conseiller local
	 * des infos trouvés en BDD
	 * 
	 * @return String vue
	 */
	public String logguer() {
		if (!this.getLogin().equalsIgnoreCase("") && !this.getPassword().equalsIgnoreCase("")) {
			this.conseiller.setLogin(this.getLogin());
			this.conseiller.setPassword(this.getPassword());
			if (service.authentification(conseiller) != null) {
				this.setConseiller(service.authentification(conseiller));
				return "accueilConseiller?faces-redirect=true";
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("login", new FacesMessage("Identifiants invalides"));
				return "index";
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("login", new FacesMessage("Identifiants invalides"));
			return "index";
		}
	}

	/**
	 * méthode qui recherche un client à l'aide de mot clé
	 * 
	 * @return String vue
	 */
	public String searchAUser() {
		String motcle = (this.searchUser == null) ? "" : this.searchUser.trim();
		this.searchUsersResults = service.findClientByMC(motcle);
		// System.out.println("Notre liste contient: " +
		// searchUsersResults.size());
		return getCurrentView();
	}

	/**
	 * méthode qui ajoute un utilisateur en BDD
	 * 
	 * @return String vue
	 */
	public String addUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.selectedUser.getNom().equalsIgnoreCase("") && !this.selectedUser.getPrenom().equalsIgnoreCase("")) {
			this.selectedUser.setConseiller(this.conseiller);
			service.addClient(this.selectedUser);
			context.addMessage("update", new FacesMessage("client ajouté"));
		} else {
			context.addMessage("update", new FacesMessage("informations invalides"));
		}

		return searchAUser();
	}

	/**
	 * méthode qui met à jour un client en BDD
	 * 
	 * @return String vue
	 */
	public String updateUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.selectedUser.getNom().equalsIgnoreCase("") && !this.selectedUser.getPrenom().equalsIgnoreCase("")) {
			service.majClient(this.selectedUser);
			context.addMessage("update", new FacesMessage("client modifié"));
		} else {
			context.addMessage("update", new FacesMessage("informations invalides"));
		}
		searchAUser();
		return searchAUser();
	}

	/**
	 * méthode qui supprime un client en BDD
	 * 
	 * @return String vue
	 */
	public String removeUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		service.deleteClient(this.selectedUser);
		context.addMessage("update", new FacesMessage("client supprimé"));
		return searchAUser();
	}

	/**
	 * méthode qui sélectionne l'objet client de la ligne sélectionnée
	 * 
	 * @param event
	 *            l'évènement
	 */
	public void rowSelect(SelectEvent event) {
		selectedUser = (Client) event.getObject();
		// System.out.println("selectedUser = " + selectedUser.getId());
	}

	/**
	 * méthode qui sélectionne l'objet client
	 * 
	 * @param event
	 *            l'évènement
	 */
	public void onUserSelect(SelectEvent event) {
		this.selectedUser = (Client) event.getObject();
		// System.out.println("selectedUser = " + selectedUser.getId());
	}

	/**
	 * méthode qui déselectionne l'objet client
	 * 
	 * @param event
	 *            l'évènement
	 */
	public void onUserUnselect(UnselectEvent event) {
		selectedUser = null;
	}

	/**
	 * méthode qui tue la session
	 * 
	 * @return String vue
	 */
	public String deloggue() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
		return "index?faces-redirect=true";
	}

	public String virement() {
		FacesContext context = FacesContext.getCurrentInstance();
		String message = "";
		if (this.aDebiter != null && this.aCrediter != null) {
			message = service.virement(this.aDebiter, this.aCrediter, this.somme);
			if (message.equals("")) {
				context.addMessage("virement", new FacesMessage("virement effectué"));
			} else {
				context.addMessage("virement", new FacesMessage(message));
				return "virement";
			}
		} else {
			message = "Aucun compte choisi";
			context.addMessage("virement", new FacesMessage(message));
			return "virement";
		}
		return "accueilConseiller";
	}

}
