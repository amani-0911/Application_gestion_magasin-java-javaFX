package com.app.dao;

public class Client {
private long id;
private String prenom;
private String nom;
private String tel;
private String  email;
private String adresse;
public Client(long id, String prenom, String nom, String tel, String email, String adresse) {

	this.id = id;
	this.prenom = prenom;
	this.nom = nom;
	this.tel = tel;
	this.email = email;
	this.adresse = adresse;
}
public Client( String prenom, String nom, String tel, String email, String adresse) {
	this.prenom = prenom;
	this.nom = nom;
	this.tel = tel;
	this.email = email;
	this.adresse = adresse;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
@Override
public String toString() {
	return  prenom + " " + nom ;
}


}
