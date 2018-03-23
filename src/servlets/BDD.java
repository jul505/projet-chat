package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;
import models.message;

public class BDD {
	
	private Connection connexion;
    
    public List<User> recupererUtilisateurs() {
        List<User> utilisateurs = new ArrayList<User>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT nom FROM user;");

            // Récupération des données
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                
                User utilisateur = new User();
                utilisateur.setNom(nom);
                
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return utilisateurs;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterUtilisateur(User utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user(pseudo, mdp, email) VALUES(?, ?, ?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getMdp());
            preparedStatement.setString(3, utilisateur.getEmail());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<message> recupererMessages() {
    	ArrayList<message> lesMessages = new ArrayList<message>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {

            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM messages;");

            // Récupération des données
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String text = resultat.getString("message");
                String pseudo = resultat.getString("user");
                
                message texte = new message();
                texte.setId(id);
                texte.setText(text);
                texte.setPseudo(pseudo);
                
                lesMessages.add(texte);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return lesMessages;
    }
    
    
    public void envoiMessage(message unMessage) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO messages(message, user) VALUES(?, ?);");
            preparedStatement.setString(1, unMessage.getText());
            preparedStatement.setString(2, unMessage.getPseudo());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    

}
