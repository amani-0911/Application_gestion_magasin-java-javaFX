package com.app.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;

public class Vente {
	private long id;
	private double total;
	private LocalDate dateV;
	private Client client;
	private String etatPaiment;
	private Map<Long,Ligne> lignes=new HashMap<Long, Ligne>();
	private List<Traite> traites=new ArrayList<>();
	
	
	public Vente(long id, LocalDate dateV, Client client,String etatPaiment) {
		
		this.id = id;
		this.dateV = dateV;
		this.client = client;
		this.etatPaiment=etatPaiment;
	}
public Vente( LocalDate dateV, Client client) {
	
		this.dateV = dateV;
		this.client = client;
	}


	public LocalDate getDateV() {
	return dateV;
}
public void setDateV(LocalDate dateV) {
	this.dateV = dateV;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getTotal() {
		calculerTotalVente();
		return total;
	}
	public List<Ligne> getLignes() {
		List<Ligne> list=new ArrayList<>();
		Set<Map.Entry<Long, Ligne>> ensemble=lignes.entrySet();
		for (Map.Entry<Long, Ligne> e: ensemble) {
			list.add(e.getValue());
		}
		return list;
	}
	public void addLigne(Ligne l){
		if(l!=null){
		long key=l.getProduit().getId();
		Ligne ligneexiste=lignes.get(key);
		if(ligneexiste==null){
			lignes.put(key, l);
		  }else{
			  int qteVTotal=l.getQteVendu()+ligneexiste.getQteVendu();
			  l.setQteVendu(qteVTotal);
			  lignes.put(key, l); 
		  }
		}
		
		
	}
	public void addTraite(Traite t){
		traites.add(t);
	}
	public List<Traite> getTraites() {
		return traites;
	}
	public void setTraites(List<Traite> traites) {
		this.traites = traites;
	}
	public boolean Lignexist(Ligne l){
		boolean exist=false;
		Ligne ligne=lignes.get(l.getProduit().getId());
		if(ligne !=null) exist=true;
		return exist;
	}
	
	public void setLignes(Map<Long, Ligne> lignes) {
		this.lignes = lignes;
	}
	public void removeLigne(long id){
		lignes.remove(id);
		
	}
	
	private void calculerTotalVente(){
		total=0;
		Set<Map.Entry<Long, Ligne>> ensemble=lignes.entrySet();
		for (Map.Entry<Long, Ligne> e: ensemble) {
			total+=e.getValue().getStotal();
		}
		
		
	}
	public String getEtatPaiment() {
		return etatPaiment;
	}
	public void setEtatPaiment(String etatPaiment) {
		this.etatPaiment = etatPaiment;
	}

}
