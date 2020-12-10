package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.utils.JPAUtil;

public class LoginDaoImpl implements LoginDao{

	@Override
	public void salvar(Usuario usuario) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public boolean validarUsuario(String login, String senha) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query consulta = entityManager.createQuery("FROM Usuario WHERE login=:login and senha=:senha");
		consulta.setParameter("login", login);
		consulta.setParameter("senha", senha);
		
		List<Usuario> list = consulta.getResultList();
		
		if(list.size() == 0) {
			return false;
		}else {
			return true;
		}
		
		
	}
	

	
	
	
	
	



	

}
