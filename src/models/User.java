package models;

import java.util.HashMap;


public class User {
	HashMap<String,String> erreurs;
	
	
	
	private String nom;
	private String email;
	private String mdp;
	
	
	public User(String user, String email, String mdp) {
		super();
		this.setNom(nom);
		this.setEmail(email);
		this.setMdp(mdp);
	}
	
	public User() {}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
