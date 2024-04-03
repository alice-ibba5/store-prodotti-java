package Prodotti;

import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Prodotti")
public class Prodotti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Prodotto p1 = new Prodotto();
		String nome = request.getParameter("name");
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		p1.setNome(nome);
		p1.setPrezzo(prezzo);
		p1.setQuantita(quantita);
		request.setAttribute("prodotto", p1);

		// creiamo l'oggetto context in cui andremo a salvare la lista degli utenti
		ServletContext context = getServletContext();
		// assegnmo a lista l'elemento preso dal context con nome lista
		ArrayList <Prodotto> lista  = (ArrayList<Prodotto>) context.getAttribute("lista");
		// se lista è null creiamo un nuovo arraylist
		if (lista == null) {

			lista = new ArrayList<>();
		}
		// aggiungiamo lo user alla lista
		lista.add(p1);

		// Memorizza l'ArrayList nell'oggetto ServletContext
		context.setAttribute("lista", lista);

		// Passa l'oggetto datiModulo alla JSP per l'elaborazione successiva
		request.setAttribute("datiModulo", p1);

		String insertQuery1 = "INSERT INTO prodotti (nome, prezzo, quantita) VALUES (?, ?, ?)";
		// Informazioni di connessione al database MySQL
		String url = "jdbc:mysql://localhost:3306/"; // URL del database
		String dbName = "newdb"; // Nome del database
		String user = "root"; // Nome utente
		String password = "150988A?"; 
		try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
				PreparedStatement stmt = conn.prepareStatement(insertQuery1))


		{
			stmt.setString(1, nome);
			stmt.setInt(2, prezzo);
			stmt.setInt(3, quantita);



			// Esecuzione della query per l'inserimento dei dati
			int rowsAffected = stmt.executeUpdate();

			// Stampa il numero di righe aggiornate
			System.out.println("Numero di righe aggiornate: " + rowsAffected);

		} catch (SQLException e) {
			// Gestione dell'eccezione per la connessione al database o l'esecuzione della query
			System.out.println("Errore durante l'inserimento dei dati nella tabella 'prodotti':");
			e.printStackTrace();
		}


		// Inoltra la richiesta alla pagina JSP per l'elaborazione ulteriore
		request.getRequestDispatcher("/Risultato.jsp").forward(request, response);


	}

}
