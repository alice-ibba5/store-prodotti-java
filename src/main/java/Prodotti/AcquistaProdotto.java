package Prodotti;

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
 * Servlet implementation class EliminaProdotto
 */


    @WebServlet("/AcquistaProdotto")
    public class AcquistaProdotto extends HttpServlet {

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    	  ArrayList<Prodotto> prodotti = new ArrayList<>(); // Create an empty list to store products

    	  // Replace these details with your actual database connection information
    	  String url = "jdbc:mysql://localhost:3306/";
    	  String dbName = "newdb";
    	  String user = "root";
    	  String password = "150988A?";

    	  try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
    	       Statement stmt = conn.createStatement();
    	       ResultSet rs = stmt.executeQuery("SELECT * FROM prodotti")) {

    	    while (rs.next()) {
    	      // Create a new Prodotto object for each product record
    	      Prodotto prodotto = new Prodotto();  // Replace with your column names
    	      int id = rs.getInt("id");
              String nome = rs.getString("nome");
              int prezzo = rs.getInt("prezzo");
              int quantita = rs.getInt("quantita");
              
              // Creazione di un nuovo oggetto Prodotto e aggiunta alla lista
              
              prodotto.setId(id);
              prodotto.setNome(nome);
              prodotto.setPrezzo(prezzo);
              prodotto.setQuantita(quantita);
              prodotti.add(prodotto);
    	      // Add the product object to the list
    	      
    	    }
    	  } catch (SQLException e) {
    	    e.printStackTrace();
    	    // Handle database exceptions appropriately (e.g., log the error or redirect to an error page)
    	  }

    	  // Set the product list as a request attribute
    	  request.setAttribute("listaProdotti", prodotti);

    	  // Forward the request to the JSP for displaying the dropdown
    	  request.getRequestDispatcher("/acquistaProdotto.jsp").forward(request, response);
    	}
}