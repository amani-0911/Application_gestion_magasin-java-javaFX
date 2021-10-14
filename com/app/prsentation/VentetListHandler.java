package com.app.prsentation;


import java.util.ArrayList;
import java.util.List;


import com.app.dao.Client;
import com.app.dao.IClientDao;
import com.app.dao.IVenteDao;

import com.app.dao.Vente;
import com.app.service.ClientDaoImpl;
import com.app.service.LigneDaoImpl;
import com.app.service.VenteDaoImpl;

public class VentetListHandler {
	VenteListWimdows vWindow=null;
	SelectVentePayer vselectWindow=null;
	IVenteDao vdao=new VenteDaoImpl();
	 LigneDaoImpl ldao=new LigneDaoImpl();
	 IClientDao cdao=new ClientDaoImpl();
	  
public VentetListHandler(VenteListWimdows w){
	  	this.vWindow=w;
	  	
	  }
public VentetListHandler(SelectVentePayer w){
  	this.vselectWindow=w;
  	
  }
public void updateventesListwindowsSelect(){
	List<Vente> list=vdao.getAll();
	vselectWindow.VentesobservableList.clear();
	vselectWindow.VentesobservableList.addAll(list);
}
public void updateVenteListwindows(){
	List<Vente> list=vdao.getAll();
	vWindow.VentesobservableList.clear();
	vWindow.VentesobservableList.addAll(list);
	
} 
private void reglement(double total){
	vWindow.totalHtLabelValue.setText(total+"");
	double tva=total*0.2;
	vWindow.tva1LabelValue.setText(tva+"");
	vWindow.totalLabelValue.setText((total+tva)+"");
}
public void getdetail(Vente v){
v.setLignes(ldao.getAll(v.getId()));
vWindow.lignesobservableList.clear();
vWindow.lignesobservableList.addAll(v.getLignes());
reglement(v.getTotal());

}
public void chercherVenteClient(){
	String  nom=vWindow.rechercheclientVente.getText();
	List<Vente> listtotal=new ArrayList<Vente>();
	List<Client> c=cdao.getAll(nom);
	for (Client client : c) {
		List<Vente> list=vdao.getAll(client);
		listtotal.addAll(list);
		
	}
	
	vWindow.VentesobservableList.clear();
	vWindow.VentesobservableList.addAll(listtotal);
}
public void chercherVenteClientPayer(){
	String  nom=vselectWindow.recherchetxtfVente.getText();
	List<Vente> listtotal=new ArrayList<Vente>();
	List<Client> c=cdao.getAll(nom);
	for (Client client : c) {
		List<Vente> list=vdao.getAll(client);
		listtotal.addAll(list);
		
	}
	
	vselectWindow.VentesobservableList.clear();
	vselectWindow.VentesobservableList.addAll(listtotal);
}
}
