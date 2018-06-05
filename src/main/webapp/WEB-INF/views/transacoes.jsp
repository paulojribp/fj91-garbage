<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:template title="Transações">
	<jsp:body>
		<form action="<c:url value="/transacoes"/>" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="arquivo">Arquivo</label>
				<input id="arquivo" name="arquivo" type="file" class="form-control">
			</div>
			
			<button class="btn btn-large btn-primary">Enviar</button>
		</form>
		
		<c:if test="${not empty qtdTransacoes}">
			<div class="alert alert-info">
				<p class="text-center">Transações processadas: ${qtdTransacoes}</p>
			</div>
		</c:if>
	</jsp:body>
</custom:template>
