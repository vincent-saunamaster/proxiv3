package mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import metier.ConseillerClient;
import service.ConseillerClientService;
import service.IConseillerClientService;

//@Named
@ManagedBean
@SessionScoped
public class AuthentificationBean {

	//@Inject
	private IConseillerClientService service = new ConseillerClientService();

	private ConseillerClient conseiller = new ConseillerClient();

	public ConseillerClient getConseiller() {
		return conseiller;
	}

	public AuthentificationBean() {
	}

	public String authentification() {
		if (!conseiller.getLogin().equalsIgnoreCase("") && !conseiller.getPassword().equalsIgnoreCase("")) {
			conseiller = service.authentification(conseiller.getLogin(), conseiller.getPassword());
			if (conseiller != null) {
				return "accueilConseiller";
			} else {
				conseiller = new ConseillerClient();
				return "index";
			}
		} else {
			return "index";
		}

	}

}
