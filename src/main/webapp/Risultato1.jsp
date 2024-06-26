<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Ojuju:wght@200..800&display=swap"
	rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<style>

@font-face {
	font-family: 'Bebas Neue';
	src: url('src/main/webapp/fonts/BebasNeue-Regular.ttf')
		format('truetype');
}

@font-face {
	font-family: 'Ojuju';
	src: url('src/main/webapp/fonts/Ojuju-VariableFont_wght.ttf')
		format('truetype');
}

body {
	background-color: #EEFCFF;
	display: flex;
	justify-content: space-around;
	font-family: 'Bebas Neue';
}

#contenitore {
	display: flex;
	flex-direction: column;
}

#contenitoreFlex {
	display: flex;
	flex-direction: column;
	align-items: space-between
}

#cont {
	display: flex;
	flex-direction: column;
	align-items: center;
}

#cont2 {
	display: flex;
	flex-direction: column;
	align-items: center;
}

#buttonAggiungi {
margin-left: 50px;
margin-top: 10px;
background-color: #F9F7F4;
border-radius: 10px;
}

#buttonAcquista, #buttonElimina {
background-color: #F9F7F4;
border-radius: 10px;
}

</style>
</head>
<body>
	<div>
		<h1 class="mt-4">I prodotti presenti sono:</h1>
		<div id="contenitore">
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="Prodotti.Prodotto"%>
			<%
			ArrayList<Prodotto> lista= (ArrayList)request.getAttribute("lista");
			String actionUrl = "Acquista";


			if (lista == null) {
				out.print("E' null");
			} else {
				out.print("<form action='" + actionUrl + "' method='post'>");
				for (int i = 0; i < lista.size(); i++) {

					out.print("<div id='elemento'>");
					out.print("<input type='checkbox' id='" + lista.get(i).getId() + "' name='ordini' value='"
					+ lista.get(i).getNome() + "'>");
					out.print("ID: " + lista.get(i).getId());
					out.print("<br>");
					out.print("Prodotto: " + "<b>" + lista.get(i).getNome() + "</b>");
					out.print("<br>");
					out.print("Prezzo: " + lista.get(i).getPrezzo() + " euro");
					out.print("<br>");
					out.print("Disponibilità: " + lista.get(i).getQuantita());
					out.print("</div>");

				}
				out.print("<input type='submit' value='Acquista' id='button'>");
				out.print("</form>");

			}
			%>
		</div>
	</div>

	
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>