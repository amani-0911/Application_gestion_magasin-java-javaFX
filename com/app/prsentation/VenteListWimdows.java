package com.app.prsentation;

import java.time.LocalDate;


import com.app.dao.Ligne;

import com.app.dao.Vente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;

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

public class VenteListWimdows {
VentetListHandler handler =new VentetListHandler(this);
	Stage window=new Stage();
	HBox root =new HBox();
	VBox listVente =new VBox();
	VBox detail =new VBox();
	Scene scene =new Scene(root);
	TableView<Vente> venteTableView=new TableView<Vente>();
	ObservableList<Vente> VentesobservableList=FXCollections.observableArrayList();
	TableView<Ligne> lignesTableView=new TableView<Ligne>();
	ObservableList<Ligne> lignesobservableList=FXCollections.observableArrayList();
	Label titleLabel =new Label("Listes des ventes");
	HBox recherchebox=new HBox();
	Label rechercheLabel=new Label("Client:");
	TextField rechercheclientVente =new TextField();
	
	Button rechercherButton=new Button("rechercher");

	TableColumn<Vente, Long> idColumn=new TableColumn<>("Id");
	TableColumn<Vente, String> clientColumn=new TableColumn<>("client");
	TableColumn<Vente, LocalDate> dateColumn=new TableColumn<>("date");

	
	
	TableColumn<Ligne, String> designationColumn=new TableColumn<>("designation");
	TableColumn<Ligne, Integer> qteVenduColumn=new TableColumn<>("qteVendu");
	
	TableColumn<Ligne, Double> prixColumn=new TableColumn<>("prix");
	TableColumn<Ligne, Double> stotalColumn=new TableColumn<>("stotal");
	//detail
	
	Label titleLabeldetail =new Label("Detail de commande");
	
	Label titleLabellisttotal=new Label("Reglement de commande");
   
	HBox totalHTbox=new HBox();
    Label totalHtLabel=new Label("Total HT:");
	Label totalHtLabelValue=new Label("0.0");
	HBox tva1box=new HBox();
	Label tva1Label=new Label("TVA 20%:");
	Label tva1LabelValue=new Label("0.0");
	
	HBox totalbox=new HBox();
	Label totalLabel=new Label("Total :");
	Label totalLabelValue=new Label("0.0");
	
  
	private void addColumnstoTableView(){
		venteTableView.getColumns().addAll(idColumn,clientColumn,dateColumn);
		lignesTableView.getColumns().addAll(designationColumn,qteVenduColumn,prixColumn,stotalColumn);
		venteTableView.setItems(VentesobservableList);
		lignesTableView.setItems(lignesobservableList);
	}
	
	
	private void addNodesToPane(){
		
		recherchebox.getChildren().addAll(rechercheLabel,rechercheclientVente,rechercherButton);
		listVente.getChildren().addAll(titleLabel,recherchebox);
		listVente.getChildren().add(venteTableView);
		
		  detail.getChildren().addAll(titleLabeldetail,lignesTableView);
		 
		  totalHTbox.getChildren().addAll(totalHtLabel,totalHtLabelValue);
		  tva1box.getChildren().addAll(tva1Label,tva1LabelValue);
		  totalbox.getChildren().addAll(totalLabel,totalLabelValue);
		  detail.getChildren().addAll(titleLabellisttotal,totalHTbox,tva1box,totalbox);
		   root.getChildren().addAll(listVente,detail);
		
	}

	private void initwindow(){
		window.setWidth(1020);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("liste des ventes");
		window.getIcons().add(new Image("file:icon.png"));

		
	}
	private void addstylesNodes(){
		scene.getStylesheets().add("css/styles.css");
		titleLabel.getStyleClass().add("labelTitle");
		titleLabellisttotal.getStyleClass().add("labelTitle");
		titleLabeldetail.getStyleClass().add("labelTitle");
		rechercheLabel.getStyleClass().add("labelTotal");
		recherchebox.getStyleClass().add("boxTotal");
		recherchebox.setPadding(new Insets(10, 0, 0, 100));
		titleLabel.setPrefWidth(600);
		titleLabellisttotal.setPrefWidth(500);
		titleLabeldetail.setPrefWidth(500);
		
		totalHTbox.getStyleClass().add("labelReglement");
		tva1box.getStyleClass().add("labelReglement");
		totalbox.getStyleClass().add("labelReglement");
		
		venteTableView.getStyleClass().add("table-row-cell");
	  lignesTableView.getStyleClass().add("table-row-cell");
	  rechercherButton.getStyleClass().add("buttonRech");
	  rechercheclientVente.getStyleClass().add("txtfRech");
      recherchebox.setSpacing(15);
	  listVente.setMinWidth(600);
	  detail.setPadding(new Insets(10, 10, 10, 10));
		venteTableView.setMinHeight(580);
		detail.setMinWidth(400);
		lignesTableView.setMinWidth(380);
		
		
		root.setSpacing(10);
		
		  
	}
	private void updateColumns(){
	idColumn.setCellValueFactory(new PropertyValueFactory("id"));
	idColumn.setPrefWidth(200);
	clientColumn.setCellValueFactory(new PropertyValueFactory("client"));
	clientColumn.setPrefWidth(200);
	dateColumn.setCellValueFactory(new PropertyValueFactory("dateV"));
	dateColumn.setPrefWidth(190);
	
	designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
	designationColumn.setPrefWidth(150);
	prixColumn.setCellValueFactory(new PropertyValueFactory("prix"));
	prixColumn.setPrefWidth(80);
	qteVenduColumn.setCellValueFactory(new PropertyValueFactory("qteVendu"));
	qteVenduColumn.setPrefWidth(80);
     stotalColumn.setCellValueFactory(new PropertyValueFactory("stotal"));
     stotalColumn.setPrefWidth(80);
	}

	private void addEvents(){
		venteTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Vente v=venteTableView.getSelectionModel().getSelectedItem();
			handler.getdetail(v);
			
			
		});

		rechercherButton.setOnAction(event->{
		handler.chercherVenteClient();
		updateColumns();
		
		});
		
		}
	public VenteListWimdows(){
		
		
		
		initwindow();
		addEvents();
		addstylesNodes();
		updateColumns();
		addColumnstoTableView();
		
		handler.updateVenteListwindows();
		
		addNodesToPane();
		
		window.show();
	}
}
