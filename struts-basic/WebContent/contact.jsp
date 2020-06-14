<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de contato</title>
<link href="${pageContext.request.contextPath}/public/css/app.css" rel="stylesheet" type="text/css">

</head>
<body>
	<html:form action="contact.do" method="post">
	 	<div class="fieldset">
		 	Nome : <html:text property="contact.name"/>
		 	<div class="form-error">
		 		<html:errors property="contact.name"/>
		 	</div>
	 	</div>
	 	<div class="fieldset">
	        Designacão : <html:text property="contact.designation"/>
	       <div class="form-error">
		 		<html:errors property="contact.designation"/>
		 	</div>
	 	</div>
        <input class="submit-btn" type="submit" value="Enviar" />
	</html:form>
</body>
</html>