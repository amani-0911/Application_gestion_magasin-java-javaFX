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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientListWindows {
	ClientListHandler handler =new ClientListHandler(this);
	Stage window=new Stage();
	HBox root =new HBox();
	VBox list =new VBox();
	VBox form =new VBox();
	Scene scene =new Scene(root);
	TableView<Client> clientsTableView=new TableView<Client>();
	ObservableList<Client> clientsobservableList=FXCollections.observableArrayList();
	Label titleLabel =new Label("Listes des clients");
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
	//form
	HBox buttonsBox=new HBox();
	Label ClientIdLabel=new  Label("ID :");
	TextField ClientIdTextField=new TextField();
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

	Button clientUpdateButton= new Button("Modifier",new ImageView(new Image("icons/modifier2.png")));
	Button clientDeleteButton= new Button("Supprimer",new ImageView(new Image("icons/supprimer2.png")));

	

	private void addColumnstoTableView(){
		clientsTableView.getColumns().addAll(idColumn,prenomColumn,nomColumn,telColumn,emailColumn,adresseColumn);
		clientsTableView.setItems(clientsobservableList);
	}
	private void addNodesToPane(){
		//form
		
		form.getChildren().addAll(ClientIdLabel,ClientIdTextField);
		form.getChildren().addAll(clientPrenomLabel,clientPrenomTextField);
		  form.getChildren().addAll(clientnomLabel,clientnomTextField);
		  form.getChildren().addAll(clientTelLabel,clientTelTextField);
		   form.getChildren().addAll(clientEmailLabel,clientEmailTextField);
		   form.getChildren().addAll(clientAdresseLabel,clientAdresseTextField);
		   buttonsBox.getChildren().addAll(clientUpdateButton,clientDeleteButton);
		   form.getChildren().add(buttonsBox);
		//
		recherchebox.getChildren().addAll(rechercheLabel,rechercheTextField,rechercherButton);
		list.getChildren().addAll(recherchebox,titleLabel,clientsTableView);
		root.getChildren().addAll(form,list);
	}

	private void initwindow(){
		window.setWidth(1000);
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
		clientPrenomLabel.getStyleClass().add("labelForm");
		clientnomLabel.getStyleClass().add("labelForm");
		clientTelLabel.getStyleClass().add("labelForm");
		clientEmailLabel.getStyleClass().add("labelForm");
		clientAdresseLabel.getStyleClass().add("labelForm");
		form.setMinWidth(300);
		rechercherButton.getStyleClass().add("buttonRech");
		rechercheTextField.getStyleClass().add("txtfRech");
		
		list.setPadding(new Insets(10, 10, 10, 10));
		clientsTableView.setMinHeight(500);
		titleLabel.setMinWidth(list.getWidth());
		recherchebox.setSpacing(15);
		root.setSpacing(10);
		buttonsBox.setSpacing(15);
		buttonsBox.setPadding(new Insets(50, 10, 0, 0));
		buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
		  
	}
	private void updateColumns(){
	idColumn.setCellValueFactory(new PropertyValueFactory("id"));
	idColumn.setPrefWidth(50);
	prenomColumn.setCellValueFactory(new PropertyValueFactory("prenom"));
	prenomColumn.setPrefWidth(90);
	nomColumn.setCellValueFactory(new PropertyValueFactory("nom"));
	nomColumn.setPrefWidth(90);
	telColumn.setCellValueFactory(new PropertyValueFactory("tel"));
	telColumn.setPrefWidth(100);
	emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
	emailColumn.setPrefWidth(150);
	adresseColumn.setCellValueFactory(new PropertyValueFactory("adresse"));
	adresseColumn.setPrefWidth(200);
	

	}

	private void addEvents(){
		clientsTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Client c=clientsTableView.getSelectionModel().getSelectedItem();
			 ClientIdTextField.setText(	c.getId()+"");
			
			 clientPrenomTextField.setText(c.getPrenom());
			   
			clientnomTextField.setText(c.getNom());
	  
			   clientTelTextField.setText(c.getTel());
			   
			  
			   clientEmailTextField.setText(c.getEmail());
			  

			  clientAdresseTextField.setText(c.getAdresse());
			
			
		});
		clientDeleteButton.setOnAction(event->{
				handler.deleteClient();
				updateColumns();
		});
		clientUpdateButton.setOnAction(event->{
		handler.updateClient();
		updateColumns();
		
		});
		rechercherButton.setOnAction(event->{
		handler.chercherClient();
		updateColumns();
		
		});
		
		}
	public ClientListWindows(){
		
		
		
		initwindow();
		addEvents();
		addstylesNodes();
		updateColumns();
		addColumnstoTableView();
		
		handler.updateClientsListwindows();
		
		addNodesToPane();
		
		window.show();
	}
}
