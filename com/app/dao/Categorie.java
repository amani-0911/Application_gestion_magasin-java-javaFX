package com.app.dao;



public class Categorie {
private long id; 
private String intitule ;
public Categorie(long id, String intitule) {
    
	this.id = id;
	this.intitule = intitule;
	
	
}
public Categorie(String intitule) {
	this.intitule = intitule;
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
@Override
public String toString() {
	return intitule;
}


}
