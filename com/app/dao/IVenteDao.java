package com.app.dao;


import java.util.List;

public interface IVenteDao extends IDAO<Vente>{
	public List<Vente> getAll(Client c);
	public void updateEtatPaiment(Vente v,String etat);
	public void updateVente(Vente p);
}
