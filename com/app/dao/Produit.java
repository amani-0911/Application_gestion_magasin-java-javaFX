package com.app.dao;

import java.time.LocalDate;

public class Produit {
	private long id;
	private String designation;
	private int qte;
	private double prix;
	private double total;
	private LocalDate date;
	private Categorie categorie;
	public Produit(long id, String designation, double prix,int qte,LocalDate date,Categorie categorie) {
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.date=date;
		this.categorie=categorie;
		setQte(qte);
	}
	public Produit(String designation, double prix,int qte,LocalDate date,Categorie categorie) {
		setQte(qte);
		this.designation = designation;
		this.prix = prix;
		this.date=date;
		this.categorie=categorie;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
		total=prix*qte;
	}
	public int getQte() {
		return qte;
	}
	
	public void setQte(int qte) {
		this.qte = qte;
		total=prix*qte;
	}
	
	public double getTotal() {
		return total;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return designation +"\t"+qte+"\t"+prix+"\t"+ date+"\t"+categorie;
	}
	
}
