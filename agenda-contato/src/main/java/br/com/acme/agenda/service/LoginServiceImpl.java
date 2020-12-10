package br.com.acme.agenda.service;

import br.com.acme.agenda.dao.LoginDao;
import br.com.acme.agenda.dao.LoginDaoImpl;
import br.com.acme.agenda.model.Usuario;

public class LoginServiceImpl implements LoginService{
	
	private LoginDao login;
	
	public LoginServiceImpl() {
		this.login = new LoginDaoImpl();
	}

	@Override
	public void salvar(Usuario usuario) {
		this.login.salvar(usuario);
	}

	@Override
	public boolean validarUsuario(String login, String senha) {
		return this.login.validarUsuario(login, senha);
	}

	

	
	
	

}
