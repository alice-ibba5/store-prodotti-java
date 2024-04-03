package Prodotti;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Servlet implementation class stampa
 */
@WebServlet("/Stampa")
public class Stampa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stampa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		 
		String username = request.getParameter("username");
		String password1 = request.getParameter("password");
		
		String usernameGiusto = "alice.ibba5@gmail.com";
		String passwordGiusta = "1234";
			
		if (username.equalsIgnoreCase(usernameGiusto) && password1.equalsIgnoreCase(passwordGiusta)) {
		   
		   
		// Lista per memorizzare i prodotti
			// Informazioni di connessione al database MySQL
		    String url = "jdbc:mysql://localhost:3306/"; // URL del database
		    String dbName = "newdb"; // Nome del database
		    String user = "root"; // Nome utente
		    String password = "150988A?"; //
		    ArrayList<Prodotto> listaProdotti =  new ArrayList<>();
	        String selectQuery = "SELECT * FROM prodotti";
	        String query1 = "SELECT * FROM prodotti WHERE nome = (?)";
	        try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
		             Statement stmt = conn.createStatement();
		             ResultSet rs = stmt.executeQuery(selectQuery)) {

		            // Iterazione sui risultati e lettura dei dati
		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String nome = rs.getString("nome");
		                int prezzo = rs.getInt("prezzo");
		                int quantita = rs.getInt("quantita");
		                
		                // Creazione di un nuovo oggetto Prodotto e aggiunta alla lista
		                Prodotto prodotto = new Prodotto();
		                prodotto.setId(id);
		                prodotto.setNome(nome);
		                prodotto.setPrezzo(prezzo);
		                prodotto.setQuantita(quantita);
		                listaProdotti.add(prodotto);
		            }

		            // Stampa dei prodotti nella lista
		            

		        } catch (SQLException e) {
		            // Gestione delle eccezioni per la connessione al database o la lettura dei dati
		            System.out.println("Errore durante la lettura dei dati dalla tabella 'prodotti':");
		            e.printStackTrace();
		        }
	         request.setAttribute("lista", listaProdotti);
	        
	        // Inoltra la richiesta alla pagina JSP per l'elaborazione ulteriore	        
	        request.getRequestDispatcher("/Risultato1.jsp").forward(request, response);
	        
		} else {
			request.getRequestDispatcher("/LoginFallito.jsp").forward(request, response);
		}
	}

}