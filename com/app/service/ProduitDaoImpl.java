package com.app.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.Categorie;
import com.app.dao.ICategorieDao;
import com.app.dao.IProduitDao;
import com.app.dao.Produit;

public class ProduitDaoImpl extends AbstractDAO implements IProduitDao {
    private ICategorieDao cdao=new CategorieDaoImpl();
	@Override
	public void add(Produit p) {
		String sql="insert into produit (designation,prix,qte,date,id_categorie) values (?,?,?,?,?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQte());
			Date date =Date.valueOf(p.getDate());
			ps.setDate(4, date);
			ps.setLong(5, p.getCategorie().getId());
			ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public void delete(long id) {
		String sql="delete from produit where id=?";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public Produit getOne(long id) {
		String sql="select* from produit where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, id);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 Date date=rs.getDate("date");
			Categorie categorie=cdao.getOne(rs.getLong("id_categorie"));
			 Produit p=new Produit(rs.getLong("id"), rs.getString("designation"), rs.getDouble("prix"),rs.getInt("qte"),date.toLocalDate(),categorie);
			 return p;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;	
		 }

	@Override
	public List<Produit> getAll() {
		 List<Produit> liste=new ArrayList<Produit>();
		 String sql="select* from produit";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Date date=rs.getDate("date");
			 Categorie categorie=cdao.getOne(rs.getLong("id_categorie"));
			 Produit p=new Produit(rs.getLong("id"), rs.getString("designation"), rs.getDouble("prix"),rs.getInt("qte"),date.toLocalDate(),categorie);
			 liste.add(p);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;
	}

	@Override
	public List<Produit> getAll(String des) {
		List<Produit> liste=new ArrayList<Produit>();
		 String sql="select* from produit where designation like ?";
		
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setString(1, des+"%");
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Date date=rs.getDate("date");
			 Categorie categorie=cdao.getOne(rs.getLong("id_categorie"));
			 Produit p=new Produit(rs.getLong("id"), rs.getString("designation"), rs.getDouble("prix"),rs.getInt("qte"),date.toLocalDate(),categorie);			 liste.add(p);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;	 
	}

	@Override
	public void updateProduit(Produit pr) {
		 String sql="update produit set designation=? , prix=? , qte=? , date=? , id_categorie=? where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setString(1, pr.getDesignation());
			ps.setDouble(2, pr.getPrix());
			ps.setInt(3, pr.getQte());
			Date date =Date.valueOf(pr.getDate());
			ps.setDate(4, date);
			ps.setLong(5, pr.getCategorie().getId());
		   ps.setLong(6,pr.getId());
		   ps.executeUpdate();
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		
	}

}
