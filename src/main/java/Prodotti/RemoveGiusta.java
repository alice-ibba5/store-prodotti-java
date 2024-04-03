package Prodotti;

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

@WebServlet("/remove")
public class RemoveGiusta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveGiusta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod = request.getParameter("prodotto");
		String insertQuery1 = "DELETE FROM prodotti WHERE nome=(?);";
		 String url = "jdbc:mysql://localhost:3306/"; // URL del database
		    String dbName = "newdb"; // Nome del database
		    String user = "root"; // Nome utente
		    String password = "150988A?"; 
		    
		    try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
	        		PreparedStatement stmt = conn.prepareStatement(insertQuery1))
	        		
	        		
	        		{
	        	stmt.setString(1, prod);
	        	
	        	
	        	
	        	
	            // Esecuzione della query per l'inserimento dei dati
	            int rowsAffected = stmt.executeUpdate();

	            // Stampa il numero di righe aggiornate
	            System.out.println("Numero di righe aggiornate: " + rowsAffected);

	        } catch (SQLException e) {
	            // Gestione dell'eccezione per la connessione al database o l'esecuzione della query
	            System.out.println("Errore durante la cancellazione dei dati dalla tabella 'prodotti':");
	            e.printStackTrace();
	        }
		    
		    response.getWriter().println(prod + " eliminato con successo!");
		    
		
	}

}