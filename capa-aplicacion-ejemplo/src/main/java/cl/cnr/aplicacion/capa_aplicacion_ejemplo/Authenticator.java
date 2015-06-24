package cl.cnr.aplicacion.capa_aplicacion_ejemplo;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Authenticator {

	@Inject
	private Logger log;
	
	@Inject
	private FacesContext facesContext;

	@Inject
	private Identity identity;

	public String authenticate() {
		log.info("authenticating " + identity.getUsername());
		// Escribir la lógica de autenticación aquí,
		// devuelve true si la autenticación se realizó
		// con éxito, false en caso contrario
		if ("admin".equals(identity.getUsername()) && "1234".equals(identity.getPassword()) ) {
			
			facesContext.addMessage(null, new FacesMessage("Bienvenido, has iniciado sesión como: "
					+ identity.getUsername()));
			return "loggedin";
		}
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login error: nombre usuario o password incorrecto", "Login error"));
		identity.clear();
		return "errorLoggedin";
	}

	public String logout() {
		identity.logout();
		facesContext.addMessage(null, new FacesMessage("Has cerrado sesión con éxito!"));
		return "logout";
	}
}
