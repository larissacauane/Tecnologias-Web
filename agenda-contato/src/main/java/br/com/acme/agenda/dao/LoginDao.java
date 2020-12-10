package br.com.acme.agenda.dao;

import br.com.acme.agenda.model.Usuario;

public interface LoginDao {
	
	public void salvar(Usuario usuario);
	
	public boolean validarUsuario(String login, String senha);
	
	
	
	
	
	
}
