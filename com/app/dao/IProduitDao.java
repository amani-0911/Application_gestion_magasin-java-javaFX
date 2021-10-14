package com.app.dao;

import java.util.List;

public interface IProduitDao extends IDAO<Produit> {
	public List<Produit> getAll(String des);
	public void updateProduit(Produit p);

}
