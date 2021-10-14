package com.app.prsentation;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.dao.IProduitDao;
import com.app.dao.IVenteDao;
import com.app.dao.Ligne;
import com.app.dao.Produit;
import com.app.dao.Vente;
import com.app.service.LigneDaoImpl;
import com.app.service.ProduitDaoImpl;
import com.app.service.VenteDaoImpl;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class VenteReglementHandler {
	 IVenteDao vdao=new VenteDaoImpl();
	   IProduitDao pdao=new ProduitDaoImpl();
	   LigneDaoImpl ldao=new LigneDaoImpl();
	   ReglementVenteWindow vWindow=null;
	  Vente v=null;
public VenteReglementHandler(ReglementVenteWindow vWindow, Vente v){
	  	this.vWindow=vWindow;
	  	this.v=v;
	  }
	  public void updateProduitsListwindows(){
			List<Produit> list=pdao.getAll();
			vWindow.produitsobservableList.clear();
			vWindow.produitsobservableList.addAll(list);
			
		} 
	 public void updateLigneListwindows(){
			Map<Long,Ligne> list=ldao.getAll(v.getId());
			v.setLignes(list);
			vWindow.lignesobservableList.clear();
			vWindow.lignesobservableList.addAll(v.getLignes());
			updateTotal();
			
		} 
	  
	 public void deleteLigne(){
		 long id=Long.valueOf(vWindow.produitIdTextField.getText());
		 v.removeLigne(id);
		 ldao.delete(v.getId(),id);
		 updateLigneListwindows();
	 }
	 public void addLigne(){
	
		 long id=Long.valueOf(vWindow.produitIdTextField.getText());
		int qte =Integer.valueOf(vWindow.produitQuantiteTextField.getText());
		Produit p= pdao.getOne(id);
				 Ligne l=new Ligne(qte, p, v);
		
		 if(v.Lignexist(l)){ 
			 Ligne ne=ldao.getOne(v, l.getProduit().getId());
			 ne.setQteVendu(ne.getQteVendu()+l.getQteVendu());
			 ldao.Update(ne);
		 }else{
			 ldao.add(l);
		 }
		 updateLigneListwindows();
	 }

	 private void updateTotal(){
		   double totalht=v.getTotal();
		   double tva=totalht*0.2;
		   double total=tva+totalht;
			vWindow.totalHtLabelValue.setText(totalht+"");
			vWindow.tva1LabelValue.setText(tva+"");
			vWindow.totalLabelValue.setText(total+"");
			
		}
	 public void payerVenteTotel(){
		 long id= Long.valueOf(vWindow.venteIdtvalue.getText());
		 Vente v=vdao.getOne(id);
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		    alert.setTitle("Payer Vente");
		    alert.setHeaderText("confirmer le paiment de vente?");
		    alert.setContentText("Vente:"+v.getId());
		    Optional<ButtonType> option = alert.showAndWait();
		    
		    if (option.get() == ButtonType.OK) {
		    	 vdao.updateEtatPaiment(v, "PAYE");
		     } 
		
	 }
	 


}
