package mbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import metier.Client;
import metier.ConseillerClient;
import service.ConseillerClientService;
import service.IConseillerClientService;

//@Named
@ManagedBean(name = "userBean")
@SessionScoped
public class UserManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Inject
	private IConseillerClientService service = new ConseillerClientService();

	// @Inject

	private String login;
	private String password;
	private String searchUser;
	private Collection<Client> searchUsersResults;
	private Client selectedUser;
	ConseillerClient conseiller;

	public UserManagerBean() {
		conseiller = new ConseillerClient();
	}

	public ConseillerClient getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerClient conseiller) {
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

	public String logguer() {
		if (!this.getLogin().equalsIgnoreCase("") && !this.getPassword().equalsIgnoreCase("")) {
			this.conseiller.setLogin(this.getLogin());
			this.conseiller.setPassword(this.getPassword());
			if (service.authentification(conseiller) != null) {
				this.setConseiller(service.authentification(conseiller));
				return "accueilConseiller";
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

	public String searchAUser() {
		String motcle = (this.searchUser == null) ? "" : this.searchUser.trim();
		this.searchUsersResults = service.findClientByMC(motcle);
		System.out.println("Notre liste contient: " + searchUsersResults.size());
		return "accueilConseiller";
	}

	public String addUser() {
		service.addClient(this.selectedUser);
		return "accueilConseiller";
	}
	
	public String updateUser() {
		service.majClient(this.selectedUser);
		return "accueilConseiller";
	}

	public void rowSelect(SelectEvent event) {
		selectedUser = (Client) event.getObject();
		System.out.println("selectedUser = " + selectedUser.getId());
	}

	public void onUserSelect(SelectEvent event) {
		this.selectedUser = (Client) event.getObject();
		System.out.println("selectedUser = " + selectedUser.getId());
	}

	public void onUserUnselect(UnselectEvent event) {
		selectedUser = null;
	}

}
