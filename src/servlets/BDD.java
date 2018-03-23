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

public class BDD {
	
	private Connection connexion;
    
    public List<User> recupererUtilisateurs() {
        List<User> utilisateurs = new ArrayList<User>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery("SELECT nom FROM user;");

            // R�cup�ration des donn�es
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
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user(nom, mdp) VALUES(?, ?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getMdp());
            preparedStatement.setString(3, utilisateur.getEmail());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
