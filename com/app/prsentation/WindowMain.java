package com.app.prsentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class WindowMain extends Application {
	    private	BorderPane root= new BorderPane();;
		private Scene scene=new Scene(root);
		MenuItem nouveauProduitsMenuItem= new MenuItem("Nouveau");
		MenuItem listeProduitsMenuItem= new MenuItem("Liste");
		MenuItem nouveauClientsMenuItem= new MenuItem("Nouveau");
		MenuItem listeClientsMenuItem= new MenuItem("Liste");
		MenuItem nouveauVentesMenuItem= new MenuItem("Nouveau");
		MenuItem listeVentesMenuItem= new MenuItem("Liste");
		MenuItem PayerVenteMenuItem=new MenuItem("Payer Vente");
		MenuItem listeHelpMenuItem= new MenuItem("?");
		private void createMenu(){
			MenuBar menuBar =new MenuBar();
			Menu produitsMenu =new Menu("Produits");
			Menu clientsMenu =new Menu("Clients");
			Menu ventesMenu =new Menu("Ventes");
			Menu paiementsMenu =new Menu("Paiements");
			Menu inventaireMenu =new Menu("Inventaire");
			Menu helpMenu =new Menu("Help");
			//Produit
		
			produitsMenu.getItems().addAll(nouveauProduitsMenuItem,listeProduitsMenuItem);
			//Clients
			
			clientsMenu.getItems().addAll(nouveauClientsMenuItem,listeClientsMenuItem);
			//Vente
			ventesMenu.getItems().addAll(nouveauVentesMenuItem,listeVentesMenuItem);
			//paiement
			paiementsMenu.getItems().add(PayerVenteMenuItem);
			//help
		
			helpMenu.getItems().add(listeHelpMenuItem);
			
			
			
			menuBar.getMenus().addAll(produitsMenu,clientsMenu,ventesMenu,paiementsMenu,inventaireMenu,helpMenu);
			root.setTop(menuBar);
		}
		private void addStylesToNodes(){
			scene.getStylesheets().add("css/styles.css");
			root.getStyleClass().add("mainwindow");
			
		   }
		private void addEvents(){
			nouveauProduitsMenuItem.setOnAction(events ->{
				new FormProduitWindow();
			});
			listeProduitsMenuItem.setOnAction(events ->{
				new ProduitListWindows();
			});
			nouveauClientsMenuItem.setOnAction(event ->{
				new FormClientWindow();
			});
			listeClientsMenuItem.setOnAction(events ->{
				new ClientListWindows();
			});
			nouveauVentesMenuItem.setOnAction(events ->{
				new SelectClientVente();
			});
			listeVentesMenuItem.setOnAction(events ->{
				new VenteListWimdows();
			});
			PayerVenteMenuItem.setOnAction(events ->{
				new SelectVentePayer();
			});
		}
		
	@Override
	public void start(Stage window) throws Exception {
		createMenu();
		addEvents();
		addStylesToNodes();
		window.setScene(scene);
		window.setTitle("Gestion de Magasin");
		
		window.setWidth(1000);
		window.setHeight(650);
		window.getIcons().add(new Image("file:icon.png"));
		window.show();
		
		
	}
	public static void main(String[] args)   {
		Application.launch(args);

	}

	

}
