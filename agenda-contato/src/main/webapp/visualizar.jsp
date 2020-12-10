<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template title="Contatos" breadcrumb="Dashboard">

	<jsp:attribute name="content">
		
     	<div class="row">
          <div class="col-lg-12">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Visualizar Contato</h1>
              </div>
              <form class="user" action="${pageContext.request.contextPath}/contatoControllerServlet" method="get">
                <input type="hidden" value= "${id}">
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nome" 
                    	value= "${nome}" readonly="readonly" name="nome">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                  	<input type="email" class="form-control form-control-user" id="email" 
                  		 value= "${email}" readonly="readonly" name="email">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="telefone" 
                    	value= "${telefone}" readonly="readonly" name="telefone">
                  </div>
                </div>
                <div align="center">
                    
                    <input type="submit" class="btn btn-warning" value="Voltar" />
                    
                </div>
              </form>
                
            </div>
          </div>
        </div>
					
	</jsp:attribute>

</mt:admin_template>