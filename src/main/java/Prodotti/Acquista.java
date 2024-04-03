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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;




@WebServlet("/Acquista")
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Acquista() {
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
		String[] prodottiDaAcquistare = request.getParameterValues("ordini");

		String insertQuery1 = "UPDATE prodotti SET quantita = quantita - 1 WHERE nome=(?);";
		String url = "jdbc:mysql://localhost:3306/"; // URL del database
		String dbName = "newdb"; // Nome del database
		String user = "root"; // Nome utente
		String password = "150988A?"; 

		System.out.println(prodottiDaAcquistare);

		if (prodottiDaAcquistare != null) {

			int somma = 0;
			for (String prodotto : prodottiDaAcquistare) {

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
					System.out.println("Errore durante l'update dei dati dalla tabella 'prodotti':");
					e.printStackTrace();
				}


				String query = "SELECT prezzo FROM prodotti WHERE nome = ?";

				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "150988A?");
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, prodotto);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						int prezzo = rs.getInt("prezzo");
						System.out.println(prezzo);
						somma += prezzo;
						// Utilizza il prezzo ottenuto
					} else {
						// Prodotto non trovato
					}
					rs.close();
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}


			}

			request.setAttribute("lista", prodottiDaAcquistare);
			request.setAttribute("somma", somma);

			String prodotti = "";
			for (String prod: prodottiDaAcquistare) {
				prodotti += " " + prod;
			}


			// Indirizzo email del mittente
			String from = "alice.ibba5@gmail.com";
			// Password dell'account email del mittente
			String pass = "pudh irpo vhvh tksm";
			// Indirizzo email del destinatario
			String to = "alice.ibba5@gmail.com";

			// Proprietà per la configurazione del server SMTP di Gmail
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.trust", "*");

			// Creazione di un oggetto di autenticazione
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, pass);
				}
			};

			// Creazione di una nuova sessione SMTP con autenticazione
			Session session = Session.getInstance(props, auth);

			try {
				// Creazione del messaggio email
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject("Recap del tuo acquisto");
				message.setText("Questo è un esempio di invio email con JavaMail API. Ciao!");

				// Invio dell'email
				Transport.send(message);

				System.out.println("Email inviata con successo!");
			} catch (MessagingException e) {
				e.printStackTrace();
				System.out.println("Errore durante l'invio dell'email.");
			}

			//request.getRequestDispatcher("/risultatoAcquisto.jsp").forward(request, response);

			// Creazione del messaggio di popup
			String popupMessage = "Acquisto completato con successo! Totale: " + somma + " euro.";

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

