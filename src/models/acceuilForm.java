package models;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import models.message;
import servlets.BDD;

public class acceuilForm {
	
	private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

	private static final String CHAMP_LOGIN  = "login";
    private static final String CHAMP_MESSAGE   = "message";
    
    message unmessage;
    BDD maBDD;
    
    
    public void envoiMessage( String login, String message ) {
        
        unmessage = new message();
        maBDD = new BDD();

        unmessage.setPseudo(login);
        unmessage.setText(message);
        maBDD.envoiMessage(unmessage);



    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    
    private void validationNom( String nom ) throws Exception {
        if ( nom == null) {
            throw new Exception( "Pas de message" );
        }
    }
	
}
