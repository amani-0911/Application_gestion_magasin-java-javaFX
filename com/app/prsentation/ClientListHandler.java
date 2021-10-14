package com.app.prsentation;


import java.util.List;
import java.util.Optional;

import com.app.dao.Client;
import com.app.dao.IClientDao;

import com.app.service.ClientDaoImpl;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class ClientListHandler {
	ClientListWindows clistwindow=null;
	SelectClientVente slectClient=null;
	IClientDao cdao=new ClientDaoImpl();
	public ClientListHandler(ClientListWindows win){
		clistwindow=win; 
	}
	public ClientListHandler(SelectClientVente win){
		slectClient=win; 
	}
	public void updateClientsListwindows(){
		List<Client> list=cdao.getAll();
		clistwindow.clientsobservableList.clear();
		clistwindow.clientsobservableList.addAll(list);
		
	} 
	public void updateClientsListwindowsSelect(){
		List<Client> list=cdao.getAll();
		slectClient.clientsobservableList.clear();
		slectClient.clientsobservableList.addAll(list);
		
	} 

	public void deleteClient(){
		long id=Long.valueOf(clistwindow.ClientIdTextField.getText());
		String nom=clistwindow.clientnomTextField.getText();
		String prenom=clistwindow.clientPrenomTextField.getText();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Supprimer Client");
	    alert.setHeaderText("Voulez-vous vraiment Supprimer ce  Client?");
	    alert.setContentText("Client:"+prenom+" "+nom);
	    Optional<ButtonType> option = alert.showAndWait();
	    
	    if (option.get() == ButtonType.OK) {
	       cdao.delete(id);
	     } 
	    updateClientsListwindows();
	     
	}
	public void updateClient(){
		long id=Long.valueOf(clistwindow.ClientIdTextField.getText());
		String prenom=clistwindow.clientPrenomTextField.getText();
		String nom=clistwindow.clientnomTextField.getText();
		String tel=clistwindow.clientTelTextField.getText();
		String email=clistwindow.clientEmailTextField.getText();
		String adresse=clistwindow.clientAdresseTextField.getText();
		Client c=new Client(id,prenom, nom, tel, email, adresse);

		cdao.updateClient(c);
		 updateClientsListwindows();
	}
	public void chercherClient(){
		String nom=clistwindow.rechercheTextField.getText();
	 List<Client> list=cdao.getAll(nom);
	 clistwindow.clientsobservableList.clear();
	clistwindow.clientsobservableList.addAll(list);
	}
	public void chercherClientVente(){
		String nom=slectClient.rechercheTextField.getText();
	 List<Client> list=cdao.getAll(nom);
	 slectClient.clientsobservableList.clear();
	 slectClient.clientsobservableList.addAll(list);
	}
	
}
