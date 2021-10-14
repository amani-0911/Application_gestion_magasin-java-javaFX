package com.app.prsentation;

import com.app.dao.Client;

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

public class SelectClientVente {
	ClientListHandler handler =new ClientListHandler(this);
	Stage window=new Stage();
	VBox root =new VBox();
	Scene scene =new Scene(root);
	TableView<Client> clientsTableView=new TableView<Client>();
	ObservableList<Client> clientsobservableList=FXCollections.observableArrayList();
	HBox headerRech=new HBox();
	Label titleLabel =new Label("Selectioner un client:");
	HBox recherchebox=new HBox();
	Label rechercheLabel=new Label("client nom:");
	TextField rechercheTextField =new TextField();
	Button rechercherButton=new Button("rechercher");

	TableColumn<Client, Long> idColumn=new TableColumn<>("Id");
	TableColumn<Client, String> prenomColumn=new TableColumn<>("prenom");
	TableColumn<Client, String> nomColumn=new TableColumn<>("nom");
	TableColumn<Client, String> telColumn=new TableColumn<>("tel");
	TableColumn<Client, String> emailColumn=new TableColumn<>("email");
	TableColumn<Client, String> adresseColumn=new TableColumn<>("adresse");
	private void addColumnstoTableView(){
		clientsTableView.getColumns().addAll(idColumn,prenomColumn,nomColumn,telColumn,emailColumn,adresseColumn);
		clientsTableView.setItems(clientsobservableList);
	}
	private void addNodesToPane(){
		//
		recherchebox.getChildren().addAll(rechercheLabel,rechercheTextField,rechercherButton);
		
		headerRech.getChildren().add(recherchebox);
		root.getChildren().addAll(titleLabel,recherchebox,clientsTableView);
		
	}
	private void initwindow(){
		window.setWidth(800);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("liste des clients");
		window.getIcons().add(new Image("file:icon.png"));

		
	}
	private void addstylesNodes(){
		scene.getStylesheets().add("css/styles.css");
		titleLabel.getStyleClass().add("labelTitle");
		rechercheLabel.getStyleClass().add("labelTotal");
		recherchebox.getStyleClass().add("boxTotal");
		clientsTableView.getStyleClass().add("table-row-cell");
		rechercherButton.getStyleClass().add("buttonRech");
		rechercheTextField.getStyleClass().add("txtfRech");
		
		root.setPadding(new Insets(10, 10, 10, 10));
		clientsTableView.setMinHeight(600);
		titleLabel.setMinWidth(root.getWidth());
		recherchebox.setSpacing(15);
		recherchebox.setAlignment(Pos.CENTER_RIGHT);
		root.setSpacing(10);
		
		  
	}
	private void updateColumns(){
	idColumn.setCellValueFactory(new PropertyValueFactory("id"));
	idColumn.setPrefWidth(50);
	prenomColumn.setCellValueFactory(new PropertyValueFactory("prenom"));
	prenomColumn.setPrefWidth(90);
	nomColumn.setCellValueFactory(new PropertyValueFactory("nom"));
	nomColumn.setPrefWidth(90);
	telColumn.setCellValueFactory(new PropertyValueFactory("tel"));
	telColumn.setPrefWidth(150);
	emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
	emailColumn.setPrefWidth(200);
	adresseColumn.setCellValueFactory(new PropertyValueFactory("adresse"));
	adresseColumn.setPrefWidth(200);
	

	}
	private void addEvents(){
		rechercherButton.setOnAction(event->{
			handler.chercherClientVente();
			updateColumns();
			
			});
		clientsTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Client c=clientsTableView.getSelectionModel().getSelectedItem();
			new FormVenteWindow(c);
		});
	}
public SelectClientVente(){
		
		
		
		initwindow();
		addEvents();
		addstylesNodes();
		updateColumns();
		addColumnstoTableView();
		
		handler.updateClientsListwindowsSelect();
		
		addNodesToPane();
		
		window.show();
	}
}
