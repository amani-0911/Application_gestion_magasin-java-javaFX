package com.app.prsentation;

import java.util.List;

import com.app.dao.Categorie;
import com.app.dao.ICategorieDao;
import com.app.service.CategorieDaoImpl;

import javafx.scene.control.ComboBox;

public class CategoriesHandler {
	ICategorieDao cdao=new CategorieDaoImpl();
	ComboBox<Categorie> combobox=null;
	public CategoriesHandler(	
		ComboBox<Categorie> combobox){
		this.combobox=combobox;
		List<Categorie> list= cdao.getAll();
		for (Categorie cat : list) {
			combobox.getItems().add(cat);
		}
	}
	
}
