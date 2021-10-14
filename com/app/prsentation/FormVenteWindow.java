package com.app.prsentation;



import com.app.dao.Categorie;
import com.app.dao.Client;
import com.app.dao.Ligne;
import com.app.dao.Produit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormVenteWindow {
	VenteAddHandler handler =null;
	Stage window=new Stage();
	HBox root =new HBox();
	VBox list =new VBox();
	VBox form =new VBox();
	Scene scene =new Scene(root);
	TableView<Produit> produitsTableView=new TableView<Produit>();
	TableView<Ligne> lignesTableView=new TableView<Ligne>();
	ObservableList<Produit> produitsobservableList=FXCollections.observableArrayList();
	ObservableList<Ligne> lignesobservableList=FXCollections.observableArrayList();
	
	//form vente
	Label titleLabelform =new Label("Detail de commande");
	HBox buttonsBox=new HBox();
	//ligne1
	HBox venteIDBox=new HBox();
	Label venteIdLabel=new  Label("Numero de vente :");
	TextField venteIdTextField=new TextField();
	//ligne2
	HBox venteclientBox=new HBox();
	Label venteClientLabel=new  Label("Client : ");
	Label ClientNomLabel=new  Label();
  //ligne3
	HBox ventedatetBox=new HBox();
	Label venteDateLabel=new  Label("Date:");
	DatePicker venteDatePicker=new DatePicker();
	//ligne description
	HBox global =new HBox();
	VBox detail=new VBox();
	HBox produitIDBox=new HBox();
	Label ProduitIdLabel=new  Label("ID : ");
	TextField produitIdTextField=new TextField();
	
	HBox produitDesignationBox=new HBox();
	Label produitDesignationLabel=new  Label("Désig:");
	TextField produitDesignationTextField=new TextField();
	
	HBox produitPrixBox=new HBox();
	Label produitPrixLabel=new  Label("Prix:");
	TextField produitPrixTextField=new TextField();

	HBox produitqteBox=new HBox();
	Label produitQuantiteLabel=new  Label("Qte:");
	TextField produitQuantiteTextField=new TextField();
	Button addligneButton= new Button("+");
	Button DeleteLigneButton= new Button("-");
	//tables des produits
	TableColumn<Produit, Long> idColumn=new TableColumn<>("Id");
	TableColumn<Produit, String> designationColumn=new TableColumn<>("designation");
	TableColumn<Produit, Categorie> categorieColumn=new TableColumn<>("categorie");
	TableColumn<Produit, Double> prixColumn=new TableColumn<>("prix");
		

	 //ligne + reglement
	Label titleLabellisttotal=new Label("Reglement de commande");
	 HBox totalHTbox=new HBox();
		Label totalHtLabel=new Label("Total HT:");
		Label totalHtLabelValue=new Label("0.0");
	HBox tva1box=new HBox();
	Label tva1Label=new Label("TVA 20%:");
	Label tva1LabelValue=new Label("0.0");
	
	HBox totalbox=new HBox();
	Label totalLabel=new Label("Total:");
	Label totalLabelValue=new Label("0.0");
	
	Label titleLabellistLignes=new Label("Lignes de commande");
	
	TableColumn<Ligne, String> designationColumnLigne=new TableColumn<>("designation");
	TableColumn<Ligne, Double> prixColumnLigne=new TableColumn<>("prix");
	TableColumn<Ligne, Integer> qteColumn=new TableColumn<>("Qte");
	TableColumn<Ligne, Double> stotalColumn=new TableColumn<>("stotal");
	 HBox venteSaveBox=new HBox();
	 Button venteAddButton= new Button("Enregestrer");
	   Button venteCancelButton= new Button("Annuler");
	
	private void addColumnstoTableView(){
		produitsTableView.getColumns().addAll(idColumn,designationColumn,categorieColumn,prixColumn);
		lignesTableView.getColumns().addAll(designationColumnLigne,prixColumnLigne,qteColumn,stotalColumn);
	   produitsTableView.setItems(produitsobservableList);
	   lignesTableView.setItems(lignesobservableList);
	}
	private void addNodesToPane(){
		//form
		venteIDBox.getChildren().addAll(venteIdLabel,venteIdTextField);
	 venteclientBox.getChildren().addAll(venteClientLabel,ClientNomLabel);
	ventedatetBox.getChildren().addAll(venteDateLabel,venteDatePicker);
	
		form.getChildren().addAll(titleLabelform,venteIDBox,venteclientBox,ventedatetBox);
		
		produitIDBox.getChildren().addAll(ProduitIdLabel,produitIdTextField);
		produitDesignationBox.getChildren().addAll(produitDesignationLabel,produitDesignationTextField);
		
		produitPrixBox.getChildren().addAll(produitPrixLabel,produitPrixTextField);
		produitqteBox.getChildren().addAll(produitQuantiteLabel,produitQuantiteTextField);
		buttonsBox.getChildren().addAll(addligneButton,DeleteLigneButton);
		detail.getChildren().addAll(produitIDBox,produitDesignationBox,produitPrixBox,produitqteBox);
		global.getChildren().addAll(detail,buttonsBox);
		form.getChildren().addAll(global,produitsTableView);
		  ;
		  
		  //ligne
		  
	
			
			totalHTbox.getChildren().addAll(totalHtLabel,totalHtLabelValue);
			tva1box.getChildren().addAll(tva1Label,tva1LabelValue);
			
			totalbox.getChildren().addAll(totalLabel,totalLabelValue);
			venteSaveBox.getChildren().addAll(venteAddButton,venteCancelButton);
		list.getChildren().addAll(titleLabellisttotal,totalHTbox,tva1box,totalbox,titleLabellistLignes,lignesTableView,venteSaveBox);
		root.getChildren().addAll(form,list);
	}

	private void initwindow(){
		window.setWidth(1020);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("ajouter un vente");
		window.getIcons().add(new Image("file:icon.png"));

		
	}
	private void addstylesNodes(){
		scene.getStylesheets().add("css/styles.css");
		titleLabelform.getStyleClass().add("labelTitle");
		titleLabellisttotal.getStyleClass().add("labelTitle");
		titleLabellistLignes.getStyleClass().add("labelTitle");
		titleLabelform.setPrefWidth(500);
		titleLabellisttotal.setPrefWidth(500);
		titleLabellistLignes.setPrefWidth(500);
		
		venteIdLabel.getStyleClass().add("labelForm");
		venteClientLabel.getStyleClass().add("labelForm");
		venteDateLabel.getStyleClass().add("labelForm");
		ProduitIdLabel.getStyleClass().add("labelForm");
		produitDesignationLabel.getStyleClass().add("labelForm");
		produitQuantiteLabel.getStyleClass().add("labelForm");
		addligneButton.getStyleClass().add("addToPanier");
		DeleteLigneButton.getStyleClass().add("deleteToPanier");
		totalHTbox.getStyleClass().add("labelReglement");
		ClientNomLabel.getStyleClass().add("clientNom");
		tva1box.getStyleClass().add("labelReglement");
		totalbox.getStyleClass().add("labelReglement");
		
		produitsTableView.getStyleClass().add("table-row-cell");
	lignesTableView.getStyleClass().add("table-row-cell");
	
		form.setMinWidth(500);
		list.setPadding(new Insets(10, 10, 10, 10));
		produitsTableView.setMinHeight(480);
		list.setMinWidth(500);
		lignesTableView.setMinWidth(480);
		global.setSpacing(15);
		global.setPadding(new  Insets(10, 10, 10, 10));
		
		root.setSpacing(10);
		buttonsBox.setSpacing(5);
		produitDesignationBox.setSpacing(12);
		produitPrixBox.setSpacing(22);
		produitqteBox.setSpacing(22);
		produitIDBox.setSpacing(25);
		venteSaveBox.setSpacing(10);
		venteSaveBox.setAlignment(Pos.BASELINE_RIGHT);
		buttonsBox.setPadding(new Insets(50, 10, 0, 0));
		
	}
	private void updateColumns(){
	idColumn.setCellValueFactory(new PropertyValueFactory("id"));
	idColumn.setPrefWidth(90);
	designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
	designationColumn.setPrefWidth(190);
	categorieColumn.setCellValueFactory(new PropertyValueFactory("categorie"));
	categorieColumn.setPrefWidth(120);
	prixColumn.setCellValueFactory(new PropertyValueFactory("prix"));
	prixColumn.setPrefWidth(100);
	designationColumnLigne.setCellValueFactory(new PropertyValueFactory("designation"));
	designationColumnLigne.setPrefWidth(150);
	prixColumnLigne.setCellValueFactory(new PropertyValueFactory("prix"));
	prixColumnLigne.setPrefWidth(100);
     qteColumn.setCellValueFactory(new PropertyValueFactory("qteVendu"));
     qteColumn.setPrefWidth(100);
	stotalColumn.setCellValueFactory(new PropertyValueFactory("stotal"));
	stotalColumn.setPrefWidth(130);
	

	}

	private void addEvents(){
		produitsTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Produit p=produitsTableView.getSelectionModel().getSelectedItem();
			produitIdTextField.setText(	p.getId()+"");
			produitDesignationTextField.setText(p.getDesignation());
			 produitPrixTextField.setText(p.getPrix()+"");
			produitQuantiteTextField.setText(1+"");
			
		  
		});
		lignesTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Ligne l=lignesTableView.getSelectionModel().getSelectedItem();
			produitIdTextField.setText(l.getProduit().getId()+"");
			produitDesignationTextField.setText(l.getDesignation());
			 produitPrixTextField.setText(l.getPrix()+"");
			produitQuantiteTextField.setText(l.getQteVendu()+"");
			  
		});
		addligneButton.setOnAction(event->{
				handler.addLigne();
				updateColumns();
		});
		DeleteLigneButton.setOnAction(event->{
		handler.deleteLigne();
		updateColumns();
		
		});
		venteCancelButton.setOnAction(event->{
			window.close();
		});
		venteAddButton.setOnAction(event->{
		handler.ajouter();
		handler.ajouterLigne();
		});
		}
	public FormVenteWindow(Client c){
		handler=new VenteAddHandler(this,c);
		
		initwindow();
		ClientNomLabel.setText(c.getPrenom()+" "+c.getNom());
		addEvents();
		addstylesNodes();
		updateColumns();
		addColumnstoTableView();
		
	handler.updateProduitsListwindows();
		
		addNodesToPane();
		
		window.show();
	
	}

}
