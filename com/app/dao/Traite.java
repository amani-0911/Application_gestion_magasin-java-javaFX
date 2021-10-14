package com.app.dao;

import java.time.LocalDate;

public class Traite {
private Long id;	
private LocalDate date;
private Vente vente;
private Cheque cheque;
public Traite(Long id, LocalDate date, Vente vente, Cheque cheque) {
	
	this.id = id;
	this.date = date;
	this.vente = vente;
	this.cheque = cheque;
}
public Traite(LocalDate date, Vente vente, Cheque cheque) {
	super();
	this.date = date;
	this.vente = vente;
	this.cheque = cheque;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public Vente getVente() {
	return vente;
}
public void setVente(Vente vente) {
	this.vente = vente;
}
public Cheque getCheque() {
	return cheque;
}
public void setCheque(Cheque cheque) {
	this.cheque = cheque;
}


}
