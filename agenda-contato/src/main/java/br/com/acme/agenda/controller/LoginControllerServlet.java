package br.com.acme.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.LoginService;
import br.com.acme.agenda.service.LoginServiceImpl;
import br.com.acme.agenda.utils.Constantes;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Usuario usuario;
	public LoginService service;
	
	public LoginControllerServlet() {
		this.service = new LoginServiceImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			boolean validar = this.service.validarUsuario(login, senha);
			
			if(validar) {
				response.sendRedirect("index.jsp");
			}else {
				session.setAttribute("erro", "Login ou senha inválidos");
				response.sendRedirect("login.jsp");
			}
			
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	
	}
	
	
	
	

}
