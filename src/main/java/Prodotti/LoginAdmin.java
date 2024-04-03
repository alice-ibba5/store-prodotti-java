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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailLoginAdmin");
        String pass = request.getParameter("passwordLoginAdmin");

        String selectQuery = "SELECT COUNT(*) FROM admin WHERE email = ? AND password = ?";

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "newdb";
        String user = "root";
        String password = "150988A?";

        try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {

            selectStmt.setString(1, email);
            selectStmt.setString(2, pass);
            ResultSet resultSet = selectStmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                // Se l'email e la password corrispondono, procedo con il login
                request.getRequestDispatcher("/paginaAdmin.jsp").forward(request, response);
            } else {
                // Se l'email e la password non corrispondono, restituisco un messaggio di errore
                response.getWriter().println("Login fallito. L'email o la password fornita non è corretta.");
            }

        } catch (SQLException e) {
            System.out.println("Errore durante il login");
            e.printStackTrace();
        }
    }
}