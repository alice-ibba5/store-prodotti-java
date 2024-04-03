<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.util.ArrayList"%>
<%@ page import = "Prodotti.Prodotto"%>
<%
ArrayList<Prodotto> lista= (ArrayList)request.getAttribute("listaProdotti");
String actionUrl = "Acquista";

if (lista == null){
	out.print("E' null");
}
else {
	out.print("<form action='" + actionUrl + "' method='post'>");
for (int i = 0; i < lista.size(); i++){
	out.print(lista.get(i).getId());
	out.print(" prodotto: ");
	out.print(lista.get(i).getNome());
	out.print(" prezzo: ");
	out.print(lista.get(i).getPrezzo());
	
	out.print("<input type='checkbox' id='" + lista.get(i).getId() +"' name='ordini' value='" + lista.get(i).getNome() + "'>");
	
	out.print("<hr>");
	
	
}
out.print("<input type='submit' value='Invia'>");
out.print("</form>");

}

%>
</body>
</html>