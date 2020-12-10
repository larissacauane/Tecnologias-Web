package br.com.acme.agenda.service;

import br.com.acme.agenda.model.Usuario;

public interface LoginService {
	
	public void salvar(Usuario usuario);
	
	public boolean validarUsuario(String login, String senha);
	
	
	

}
