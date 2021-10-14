package com.app.dao;


import java.util.Map;

public interface ILigneDao  {
	public  Map<Long,Ligne>  getAll(Long idVente);
	public void delete(long idv,long idp);
	public void deleteAll(long id);
	public void add(Ligne l);
	public Ligne getOne(Vente v,Long idp);
	public void Update(Ligne l);
}
