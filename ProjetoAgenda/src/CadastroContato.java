

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastroContato")
public class CadastroContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Contato contato;
	private List<Contato> contatos;
	
	public CadastroContato() {
		this.contato = new Contato(null, null, null, null, null);
		this.contatos = new ArrayList<>();
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String senha = request.getParameter("senha");
		
		if(identificarTelefone(telefone) != null || identificarEmail(email) != null) {
			request.setAttribute("Error", "Email ou telefone já cadastrado");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}else {
			this.contatos.add(new Contato(nome, email, telefone, endereco, senha));
			request.setAttribute("contatos", this.contatos);
			RequestDispatcher rd = request.getRequestDispatcher("listaContato.jsp");
			rd.forward(request, response);
		}
		
	}
	
	public Contato identificarTelefone(String telefone) {
		for(Contato contato : contatos) {
			if(telefone.equals(contato.getTelefone())) {
				return contato;
			}
		}
		return null;
	}
	
	public Contato identificarEmail(String email) {
		for(Contato contato : contatos) {
			if(email.equals(contato.getEmail())) {
				return contato;
			}
		}
		return null;
	}

}
