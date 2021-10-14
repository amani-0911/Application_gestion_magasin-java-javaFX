package com.app.dao;

public class Cheque {
private Long id;		
private Double montant;
private String propriétaire;
private String banque;
private String numéro;
public Cheque(Long id, Double montant, String propriétaire, String banque, String numéro) {

	this.id = id;
	this.montant = montant;
	this.propriétaire = propriétaire;
	this.banque = banque;
	this.numéro = numéro;
}
public Cheque(Double montant, String propriétaire, String banque, String numéro) {
	super();
	this.montant = montant;
	this.propriétaire = propriétaire;
	this.banque = banque;
	this.numéro = numéro;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Double getMontant() {
	return montant;
}
public void setMontant(Double montant) {
	this.montant = montant;
}
public String getPropriétaire() {
	return propriétaire;
}
public void setPropriétaire(String propriétaire) {
	this.propriétaire = propriétaire;
}
public String getBanque() {
	return banque;
}
public void setBanque(String banque) {
	this.banque = banque;
}
public String getNuméro() {
	return numéro;
}
public void setNuméro(String numéro) {
	this.numéro = numéro;
}
@Override
public String toString() {
	return   montant+"" ;
}


}
