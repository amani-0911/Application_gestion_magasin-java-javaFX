package com.app.service;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

import java.util.Map;


import com.app.dao.ILigneDao;
import com.app.dao.IProduitDao;
import com.app.dao.IVenteDao;
import com.app.dao.Ligne;
import com.app.dao.Produit;
import com.app.dao.Vente;

public class LigneDaoImpl extends AbstractDAO implements ILigneDao {
     IProduitDao pdao=new ProduitDaoImpl();
     

    @Override
	public void add(Ligne l) {
		String sql="insert into ligne (id_vente,id_produit,qteVendu) values (?,?,?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setLong(1, l.getVente().getId());
			ps.setLong(2, l.getProduit().getId());
			ps.setInt(3, l.getQteVendu());
			ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
	}

	@Override
	public void delete(long idv,long idp) {
		String sql="delete from ligne where id_vente=? and id_produit=?";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, idv);
		ps.setLong(2, idp);
		ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	

	
	@Override
	public Map<Long,Ligne> getAll(Long idVente) {
	     IVenteDao vdao=new VenteDaoImpl();
		Map<Long,Ligne> liste=new HashMap<Long, Ligne>();
			 String sql="select* from ligne where id_vente=?";
			
			 try{
			 PreparedStatement ps=connection.prepareStatement(sql);
			 ps.setLong(1, idVente);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
				 
				 Produit p=pdao.getOne(rs.getLong("id_produit"));
				 Vente v=vdao.getOne(idVente);
					 Ligne l=new Ligne(rs.getInt("qteVendu"), p, v);
				 liste.put(p.getId(), l);
				 }
			 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
			 return liste;	 
		}

	@Override
	public Ligne getOne(Vente v, Long idp) {
		String sql="select* from ligne where id_vente=?  and id_produit=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, v.getId());
		 ps.setLong(2, idp);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 Produit p=pdao.getOne(rs.getLong("id_produit"));
			 
			Ligne l=new Ligne(rs.getInt("qteVendu"), p, v);
			 return l;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;	
		
	}

	@Override
	public void Update(Ligne l) {
		 String sql="update ligne set qteVendu=? where id_vente=?  and id_produit=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		
			ps.setInt(1, l.getQteVendu());
			ps.setLong(2, l.getVente().getId());
			ps.setLong(3, l.getProduit().getId());
			ps.execute();
			
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		
	}

	@Override
	public void deleteAll(long id) {
		String sql="delete from ligne where id_vente=? ";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, id);
	
		ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
	}
	

	

	
	
}
