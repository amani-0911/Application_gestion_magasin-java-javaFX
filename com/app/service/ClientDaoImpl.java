package com.app.service;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.Client;
import com.app.dao.IClientDao;


public class ClientDaoImpl extends AbstractDAO implements IClientDao{
	
	@Override
	public void add(Client c) {
		String sql="insert into client (prenom,nom,tel,email,adresse) values (?,?,?,?,?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, c.getPrenom());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getTel());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public void delete(long id) {
		String sql="delete from client where id=?";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public Client getOne(long id) {
		
		String sql="select* from client where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, id);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 Client c=new Client(rs.getString("prenom"), rs.getString("nom"), rs.getString("tel"), rs.getString("email"), rs.getString("adresse"));
			 return c;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;	
	}

	@Override
	public List<Client> getAll() {
		String sql="select* from client";
		List<Client> list=new ArrayList<Client>();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Client c=new Client(rs.getLong("id"),rs.getString("prenom"), rs.getString("nom"), rs.getString("tel"), rs.getString("email"), rs.getString("adresse"));
			list.add(c);
			}
		} catch (SQLException exp) {
			
			System.out.println(exp.getMessage()); 
		}
		
		return list;
	}

	@Override
	public void updateClient(Client c) {
		 String sql="update client set prenom=?, nom=?, tel=?, email=?, adresse=? where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		    ps.setString(1, c.getPrenom());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getTel());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.setLong(6, c.getId());
		   ps.executeUpdate();
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		
		
	}

	@Override
	public List<Client> getAll(String nom) {
		List<Client> liste=new ArrayList<Client>();
		 String sql="select* from client where nom like ?";
		
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setString(1, nom+"%");
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 
				Client c=new Client(rs.getLong("id"),rs.getString("prenom"), rs.getString("nom"), rs.getString("tel"), rs.getString("email"), rs.getString("adresse"));	
				liste.add(c);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;	 
	}

}
