package com.app.prsentation;

import java.time.LocalDate;

import com.app.dao.Cheque;


import com.app.dao.Traite;
import com.app.dao.Vente;

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

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormPayerTraiteVente {
	
	PayerTraiteVentehandler handler =null;
	
	Stage window=new Stage();
	HBox root =new HBox();
	VBox list =new VBox();
	VBox form =new VBox();
	Scene scene =new Scene(root);
	TableView<Traite> traitesTableView=new TableView<Traite>();
	
	ObservableList<Traite> traitesobservableList=FXCollections.observableArrayList();
		
	//form Payer
	Label titleLabelform =new Label("Vente:");
	HBox buttonsBox=new HBox();
	//ligne1
	HBox venteIDBox=new HBox();
	Label venteIdLabel=new  Label("Numero de vente :");
	Label venteIdtvalue=new Label();
	//ligne2
	HBox venteclientBox=new HBox();
	Label venteClientLabel=new  Label("Client : ");
	Label ClientNomLabel=new  Label();
  //ligne3
	HBox ventedatetBox=new HBox();
	Label venteDateLabel=new  Label("Date : ");
	Label venteDateValue=new Label();
	
	
	//Traite description
	VBox detail=new VBox();
	//cheque
	Label chequedetailtitle=new Label("detail de cheque");
	HBox traitechequeMontantBox=new HBox();
	Label traitechequeMontantLabel=new  Label("Montant: ");
	TextField traitechequeMontantTextField=new TextField();
	
	HBox traitechequePropriétaireBox=new HBox();
	Label traitechequePropriétaireLabel=new  Label("Propriétaire:");
	TextField traitechequePropriétaireField=new TextField();
	
	HBox traitechequebanqueBox=new HBox();
	Label traitechequebanqueLabel=new  Label("Banque:");
	TextField traitechequebanqueTextField=new TextField();

	HBox traitechequeNumeroBox=new HBox();
	Label traitechequeNumeroLabel=new  Label("Numéro:");
	TextField traitechequeNumeroTextField=new TextField();
	//date de traite
	HBox traitedateBox=new HBox();
	Label traitedateBLabel=new  Label("Date:");
	DatePicker traitedatePicker=new DatePicker();
	
	 HBox traiteSaveBox=new HBox();
	 Button saveTraiteButton= new Button("Enregestrer");


	 //ligne + reglement
	Label titleLabellisttotal=new Label("Reglement de commande");
	 HBox totalVentebox=new HBox();
		Label totalVenteLabel=new Label("Total de vente :");
		Label totalVenteLabelValue=new Label("0.0");
	HBox totalPayerbox=new HBox();
	Label totalpayerLabel=new Label("Total paye:");
	Label totalpayerLabelValue=new Label("0.0");
	
	HBox totalNonPayerbox=new HBox();
	Label totalNonLabel=new Label("Total non paye:");
	Label totalNonLabelValue=new Label("0.0");
	// table des traite
	
	Label titleLabellistTraites=new Label("Traites de Vente");
	
	TableColumn<Traite, Long> idColumn=new TableColumn<>("Id");
	TableColumn<Traite, LocalDate> dateColumn=new TableColumn<>("Date");
	TableColumn<Traite, Cheque> MontantColumn=new TableColumn<>("Montant");
	
		
	private void addColumnstoTableView(){
		traitesTableView.getColumns().addAll(idColumn,dateColumn,MontantColumn);
		traitesTableView.setItems(traitesobservableList);
	 
	}
	private void addNodesToPane(){
		//form
		venteIDBox.getChildren().addAll(venteIdLabel,venteIdtvalue);
	 venteclientBox.getChildren().addAll(venteClientLabel,ClientNomLabel);
	ventedatetBox.getChildren().addAll(venteDateLabel,venteDateValue);
	
		form.getChildren().addAll(titleLabelform,venteIDBox,venteclientBox,ventedatetBox,titleLabellistTraites,traitesTableView);
		
		//list
		
		totalVentebox.getChildren().addAll(totalVenteLabel,totalVenteLabelValue);
		totalPayerbox.getChildren().addAll(totalpayerLabel,totalpayerLabelValue);
		totalNonPayerbox.getChildren().addAll(totalNonLabel,totalNonLabelValue);
		
		traiteSaveBox.getChildren().add(saveTraiteButton);
		
		traitechequeMontantBox.getChildren().addAll(traitechequeMontantLabel,traitechequeMontantTextField);
		traitechequePropriétaireBox.getChildren().addAll(traitechequePropriétaireLabel,traitechequePropriétaireField);
		traitechequebanqueBox.getChildren().addAll(traitechequebanqueLabel,traitechequebanqueTextField);
		traitechequeNumeroBox.getChildren().addAll(traitechequeNumeroLabel,traitechequeNumeroTextField);
		traitedateBox.getChildren().addAll(traitedateBLabel,traitedatePicker);
		detail.getChildren().addAll(chequedetailtitle,traitechequeMontantBox,traitechequePropriétaireBox,traitechequebanqueBox,traitechequeNumeroBox,traitedateBox);
		list.getChildren().addAll(titleLabellisttotal,totalVentebox,totalPayerbox,totalNonPayerbox,detail,traiteSaveBox);

		root.getChildren().addAll(form,list);
	}

	private void initwindow(){
		window.setWidth(1020);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("Reglement de vente");
		window.getIcons().add(new Image("file:icon.png"));

		
	}
	private void addstylesNodes(){
		scene.getStylesheets().add("css/styles.css");
		titleLabelform.getStyleClass().add("labelTitle");
		titleLabellisttotal.getStyleClass().add("labelTitle");
		titleLabellistTraites.getStyleClass().add("labelTitle");
		chequedetailtitle.getStyleClass().add("labelTitle");
		titleLabelform.setPrefWidth(500);
		titleLabellisttotal.setPrefWidth(500);
		titleLabellistTraites.setPrefWidth(500);
		chequedetailtitle.setPrefWidth(500);
		venteIdLabel.getStyleClass().add("labelForm");
		venteClientLabel.getStyleClass().add("labelForm");
		venteDateLabel.getStyleClass().add("labelForm");
		traitechequeMontantLabel.getStyleClass().add("labelForm");
		traitechequePropriétaireLabel.getStyleClass().add("labelForm");
		traitechequebanqueLabel.getStyleClass().add("labelForm");
		traitechequeNumeroLabel.getStyleClass().add("labelForm");
		traitedateBLabel.getStyleClass().add("labelForm");
		totalVentebox.getStyleClass().add("labelReglement");
		ClientNomLabel.getStyleClass().add("clientNom");
		venteIdtvalue.getStyleClass().add("clientNom");
		venteDateValue.getStyleClass().add("clientNom");
		totalPayerbox.getStyleClass().add("labelReglement");
		totalNonPayerbox.getStyleClass().add("labelReglement");
		
		traitesTableView.getStyleClass().add("table-row-cell");
	
	
		form.setMinWidth(500);
		list.setPadding(new Insets(0, 10, 10, 10));
		traitesTableView.setMinHeight(480);
		list.setMinWidth(500);
		
		detail.setPadding(new  Insets(10, 0, 10, 0));
		
		root.setSpacing(10);
			
		traitechequeMontantBox.setSpacing(24);
		traitechequeMontantBox.setPadding(new Insets(5));
		traitechequePropriétaireBox.setSpacing(12);
		traitechequePropriétaireBox.setPadding(new Insets(5));
		traitechequebanqueBox.setSpacing(33);
		traitechequebanqueBox.setPadding(new Insets(5));
		traitechequeNumeroBox.setSpacing(28);
		traitechequeNumeroBox.setPadding(new Insets(5));
		traitedateBox.setSpacing(46);
		traitedateBox.setPadding(new Insets(5));
		traiteSaveBox.setAlignment(Pos.BASELINE_RIGHT);
			
	}
	private void updateColumns(){ 

	idColumn.setCellValueFactory(new PropertyValueFactory("id"));
	idColumn.setPrefWidth(90);
	dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
	dateColumn.setPrefWidth(190);
	MontantColumn.setCellValueFactory(new PropertyValueFactory("cheque"));
	MontantColumn.setPrefWidth(120);
	
	

	}

	private void addEvents(){
		saveTraiteButton.setOnAction(event->{
			handler.clickAdd();
			updateColumns();
	});
		
		}

	
  public FormPayerTraiteVente(Vente v){
 handler=new PayerTraiteVentehandler(this,v);
	 
	 initwindow();
	   venteIdtvalue.setText(v.getId()+"");
		ClientNomLabel.setText(v.getClient().getPrenom()+" "+v.getClient().getNom());
		venteDateValue.setText(v.getDateV()+"");
		addEvents();

		addstylesNodes();
		updateColumns();
		addColumnstoTableView();
		
	handler.updatetraitesListwindows();
		
		addNodesToPane();
		
		window.show();

}
}