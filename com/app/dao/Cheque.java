package com.app.dao;

public class Cheque {
private Long id;		
private Double montant;
private String propri�taire;
private String banque;
private String num�ro;
public Cheque(Long id, Double montant, String propri�taire, String banque, String num�ro) {

	this.id = id;
	this.montant = montant;
	this.propri�taire = propri�taire;
	this.banque = banque;
	this.num�ro = num�ro;
}
public Cheque(Double montant, String propri�taire, String banque, String num�ro) {
	super();
	this.montant = montant;
	this.propri�taire = propri�taire;
	this.banque = banque;
	this.num�ro = num�ro;
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
public String getPropri�taire() {
	return propri�taire;
}
public void setPropri�taire(String propri�taire) {
	this.propri�taire = propri�taire;
}
public String getBanque() {
	return banque;
}
public void setBanque(String banque) {
	this.banque = banque;
}
public String getNum�ro() {
	return num�ro;
}
public void setNum�ro(String num�ro) {
	this.num�ro = num�ro;
}
@Override
public String toString() {
	return   montant+"" ;
}


}
