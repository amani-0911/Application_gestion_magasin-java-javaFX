package com.app.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import com.app.dao.Client;
import com.app.dao.IClientDao;
import com.app.dao.IVenteDao;
import com.app.dao.Ligne;

import com.app.dao.Vente;

public class VenteDaoImpl extends AbstractDAO implements IVenteDao {
   LigneDaoImpl ldao=new LigneDaoImpl();
   IClientDao cdao=new ClientDaoImpl(); 
	@Override
	public void add(Vente v) {
		String sql="insert into vente (id,dateV,id_client,etatPaiment) values (?,?,?,?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setLong(1, v.getId());
			Date date =Date.valueOf(v.getDateV());
			ps.setDate(2, date);
			ps.setLong(3, v.getClient().getId());
			ps.setString(4, "NPAY");
			ps.execute();
			
			
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public void delete(long id) {
		String sql="delete from vente where id=?";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		ldao.deleteAll(id);
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public Vente getOne(long id) {
		String sql="select* from vente where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, id);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 Date date=rs.getDate("dateV");
			Client client=cdao.getOne(rs.getLong("id_client"));
			 Vente v=new Vente(rs.getLong("id"),date.toLocalDate(), client,rs.getString("etatPaiment")) ;
			  
			 return v;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;	
		 
	}

	@Override
	public List<Vente> getAll() {
		 List<Vente> liste=new ArrayList<Vente>();
		 String sql="select* from vente";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Date date=rs.getDate("dateV");
			 Client client=cdao.getOne(rs.getLong("id_client"));
				 Vente v=new Vente(rs.getLong("id"),date.toLocalDate(), client,rs.getString("etatPaiment")) ;
			 liste.add(v);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;
	}

	@Override
	public List<Vente> getAll(Client c) {
		List<Vente> liste=new ArrayList<Vente>();
		
		String sql="select* from vente where id_client=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, c.getId());
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Date date=rs.getDate("dateV");
			 Client client=cdao.getOne(rs.getLong("id_client"));
				 Vente v=new Vente(rs.getLong("id"),date.toLocalDate(), client,rs.getString("etatPaiment")) ;
			 
				 liste.add(v);
			 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;	 
	}
	@Override
	public void updateVente(Vente v) {
		
		 String sql="update vente set dateV=? , id_client=?  where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 Date date =Date.valueOf(v.getDateV());
			ps.setDate(1, date);
			ps.setLong(2, v.getClient().getId());
			ps.execute();
			for (Ligne l : v.getLignes()) {
				ldao.add(l);
				}
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 
	}
	//etat=TRIT|PAYE
	@Override
	public void updateEtatPaiment(Vente v,String etat){
		 String sql="update vente set etatPaiment=?  where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, etat);
			ps.setLong(2, v.getId());
			ps.execute();
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
	} 


}
