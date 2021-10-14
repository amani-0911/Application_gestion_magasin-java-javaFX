package com.app.prsentation;

import java.time.LocalDate;

import com.app.dao.Categorie;
import com.app.dao.IProduitDao;
import com.app.dao.Produit;

import com.app.service.ProduitDaoImpl;



public class ProduitAddHandler {
	IProduitDao pdao=new ProduitDaoImpl();
	
	
  FormProduitWindow produitWindow=null;
public ProduitAddHandler(FormProduitWindow formProduitWindow){
	this.produitWindow=formProduitWindow;
	
	
}
public void click(){
	String designation=produitWindow.produitDesignationTextField.getText();
	double prix=Double.valueOf(produitWindow.produitPrixTextField.getText());
	int qte=Integer.valueOf(produitWindow.produitQuantiteTextField.getText());
	LocalDate date=produitWindow.produitDatePicker.getValue();
	Categorie categorie=produitWindow.combobox.getValue();
	Produit p= new Produit(designation, prix, qte, date, categorie);
	pdao.add(p);

}

}
