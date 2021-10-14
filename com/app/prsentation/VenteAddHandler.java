package com.app.prsentation;


import java.time.LocalDate;
import java.util.List;

import com.app.dao.Client;
import com.app.dao.IProduitDao;
import com.app.dao.IVenteDao;
import com.app.dao.Ligne;
import com.app.dao.Produit;
import com.app.dao.Vente;
import com.app.service.LigneDaoImpl;
import com.app.service.ProduitDaoImpl;
import com.app.service.VenteDaoImpl;

public class VenteAddHandler {
	 IVenteDao vdao=new VenteDaoImpl();
	   IProduitDao pdao=new ProduitDaoImpl();
	   LigneDaoImpl ldao=new LigneDaoImpl();
	  FormVenteWindow vWindow=null;
	  Vente v=null;
 public VenteAddHandler(FormVenteWindow formvWindow, Client c){
	  	this.vWindow=formvWindow;
	  	v=new Vente(LocalDate.now(), c);
	  }
	  public void updateProduitsListwindows(){
			List<Produit> list=pdao.getAll();
			vWindow.produitsobservableList.clear();
			vWindow.produitsobservableList.addAll(list);
			
		} 
	  private void updateLigneListwindows(){
			List<Ligne> list=v.getLignes();
			vWindow.lignesobservableList.clear();
			vWindow.lignesobservableList.addAll(list);
			updateTotal();
			
		} 
	  
	 public void deleteLigne(){
		 long id=Long.valueOf(vWindow.produitIdTextField.getText());
		 v.removeLigne(id);
		 updateLigneListwindows();
	 }
	 public void addLigne(){
		 long idv=Long.valueOf(vWindow.venteIdTextField.getText());
		 LocalDate dateV=vWindow.venteDatePicker.getValue();
		 v.setId(idv);
		 v.setDateV(dateV);
		 long id=Long.valueOf(vWindow.produitIdTextField.getText());
			int qte =Integer.valueOf(vWindow.produitQuantiteTextField.getText());
			Produit p= pdao.getOne(id);
				 Ligne l=new Ligne(qte, p, v);
		 v.addLigne(l);
		 updateLigneListwindows();
	 }
	 public void ajouter(){
		 long id=Long.valueOf(vWindow.venteIdTextField.getText());
		 LocalDate dateV=vWindow.venteDatePicker.getValue();
		 v.setId(id);
		 v.setDateV(dateV);
		 vdao.add(v);
		
	 }
	 private void updateTotal(){
		   double totalht=v.getTotal();
		   double tva=totalht*0.2;
		   double total=tva+totalht;
			vWindow.totalHtLabelValue.setText(totalht+"");
			vWindow.tva1LabelValue.setText(tva+"");
			vWindow.totalLabelValue.setText(total+"");
			
		}
	 public void ajouterLigne(){
		 for (Ligne l : v.getLignes()) {
				System.out.println(l.getDesignation());
				ldao.add(l);
			}
	 }
	 
}
