package br.edu.ifpr.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpr.entity.Usuario;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Dados dados = (Dados) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("dados");
		List<Usuario> usuarios = dados.getUsuarios();
		
		Usuario retorno = null;
		
		
		
		for(Usuario user : usuarios) {
			if (user.getNome().equals(value)) {
				retorno = user;
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		if(valor != null) {
			return String.valueOf(((Usuario) valor).getNome()); 
		}else
			return null;
	}

}
