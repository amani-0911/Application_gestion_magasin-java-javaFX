package com.app.prsentation;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormClientWindow {
	ClientAddHandler addHandler=new ClientAddHandler(this);
	VBox root=new VBox();
	   HBox buttonsBox=new HBox();
	   Scene scene=new Scene(root);
	   Stage window =new Stage();
	   Label title=new  Label("Nouveau client");
	   Label clientPrenomLabel=new  Label("Prenom :");
	   TextField clientPrenomTextField=new TextField();
	   
	   Label clientnomLabel=new  Label("Nom:");
	   TextField clientnomTextField=new TextField();
	   
	   Label clientTelLabel=new  Label(" Tel:");
	   TextField clientTelTextField=new TextField();
	   
	   Label clientEmailLabel=new  Label("Email:");
	   TextField clientEmailTextField=new TextField();
	  
	   Label clientAdresseLabel=new  Label("Adresse:");
	  TextField clientAdresseTextField=new TextField();
	  
	   Button clientAddButton= new Button("Ajouter");
	   Button clientCancelButton= new Button("Annuler");
	  
		private void initWindow(){
		window.setScene(scene);	
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Nouveau client");
		window.getIcons().add(new Image("file:icon.png"));
		window.initModality(Modality.APPLICATION_MODAL);
		

		}
		
		private void addStylesToNodes(){
			scene.getStylesheets().add("css/styles.css");
			title.getStyleClass().add("TitleNew");
		   title.setMinWidth(window.getWidth());
		   clientnomLabel.getStyleClass().add("labelForm");
		   clientPrenomLabel.getStyleClass().add("labelForm");
		   clientTelLabel.getStyleClass().add("labelForm");
		   clientEmailLabel.getStyleClass().add("labelForm");
		   clientAdresseLabel.getStyleClass().add("labelForm");
		   root.setSpacing(10);
		   buttonsBox.setSpacing(15);
		   buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
		  
		   
		   }
		private void addNodesToWindow(){

			root.getChildren().add(title);
			root.getChildren().addAll(clientPrenomLabel,clientPrenomTextField);
			   root.getChildren().addAll(clientnomLabel,clientnomTextField);
			   root.getChildren().addAll(clientTelLabel,clientTelTextField);
			   root.getChildren().addAll(clientEmailLabel,clientEmailTextField);
			   root.getChildren().addAll(clientAdresseLabel,clientAdresseTextField);
			   buttonsBox.getChildren().addAll(clientAddButton,clientCancelButton);
			   root.getChildren().add(buttonsBox);
		}
		private void addEvents(){
			window.setOnCloseRequest(event->{
				event.consume();
			});
			clientCancelButton.setOnAction(event->{
				window.close();
			});
			clientAddButton.setOnAction(event->{
		addHandler.clickAdd();
			});
			}

		public FormClientWindow() {
			initWindow();
			addEvents();
			addNodesToWindow();
			addStylesToNodes();
			window.show();
		};
}
