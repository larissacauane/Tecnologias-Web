<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:admin_template title="Contatos" breadcrumb="Dashboard">


	
	<jsp:attribute name="content">
		
		<section class="content">
	
	     <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Lista de Contatos</h6>
		     <div style="margin-left: 180px; margin-top: -30px;">
		     	<a class="btn btn-primary" href="${pageContext.request.contextPath}/pages/cadastros/contatos/cadastro_contatos.jsp">Novo</a>
		     </div>
            </div>
           
			  <c:if test="${not empty sucesso}">
	            <div class="alert alert-success" role="alert">${sucesso}</div>
			  </c:if>
			  
			   <c:if test="${not empty contatoExiste}">
	            <div class="alert alert-danger" role="alert">${contatoExiste}</div>
			  </c:if>
            
            <div class="card-body">
              <div class="table-responsive">
                <c:if test="${not empty desativar_ativar}">
                	<div class="alert alert-success" role="alert">${desativar_ativar}</div>
                </c:if>
                
                <c:if test="${not empty deletar }"> 
                	<div class="alert alert-sucess" role="alert">${deletar }</div>
                </c:if>
                
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Nome</th>
                      <th>E-mail</th>
                      <th>Telefone</th>
                      <th>Status</th>
                      <th>Ativar/Desativar</th>
                      <th>Deletar</th>
                      <th>Editar</th>
                      <th>Visualizar</th>
                    </tr>
                  </thead>
                  
                 
                  <tbody>
                    <c:forEach var="c" items="${contatos}">
			            <input type="hidden" value="${c.id}">
                    	<tr>			                  
	                    	<td>
	                    	  <c:out value="${c.nome}"/>	
	                    	</td>
	                    	<td>
	                    	  <c:out value="${c.email}"/>	
	                    	</td>
	                    	<td>
	                    	  <c:out value="${c.telefone}"/>	
	                    	</td>
	                    	<td>
	                    	  <c:out value="${c.ativo ? 'Ativo' : 'Inativo' }"/>
	                    	</td>
	                    	<td>
	                    	     <a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=ativoDesativo" class=" ${c.ativo ? 'btn btn-danger' : 'btn btn-success' }">${c.ativo ? 'Desativar' : 'Ativar' }</a>
	                    	     
	                    	</td>
	                    	<td>
	                    		<a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=deletar" class=" btn btn-dark">Deletar</a>
	                    	</td>
	                    	<td>
	                    		<a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=editar" class=" btn btn-primary">Editar</a>
	                    	</td>
	                    	<td>
	                    		<a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=visualizar" class=" btn btn-warning">Visualizar</a>
	                    	</td>
                    	</tr>
                    	
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
     	
     </section>
					
	</jsp:attribute>
	
</mt:admin_template>
