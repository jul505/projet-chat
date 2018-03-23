package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;



import models.User;
import models.message;
import models.InscriptionForm;
import servlets.BDD;


@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/bonjour.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ACCES_PUBLIC     = "/WEB-INF/acceuil.jsp";
		
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Pr�paration de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();
        
        /* R�cup�ration de la session depuis la requ�te */
        HttpSession session = request.getSession();

        
        /* Traitement de la requ�te et r�cup�ration du bean en r�sultant */
        User utilisateur = form.connecterUtilisateur( request );
		
        /* Appel au traitement et � la validation de la requ�te, et r�cup�ration du bean en r�sultant */
        //User utilisateur = form.inscrireUtilisateur( request );
        
        

        
        /*
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur � la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
        	System.out.println("OK");
            session.setAttribute( ATT_SESSION_USER, utilisateur );
            
            
            ArrayList<message> lesMessages = new ArrayList<message>();
        	BDD maBDD = new BDD();
        	lesMessages = maBDD.recupererMessages();
            request.setAttribute("mesMessages", lesMessages);
            this.getServletContext().getRequestDispatcher( ACCES_PUBLIC ).forward( request, response );
        } else {
        	System.out.println("KO");
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
        
            
		
        
		
    }
}