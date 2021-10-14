package com.app.prsentation;

import java.time.LocalDate;


import com.app.dao.Vente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class SelectVentePayer {
	VentetListHandler handler =new VentetListHandler(this);
	Stage window=new Stage();
	VBox root =new VBox();
	Scene scene =new Scene(root);
	TableView<Vente> venteTableView=new TableView<Vente>();
	ObservableList<Vente> VentesobservableList=FXCollections.observableArrayList();
	
	Label titleLabel =new Label("Selectionner un vente:");
	HBox headerRech=new HBox();
	HBox recherchebox=new HBox();
	Label rechercheLabel=new Label("Client:");
	TextField recherchetxtfVente =new TextField();
	
	Button rechercherButton=new Button("rechercher");

	TableColumn<Vente, Long> idColumn=new TableColumn<>("Id");
	TableColumn<Vente, String> clientColumn=new TableColumn<>("client");
	TableColumn<Vente, LocalDate> dateColumn=new TableColumn<>("date");
	TableColumn<Vente, String> etatPaimentColumn=new TableColumn<>("etat de Paiment");
	

	private void addColumnstoTableView(){
		venteTableView.getColumns().addAll(idColumn,clientColumn,dateColumn,etatPaimentColumn);
		venteTableView.setItems(VentesobservableList);
	}
	private void addNodesToPane(){
		//
		recherchebox.getChildren().addAll(rechercheLabel,recherchetxtfVente,rechercherButton);
		
		headerRech.getChildren().add(recherchebox);
		root.getChildren().addAll(titleLabel,recherchebox,venteTableView);
		
	}
	private void initwindow(){
		window.setWidth(800);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("payer un vente");
		window.getIcons().add(new Image("file:icon.png"));

		
	}
	private void addstylesNodes(){
		scene.getStylesheets().add("css/styles.css");
		titleLabel.getStyleClass().add("labelTitle");
		rechercheLabel.getStyleClass().add("labelTotal");
		recherchebox.getStyleClass().add("boxTotal");
		venteTableView.getStyleClass().add("table-row-cell");
		rechercherButton.getStyleClass().add("buttonRech");
		recherchetxtfVente.getStyleClass().add("txtfRech");
		
		root.setPadding(new Insets(10, 10, 10, 10));
		venteTableView.setMinHeight(600);
		titleLabel.setMinWidth(root.getWidth());
		recherchebox.setSpacing(15);
		recherchebox.setAlignment(Pos.CENTER_RIGHT);
		root.setSpacing(10);
		
		  
	}
	private void updateColumns(){
		idColumn.setCellValueFactory(new PropertyValueFactory("id"));
		idColumn.setPrefWidth(90);
		clientColumn.setCellValueFactory(new PropertyValueFactory("client"));
		clientColumn.setPrefWidth(180);
		dateColumn.setCellValueFactory(new PropertyValueFactory("dateV"));
		dateColumn.setPrefWidth(180);
		etatPaimentColumn.setCellValueFactory(new PropertyValueFactory("etatPaiment"));
		etatPaimentColumn.setPrefWidth(150);
	}
	private void addEvents(){
		rechercherButton.setOnAction(event->{
			handler.chercherVenteClientPayer();
			updateColumns();
			
			});
		venteTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Vente v=venteTableView.getSelectionModel().getSelectedItem();
			new ReglementVenteWindow(v);
			
		});
	}
public SelectVentePayer(){
		
		
		
		initwindow();
		addEvents();
		addstylesNodes();
		updateColumns();
		addColumnstoTableView();
		
		handler.updateventesListwindowsSelect();
		
		addNodesToPane();
		
		window.show();
	}
}
