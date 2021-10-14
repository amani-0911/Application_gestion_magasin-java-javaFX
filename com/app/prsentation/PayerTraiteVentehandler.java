package com.app.prsentation;

import java.time.LocalDate;
import java.util.List;

import com.app.dao.Cheque;
import com.app.dao.IChequeDao;
import com.app.dao.ITraiteDao;
import com.app.dao.IVenteDao;
import com.app.dao.Traite;
import com.app.dao.Vente;
import com.app.service.ChequeDaoImpl;
import com.app.service.TraiteDaoImpl;
import com.app.service.VenteDaoImpl;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PayerTraiteVentehandler {
	FormPayerTraiteVente pWindow=null;
	ITraiteDao tdao=new TraiteDaoImpl();
	IVenteDao vdao=new VenteDaoImpl();
	IChequeDao chdao=new ChequeDaoImpl();
	private Vente v=null;
	private double total=0;
	private double totalpayer=0;
	public PayerTraiteVentehandler(FormPayerTraiteVente w,Vente ve){
		pWindow=w;
		v=ve;
	}
	  public void updatetraitesListwindows(){
			List<Traite> list=tdao.getAll(v);
			 v.setTraites(list);
			pWindow.traitesobservableList.clear();
			pWindow.traitesobservableList.addAll(list);
			updateTotal();
		}
	  private void calculerReste(){
		  if(v.getTraites().size()>0){
		  for (Traite t : v.getTraites()) {
			totalpayer+=t.getCheque().getMontant();
		}
		  }
	  }
	  
	  private void updateTotal(){
		   double totalht=v.getTotal();
		   total=(totalht*0.2)+totalht;
		   calculerReste();
		   pWindow.totalVenteLabelValue.setText(total+"");
		   pWindow.totalpayerLabelValue.setText(totalpayer+"");
		   pWindow.totalNonLabelValue.setText((total-totalpayer)+"");
			
		}
	  
	  
	  public void clickAdd(){
		    double montant=Long.valueOf(pWindow.traitechequeMontantTextField.getText());
			String propriétaire=pWindow.traitechequePropriétaireField.getText();
			String banque=pWindow.traitechequebanqueTextField.getText();
			String numéro=pWindow.traitechequeNumeroTextField.getText();
			Cheque ch=new Cheque(montant, propriétaire, banque, numéro);
			chdao.add(ch);
		    ch=chdao.getOne(numéro);
			LocalDate date=pWindow.traitedatePicker.getValue();
			Traite t=new Traite(date, v, ch);
		   tdao.add(t);
		   

	    updatetraitesListwindows();
	    
if((total-totalpayer)==0){
	 vdao.updateEtatPaiment(v, "PAY"); 	
	    }else{
	  vdao.updateEtatPaiment(v, "TRIT");
	    }
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Ajouter Traite");
alert.setHeaderText("Vous avez Ajouter un nouveau traite");
alert.setContentText("vente:"+v.getId());
alert.show();
	    }
}
