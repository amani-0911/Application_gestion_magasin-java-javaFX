package com.app.prsentation;


import com.Dao.Reglement;
import com.app.dao.IVenteDao;

import com.app.dao.Vente;

import com.app.service.VenteDaoImpl;
import com.connexion.ClientConnecter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PayerParCartehandler {
	FormPayerParCarte pWindow=null;
	ClientConnecter client=null;
	IVenteDao vdao=new VenteDaoImpl();
	private Vente v=null;
	private double total=0;

	public PayerParCartehandler(FormPayerParCarte w,Vente ve){
		pWindow=w;
		v=ve;
	}
	

	  
	  private void calculerTotal(){
		   double totalht=v.getTotal();
		   total=(totalht*0.2)+totalht;
		   
		}
	
	  
	  public void click(){
		            client= new ClientConnecter();
		    String numCompte=pWindow.CompteNumTextField.getText();
		    String ch=client.getInfoCompte(numCompte);
			if(ch.equals("echec")){
				pWindow.messageLabel.setText("le compte saisi n'exist pas!");
			}else{
			  calculerTotal();
			 Reglement r=new Reglement(numCompte, total);
			 client.regler(r);
			 String s=client.succesOperation();
			 if(s.equals("le paiment est bien recu")){
				 vdao.updateEtatPaiment(v, "PAYE");
			 }
			
			 Alert alert = new Alert(AlertType.INFORMATION);
			 alert.setTitle("Payer Par carte");
			 alert.setHeaderText(s);
			 alert.setContentText("vente:"+v.getId());
			
			  alert.show();
			}
			
			
	  }

	  
	    

}
