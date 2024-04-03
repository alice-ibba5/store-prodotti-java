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
	flex-direction: column;
	align-content: space-around;
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

#buttonTornaIndietro, #buttonElimina {
	background-color: #F9F7F4;
	border-radius: 10px;
}
</style>
</head>
<body>

	<div class="d-flex justify-content-around">
		<div>
			<h1 class="mt-4">Inserisci un prodotto:</h1>
			<form action="Prodotti" method="post">
				<label for="name">Inserisci il nome del prodotto:</label> <br>
				<input type="text" id="name" name="name"><br> <label
					for="prezzo">Inserisci il prezzo:</label> <br> <input
					type="text" id="prezzo" name="prezzo"><br> <label
					for="quantita">Inserisci la quantità:</label> <br> <input
					type="text" id="quantita" name="quantita"><br> <input
					type="submit" value="Aggiungi" id="buttonAggiungi">
			</form>
		</div>

		<div id="contenitoreFlex">
			<div id="cont">
				<h1 class="mt-4">Elimina uno o più prodotti:</h1>
				<form action="EliminaProdotto">
					<input type="submit" value="Elimina" id="buttonElimina">
				</form>
			</div>


		</div>

	</div>

	<div class="d-flex justify-content-center">
		<a href="index.html">
			<button id="buttonTornaIndietro">Torna indietro</button>
		</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>