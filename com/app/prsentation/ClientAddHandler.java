package com.app.prsentation;



import com.app.dao.Client;
import com.app.dao.IClientDao;
import com.app.service.ClientDaoImpl;

import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;

public class ClientAddHandler {
	
		IClientDao pdao=new ClientDaoImpl();
		
		
	  FormClientWindow clientWindow=null;
	public ClientAddHandler(FormClientWindow formClientWindow){
       this.clientWindow=formClientWindow;
		
		
	}
	public void clickAdd(){
		String prenom=clientWindow.clientPrenomTextField.getText();
		String nom=clientWindow.clientnomTextField.getText();
		String tel=clientWindow.clientTelTextField.getText();
		String email=clientWindow.clientEmailTextField.getText();
		String adresse=clientWindow.clientAdresseTextField.getText();
		Client c=new Client(prenom, nom, tel, email, adresse);
	pdao.add(c);
	Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajouter Client");
    alert.setHeaderText("Vous avez Ajouter un nouveau Client");
    alert.setContentText("client:"+nom +" "+prenom);
    alert.show();
      }
}
