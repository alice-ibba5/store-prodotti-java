<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Eliminazione Prodotto</title>
</head>
<body>

	<h1>Elimina un Prodotto</h1>

<%@ page import = "java.io.IOException" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

	<%
	
	// Connessione al database e recupero dei prodotti
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "newdb";
	String user = "root";
	String password = "150988A?";

	try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM prodotti")) {
	%>

	<form action="Remove" method="post">
    <ul>
        <%
        while (rs.next()) {
            String prodottoID = rs.getString("id");
            String prodottoNome = rs.getString("nome");
            int prodottoPrezzo = rs.getInt("prezzo");
            
            System.out.println(prodottoNome);
        
        out.print(prodottoID);
        out.print(prodottoNome);
        out.print(prodottoPrezzo);
        out.print("<input type='checkbox' id='ordini' name='elementoLista' value='" + rs.getString("nome") + "'>");
        
        }
        %>
    </ul>
    <input type="submit" value="Elimina">
	</form>

	<%
	} catch (SQLException e) {
	e.printStackTrace();
	}
	%>

</body>
</html>