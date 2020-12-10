package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;
import br.com.acme.agenda.utils.Constantes;
import net.bytebuddy.asm.Advice.This;

/**
 * Servlet implementation class ContatoControllerServlet 
 * PRIMEIRA CAMADA
 */
@WebServlet("/contatoControllerServlet")
public class ContatoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Contato contato;
	private ContatoService service;
	private List<Contato> contatos;
	
	public ContatoControllerServlet() {
		this.service = new ContatoServiceImpl();
		this.contatos = new ArrayList<Contato>();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("action");
		String id = request.getParameter("id");
		
		if(id != null) {
			switch(acao) {
			case "ativoDesativo":
				if(id != null && this.service.buscarPorIdContato(Long.parseLong(id)).isAtivo()) {
					this.service.ativarDesativarContato(Long.parseLong(id));
					request.setAttribute("desativar_ativar", "Contato foi desativado com sucesso");
				}else if(id != null && !this.service.buscarPorIdContato(Long.parseLong(id)).isAtivo()) {
					this.service.ativarDesativarContato(Long.parseLong(id));
					request.setAttribute("desativar_ativar", "Contato foi ativado com sucesso");
				}
				break;
			case "deletar":
				this.service.remover(Long.parseLong(id));
				request.setAttribute("deletar", "Contato foi deletado com sucesso");
				break;
			
			case "editar":
				Contato contato = this.service.buscarPorIdContato(Long.parseLong(id));
				request.setAttribute("id", contato.getId());
				request.setAttribute("nome", contato.getNome());
				request.setAttribute("email", contato.getEmail());
				request.setAttribute("telefone", contato.getTelefone());
				RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
				rd.forward(request, response);
				doPost(request, response);
				break;
				
			case "visualizar":
				contato = this.service.buscarPorIdContato(Long.parseLong(id));
				request.setAttribute("id", contato.getId());
				request.setAttribute("nome", contato.getNome());
				request.setAttribute("email", contato.getEmail());
				request.setAttribute("telefone", contato.getTelefone());
				rd = request.getRequestDispatcher("visualizar.jsp");
				rd.forward(request, response);
				doPost(request, response);
				break;
			}
		}
		
		this.contatos = this.service.listarContatos();
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.LISTAR_CONTATOS);
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("action");
		
		switch(acao) {
		
		case "editarPost":
			String id = request.getParameter("id");
			Contato contato =  service.buscarPorIdContato(Long.parseLong(id));
			String editar_nome = request.getParameter("nome");
			String editar_email = request.getParameter("email");
			String editar_telefone = request.getParameter("telefone");
			
			
			contato.setNome(editar_nome);
			contato.setEmail(editar_email);
			contato.setTelefone(editar_telefone);
		
		
			this.service.editarContato(contato);	
			request.setAttribute("sucesso", "Contato " + editar_nome + " foi editado com sucesso");

		
			doGet(request, response);
			break;
			
		case "salvar":
			this.contato = new Contato();
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			
			this.contato.setNome(nome);
			this.contato.setEmail(email);
			this.contato.setTelefone(telefone);
			this.contato.isAtivo();
			
			if(!validEmail(email)) {
				
				this.service.salvar(this.contato);			
				
				request.setAttribute("sucesso", "Contato " + nome + " cadastrado com sucesso");
			}else {
				request.setAttribute("contatoExiste", "Contato com e-mail " + nome + " já existe");
			}
			
			doGet(request, response);
			break;
		}
		
		
	}
	
	
	
	private boolean validEmail(String email) {
		if(this.service.buscaPorEmail(email) != null) {
			return true;
		}else {
			return false;
		}
	}
	
}







