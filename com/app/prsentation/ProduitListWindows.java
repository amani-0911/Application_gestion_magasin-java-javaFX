package com.app.prsentation;

import java.time.LocalDate;


import com.app.dao.Categorie;
import com.app.dao.Produit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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

public class ProduitListWindows {
	prduitListHandler handler =new prduitListHandler(this);
Stage window=new Stage();
HBox root =new HBox();
VBox list =new VBox();
VBox form =new VBox();
Scene scene =new Scene(root);
TableView<Produit> produitsTableView=new TableView<Produit>();
ObservableList<Produit> produitsobservableList=FXCollections.observableArrayList();
Label titleLabel =new Label("Listes des produits");
HBox totalbox=new HBox();
Label totalLabel=new Label("Total:");
Label totalLabelValue=new Label("0.0");
TableColumn<Produit, Long> idColumn=new TableColumn<>("Id");
TableColumn<Produit, String> designationColumn=new TableColumn<>("designation");
TableColumn<Produit, Categorie> categorieColumn=new TableColumn<>("categorie");
TableColumn<Produit, Double> prixColumn=new TableColumn<>("prix");
TableColumn<Produit, Integer> 	qteColumn=new TableColumn<>("qte");
TableColumn<Produit, Double> totalColumn=new TableColumn<>("total");
TableColumn<Produit, LocalDate> dateColumn=new TableColumn<>("date");
//form
HBox buttonsBox=new HBox();
Label produitIdLabel=new  Label("ID :");
TextField produitIdTextField=new TextField();
Label produitDesignationLabel=new  Label("Désignation :");
TextField produitDesignationTextField=new TextField();
Label produitPrixLabel=new  Label("Prix:");
TextField produitPrixTextField=new TextField();

Label produitQuantiteLabel=new  Label(" Quantité:");
TextField produitQuantiteTextField=new TextField();

Label produitDateLabel=new  Label("Date:");
DatePicker produitDatePicker=new DatePicker();

Button produitUpdateButton= new Button("Modifier",new ImageView(new Image("icons/modifier2.png")));
Button produitDeleteButton= new Button("Supprimer",new ImageView(new Image("icons/supprimer2.png")));

 Label produitCategorieLabel=new  Label("Categorie");
 ComboBox<Categorie> combobox=new ComboBox<Categorie>();
 CategoriesHandler categoriesHandler=new CategoriesHandler(combobox);

private void addColumnstoTableView(){
	produitsTableView.getColumns().addAll(idColumn,designationColumn,categorieColumn,prixColumn,qteColumn,totalColumn,dateColumn);
   produitsTableView.setItems(produitsobservableList);
}
private void addNodesToPane(){
	//form
	
	form.getChildren().addAll(produitIdLabel,produitIdTextField);
	form.getChildren().addAll(produitDesignationLabel,produitDesignationTextField);
	  form.getChildren().addAll(produitPrixLabel,produitPrixTextField);
	  form.getChildren().addAll(produitQuantiteLabel,produitQuantiteTextField);
	   form.getChildren().addAll(produitDateLabel,produitDatePicker);
	   form.getChildren().addAll(produitCategorieLabel,combobox);
	   buttonsBox.getChildren().addAll(produitUpdateButton,produitDeleteButton);
	   form.getChildren().add(buttonsBox);
	//
	totalbox.getChildren().addAll(totalLabel,totalLabelValue);
	list.getChildren().addAll(titleLabel,produitsTableView,totalbox);
	root.getChildren().addAll(form,list);
}

private void initwindow(){
	window.setWidth(1000);
	window.setHeight(650);
	window.setScene(scene);
	window.setTitle("liste des produits");
	window.getIcons().add(new Image("file:icon.png"));

	
}
private void addstylesNodes(){
	scene.getStylesheets().add("css/styles.css");
	titleLabel.getStyleClass().add("labelTitle");
	totalLabel.getStyleClass().add("labelTotal");
	totalLabelValue.getStyleClass().add("labelTotal");
	totalbox.getStyleClass().add("boxTotal");
	produitsTableView.getStyleClass().add("table-row-cell");
	 produitDesignationLabel.getStyleClass().add("labelForm");
	   produitPrixLabel.getStyleClass().add("labelForm");
	   produitDateLabel.getStyleClass().add("labelForm");
	   produitQuantiteLabel.getStyleClass().add("labelForm");
	   produitCategorieLabel.getStyleClass().add("labelForm");
	   produitIdLabel.getStyleClass().add("labelForm");
	form.setMinWidth(300);
	list.setPadding(new Insets(10, 10, 10, 10));
	produitsTableView.setMinHeight(500);
	titleLabel.setMinWidth(list.getWidth());
	totalbox.setSpacing(15);
	root.setSpacing(10);
	buttonsBox.setSpacing(15);
	buttonsBox.setPadding(new Insets(50, 10, 0, 0));
	buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
	   combobox.setMaxWidth(180);
}
private void updateColumns(){
idColumn.setCellValueFactory(new PropertyValueFactory("id"));
idColumn.setPrefWidth(50);
designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
designationColumn.setPrefWidth(150);
categorieColumn.setCellValueFactory(new PropertyValueFactory("categorie"));
categorieColumn.setPrefWidth(100);
prixColumn.setCellValueFactory(new PropertyValueFactory("prix"));
prixColumn.setPrefWidth(90);
qteColumn.setCellValueFactory(new PropertyValueFactory("qte"));
qteColumn.setPrefWidth(90);
totalColumn.setCellValueFactory(new PropertyValueFactory("total"));
totalColumn.setPrefWidth(100);
dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
dateColumn.setPrefWidth(80);

}

private void addEvents(){
	produitsTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
		Produit p=produitsTableView.getSelectionModel().getSelectedItem();
		produitIdTextField.setText(	p.getId()+"");
		produitDesignationTextField.setText(p.getDesignation());
		 produitPrixTextField.setText(p.getPrix()+"");
		produitQuantiteTextField.setText(p.getQte()+"");
	   produitDatePicker.setValue(p.getDate());
	   combobox.setValue(p.getCategorie());
		
	});
	produitDeleteButton.setOnAction(event->{
			handler.deleteProduit();
			updateColumns();
	});
	produitUpdateButton.setOnAction(event->{
	handler.updateProduit();
	updateColumns();
	
	});
	}
public ProduitListWindows(){
	
	
	initwindow();
	addEvents();
	addstylesNodes();
	updateColumns();
	addColumnstoTableView();
	
	handler.updateProduitsListwindows();
	
	addNodesToPane();
	
	window.show();
}
}
