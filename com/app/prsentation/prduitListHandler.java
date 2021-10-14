package com.app.prsentation;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import com.app.dao.Categorie;
import com.app.dao.IProduitDao;
import com.app.dao.Produit;
import com.app.service.ProduitDaoImpl;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class prduitListHandler {
ProduitListWindows plistwindow=null;
IProduitDao pdao=new ProduitDaoImpl();
public prduitListHandler(ProduitListWindows produitListWindows){
	plistwindow=produitListWindows; 
}
public void updateProduitsListwindows(){
	List<Produit> list=pdao.getAll();
	plistwindow.produitsobservableList.clear();
	plistwindow.produitsobservableList.addAll(list);
	updateTotal();
} 

public void deleteProduit(){
	long id=Long.valueOf(plistwindow.produitIdTextField.getText());
	String designation=plistwindow.produitDesignationTextField.getText();
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Supprimer Produit");
    alert.setHeaderText("Voulez-vous vraiment Supprimer ce  Produit?");
    alert.setContentText("Produit:"+designation);
    Optional<ButtonType> option = alert.showAndWait();
    
    if (option.get() == ButtonType.OK) {
       pdao.delete(id);
     } 
    updateProduitsListwindows();

     
}
public void updateProduit(){
	long id=Long.valueOf(plistwindow.produitIdTextField.getText());
	String designation=plistwindow.produitDesignationTextField.getText();
	double prix=Double.valueOf(plistwindow.produitPrixTextField.getText());
	int qte =Integer.valueOf(plistwindow.produitQuantiteTextField.getText());
	LocalDate date=plistwindow.produitDatePicker.getValue();
	Categorie categorie=plistwindow.combobox.getValue();
	Produit p= new Produit(id,designation, prix, qte, date, categorie);

	pdao.updateProduit(p);
	updateProduitsListwindows();
	
}
private void updateTotal(){
	double total=0;
	for (Produit p :plistwindow.produitsobservableList) {
		total+=p.getTotal();
	}
	plistwindow.totalLabelValue.setText(total+"");
}
}
