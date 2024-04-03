<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.util.ArrayList"%>
<%@ page import = "Prodotti.Prodotto"%>
<%@ page import = "Prodotti.Acquista" %>
<%
String[] lista = (String[])request.getAttribute("lista");


out.print("<h1>Hai acquistato:</h1>");
out.print("<br>");
for (String prod: lista){
	out.print(prod);
	out.print("<hr>");
}
out.print("Hai speso: ");
%>
<p>${somma} Euro</p>

</body>
</html>