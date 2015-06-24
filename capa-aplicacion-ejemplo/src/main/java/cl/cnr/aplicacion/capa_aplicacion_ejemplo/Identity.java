package cl.cnr.aplicacion.capa_aplicacion_ejemplo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Named
@SessionScoped
public class Identity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(min = 4, max = 16)
	@NotEmpty
	private String username;

	@Size(min = 4, max = 12)
	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void clear() {
		username = null;
		password = null;
	}

	public boolean isLoggedIn() {
		return getUsername() != null && password != null;
	}
	
    public void logout()
    {
    	if (isLoggedIn())
        {
    		clear();
        }
    }
}