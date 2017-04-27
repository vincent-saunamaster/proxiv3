package mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import metier.ConseillerClient;
import service.ConseillerClientService;
import service.IConseillerClientService;

//@Named
@ManagedBean
@SessionScoped
public class AuthentificationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Inject
	private IConseillerClientService service = new ConseillerClientService();

	// @Inject
	ConseillerClient conseiller;

	public ConseillerClient getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerClient conseiller) {
		this.conseiller = conseiller;
	}

	public AuthentificationBean() {
		// @Inject
		this.setConseiller(new ConseillerClient());
	}

	public String authentification() {
		if (!conseiller.getLogin().equalsIgnoreCase("") && !conseiller.getPassword().equalsIgnoreCase("")) {

			/**
			 * contrôle authentification par session
			 */
			// si pas de session, on en initialise une toute neuve avec trois
			// attributs
			// HttpServletRequest request = (HttpServletRequest)
			// FacesContext.getCurrentInstance().getExternalContext()
			// .getRequest();
			// HttpSession session = request.getSession(false);
			// if (session == null || session.getAttribute("login") == null ||
			// session.getAttribute("password") == null
			// || session.getAttribute("attemptsCount") == null) {
			// session = request.getSession();
			// session.setAttribute("login", "");
			// session.setAttribute("password", "");
			// session.setAttribute("attemptsCount", 0);
			// }

			this.setConseiller(service.authentification(conseiller));

			if (this.getConseiller().getId() != 0) {

				// session.setAttribute("login", conseiller.getLogin());
				// session.setAttribute("password", conseiller.getPassword());
				// session.setAttribute("attemptsCount", 0);

				return "accueilConseiller";
			} else {

				// on augmente le compteur de fail
				// session.setAttribute("attemptsCount", ((int)
				// session.getAttribute("attemptsCount")) + 1);

				conseiller = new ConseillerClient();
				return "index";
			}

		} else {
			conseiller = new ConseillerClient();
			return "index";

		}

	}

}
