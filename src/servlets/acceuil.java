package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import models.User;
import models.acceuilForm;
import models.message;

@WebServlet("/Forum")

public class acceuil extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuil.jsp" ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	acceuilForm forme = new acceuilForm();
    	
    	String message = request.getParameter("texte");
    	//System.out.println(message);
    	
    	User utilisateur = (User) request.getSession().getAttribute("sessionUtilisateur");
    	//System.out.println(utilisateur.getNom());
    	String pseudo = utilisateur.getNom();
    	
    	forme.envoiMessage(pseudo , message);
    	
    	
    	
    	ArrayList<message> lesMessages = new ArrayList<message>();
    	BDD maBDD = new BDD();
    	lesMessages = maBDD.recupererMessages();
        request.setAttribute("mesMessages", lesMessages);
        doGet(request, response);
    	
    	
    	
    }

}
