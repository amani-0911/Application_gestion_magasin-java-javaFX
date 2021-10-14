package com.app.dao;

public class Ligne {
	private int qteVendu;
	private double stotal;
	private Produit produit;
    private Vente vente; 
    private String designation;
	private double prix;

	public Ligne(int qte, Produit produit,Vente vente){
		this.qteVendu=qte;
		this.produit=produit;
		this.vente=vente; 
		designation=produit.getDesignation();
		prix=produit.getPrix();
	}
	

	public String getDesignation() {
		return designation;
	}


	public double getPrix() {
		return prix;
	}


	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public int getQteVendu() {
		return qteVendu;
	}

	public void setQteVendu(int qteVendu) {
		this.qteVendu = qteVendu;
	}

	public double getStotal() {
		calculerTotal();
		return stotal;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	private void calculerTotal(){
		stotal=qteVendu*produit.getPrix();
	}
	
	
}
