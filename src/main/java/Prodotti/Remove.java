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

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
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
			  	String[] prodottiDaEliminare = request.getParameterValues("ordini");
				
				String insertQuery1 = "DELETE FROM prodotti WHERE nome=(?);";
				 String url = "jdbc:mysql://localhost:3306/"; // URL del database
				    String dbName = "newdb"; // Nome del database
				    String user = "root"; // Nome utente
				    String password = "150988A?"; 
				    
				    System.out.println(prodottiDaEliminare);
				    
				    if (prodottiDaEliminare != null) {
					    for (String prodotto : prodottiDaEliminare) {
				    
				    try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
			        		PreparedStatement stmt = conn.prepareStatement(insertQuery1))
			        		
			        		
			        		{
			        	stmt.setString(1, prodotto);
			        	
			       	
			        	
			        	
			            // Esecuzione della query per l'inserimento dei dati
			            int rowsAffected = stmt.executeUpdate();

			            // Stampa il numero di righe aggiornate
			            
			            System.out.println("Numero di righe aggiornate: " + rowsAffected);

			        } catch (SQLException e) {
			            // Gestione dell'eccezione per la connessione al database o l'esecuzione della query
			            System.out.println("Errore durante la cancellazione dei dati dalla tabella 'prodotti':");
			            e.printStackTrace();
			        }
				    
				    //response.getWriter().println(prodotto + " eliminato con successo!");
				    
				 // Creazione del messaggio di popup
					String popupMessage = prodotto + " eliminato con successo!";

					// Codice JavaScript per mostrare un popup
					String script = "<script type='text/javascript'>" +
							"alert('" + popupMessage + "');" +
							"window.history.go(-1);" +
							"</script>";

					// Aggiunta del codice JavaScript alla risposta
					response.getWriter().write(script);
					    }
				    }
				
			}

		}