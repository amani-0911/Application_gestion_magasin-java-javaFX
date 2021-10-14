package com.app.prsentation;



import com.app.dao.Categorie;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormProduitWindow {
	ProduitAddHandler addHandler=new ProduitAddHandler(this);
	VBox root=new VBox();
	   HBox buttonsBox=new HBox();
	   Scene scene=new Scene(root);
	   Stage window =new Stage();
	   Label title=new  Label("Nouveau produit");
	   Label produitDesignationLabel=new  Label("Désignation :");
	   TextField produitDesignationTextField=new TextField();
	   
	   Label produitPrixLabel=new  Label("Prix:");
	   TextField produitPrixTextField=new TextField();
	   
	   Label produitQuantiteLabel=new  Label(" Quantité:");
	   TextField produitQuantiteTextField=new TextField();
	   
	   Label produitDateLabel=new  Label("Date:");
	   DatePicker produitDatePicker=new DatePicker();
	   
	   Button produitAddButton= new Button("Ajouter");
	   Button produitCancelButton= new Button("Annuler");
	  
	    Label produitCategorieLabel=new  Label("Categorie");
	    ComboBox<Categorie> combobox=new ComboBox<Categorie>();
	    CategoriesHandler categoriesHandler=new CategoriesHandler(combobox);
		private void initWindow(){
		window.setScene(scene);	
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Nouveau produit");
		window.getIcons().add(new Image("file:icon.png"));
		window.initModality(Modality.APPLICATION_MODAL);
		

		}
		
		private void addStylesToNodes(){
			scene.getStylesheets().add("css/styles.css");
			title.getStyleClass().add("TitleNew");
		   title.setMinWidth(window.getWidth());
		   produitDesignationLabel.getStyleClass().add("labelForm");
		   produitPrixLabel.getStyleClass().add("labelForm");
		   produitDateLabel.getStyleClass().add("labelForm");
		   produitQuantiteLabel.getStyleClass().add("labelForm");
		   produitCategorieLabel.getStyleClass().add("labelForm");
		   root.setSpacing(10);
		   buttonsBox.setSpacing(15);
		   buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
		   combobox.setMaxWidth(180);
		   
		   }
		private void addNodesToWindow(){
			root.getChildren().add(title);
			root.getChildren().addAll(produitDesignationLabel,produitDesignationTextField);
			   root.getChildren().addAll(produitPrixLabel,produitPrixTextField);
			   root.getChildren().addAll(produitQuantiteLabel,produitQuantiteTextField);
			   root.getChildren().addAll(produitDateLabel,produitDatePicker);
			   root.getChildren().addAll(produitCategorieLabel,combobox);
			   buttonsBox.getChildren().addAll(produitAddButton,produitCancelButton);
			   root.getChildren().add(buttonsBox);
		}
		private void addEvents(){
			window.setOnCloseRequest(event->{
				event.consume();
			});
			produitCancelButton.setOnAction(event->{
				window.close();
			});
			produitAddButton.setOnAction(event->{
			addHandler.click();
			});
			}

		public FormProduitWindow() {
			initWindow();
			addEvents();
			addNodesToWindow();
			addStylesToNodes();
			window.show();
		};
}
