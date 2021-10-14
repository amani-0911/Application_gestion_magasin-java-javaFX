package com.app.service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.Categorie;
import com.app.dao.ICategorieDao;


public class CategorieDaoImpl extends AbstractDAO implements ICategorieDao {

	@Override
	public void add(Categorie c) {
		String sql="insert into categorie (intitule) values (?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, c.getIntitule());
			ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public void delete(long id) {
		String sql="delete from categorie where id=?";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public Categorie getOne(long id) {
		String sql="select* from categorie where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, id);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			Categorie c=new Categorie(rs.getLong("id"), rs.getString("intitule"));
			 return c;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;	
		 }
	

	@Override
	public List<Categorie> getAll() {
		 List<Categorie> liste=new ArrayList<Categorie>();
		 String sql="select* from Categorie";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Categorie c=new Categorie(rs.getLong("id"), rs.getString("intitule"));
			 liste.add(c);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;
	}	

	@Override
	public List<Categorie>  getByName(String inti) {
		List<Categorie> liste=new ArrayList<Categorie> ();
		 String sql="select* from categorie where intitule like ?";
		
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setString(1, '%'+inti+"%");
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Categorie c=new Categorie(rs.getLong("id"), rs.getString("intitule"));
			 liste.add(c);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;	 
	}

}
