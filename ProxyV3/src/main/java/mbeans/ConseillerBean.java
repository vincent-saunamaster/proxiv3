package mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import metier.ConseillerClient;
import service.ConseillerClientService;
import service.IConseillerClientService;

//@Named
@ManagedBean(name="conseillerBean2")
@SessionScoped
public class ConseillerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Inject
	private IConseillerClientService service = new ConseillerClientService();

	// @Inject
	ConseillerClient conseiller = new ConseillerClient();

	public ConseillerClient getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerClient conseiller) {
		this.conseiller = conseiller;
	}

	public ConseillerBean() {
	}



}
