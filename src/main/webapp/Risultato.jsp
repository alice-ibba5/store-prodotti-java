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

	<div class="mt-4 ms-4">
		<h1>Il prodotto inserito è:</h1>
		<br> <span>Prodotto:</span> <b>${prodotto.getNome()}</b> <br>
		<span>Prezzo:</span> <b>${prodotto.getPrezzo()}</b> <br> <span>Quantità:</span>
		<b>${prodotto.getQuantita()}</b>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>