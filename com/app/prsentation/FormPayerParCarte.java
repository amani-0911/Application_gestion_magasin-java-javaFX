package com.app.prsentation;


import com.app.dao.Vente;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormPayerParCarte {
PayerParCartehandler handler =null;
Stage window=new Stage();
VBox root =new VBox();
Scene scene =new Scene(root);

Label titleLabelform =new Label("Payer Par Carte");


//ligne 1 msg
HBox messageBox=new HBox();
Label messageLabel=new  Label();

//ligne 2
HBox CompteNumBox=new HBox();
Label CompteNumLabel=new  Label("Numero de compte: ");
TextField CompteNumTextField=new TextField();


 HBox buttonsBox=new HBox();
 Button payerButton= new Button("payer");
 Button CancelButton=new Button("annuler");

	
	private void addNodesToPane(){
		messageBox.getChildren().add(messageLabel);
		CompteNumBox.getChildren().addAll(CompteNumLabel,CompteNumTextField);
		buttonsBox.getChildren().addAll(payerButton,CancelButton);
		
		root.getChildren().addAll(titleLabelform,messageBox,CompteNumBox,buttonsBox);
	}

	private void initwindow(){
		window.setWidth(350);
		window.setHeight(350);
		window.setScene(scene);
		window.setTitle("Payer Par Carte");
		window.getIcons().add(new Image("file:icon.png"));

		
	}
	private void addstylesNodes(){
		scene.getStylesheets().add("css/styles.css");
		titleLabelform.getStyleClass().add("labelTitle");
		titleLabelform.setPrefWidth(330);
		CompteNumLabel.setPrefWidth(330);
		CompteNumBox.setPadding(new Insets(10, 20, 10, 20));
		CompteNumTextField.setPrefWidth(330);
		CompteNumLabel.getStyleClass().add("labelForm");
		messageBox.getStyleClass().add("labelMessage");
		
		root.setPadding(new Insets(10, 10, 10, 10));

		
		buttonsBox.setSpacing(10);
			
		CompteNumBox.setPadding(new Insets(10,10,10,10));
		CompteNumBox.setSpacing(12);
		
		buttonsBox.setAlignment(Pos.BASELINE_RIGHT);
			
	}
	
	private void addEvents(){
		payerButton.setOnAction(event->{
			handler.click();
	});
		
		}

	
  public FormPayerParCarte(Vente v){
 handler=new PayerParCartehandler(this,v);
	 
	 initwindow();
	   
		addEvents();

		addstylesNodes();

		
		addNodesToPane();
		
		window.show();
}
}