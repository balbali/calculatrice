package ExempleJAVAFX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    public Connection Connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/users";
            String user = "root";
            String password = ""; // Mettez votre mot de passe MySQL ici
            
            // Essayer d'abord avec le nouveau driver, puis avec l'ancien
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // Essayer avec l'ancien driver
                Class.forName("com.mysql.jdbc.Driver");
            }
            
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données réussie !");
            return conn;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, 
                "Driver MySQL non trouvé. Veuillez ajouter le driver MySQL au projet.", ex);
            System.err.println("ERREUR: Driver MySQL non trouvé.");
            System.err.println("Téléchargez-le depuis: https://dev.mysql.com/downloads/connector/j/");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, 
                "Erreur de connexion à la base de données", ex);
            System.err.println("ERREUR SQL: " + ex.getMessage());
        }
        return null;
    }
}