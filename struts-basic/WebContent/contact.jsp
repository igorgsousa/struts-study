<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de contato</title>
</head>
<body>
	<form action="contact.do" method="post">
	 	<div>
		 	Nome : <input type="text" name="contact.name"/>
		 	<div>
		 		<html:errors property="contact.name"/>
		 	</div>
	 	</div>
	 	<div>
	        Designacão : <input type="text" name="contact.designation" />
	        <div>
		 		<html:errors property="contact.designation"/>
		 	</div>
	 	</div>
        <input type="submit" value="Enviar" />
	</form>
</body>
</html>