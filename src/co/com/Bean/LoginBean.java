package co.com.Bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.Dto.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private Usuario usuario;
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	private void init() {
		usuario=new Usuario();
	}
	
	public String iniciarSesion() {
		try {
			if("user".equals(usuario.getUser()) && "pass".equals(usuario.getPass())) {
				return "bienvenido";
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Usuario o pass incorrecto"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Usuario o pass incorrecto"));
		}
		return null;
	}

}
