package com.app.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.app.dao.Cheque;
import com.app.dao.IChequeDao;
import com.app.dao.ITraiteDao;
import com.app.dao.IVenteDao;

import com.app.dao.Traite;
import com.app.dao.Vente;

public class TraiteDaoImpl  extends AbstractDAO implements ITraiteDao {
    IChequeDao chdao=new ChequeDaoImpl();
    IVenteDao vdao=new VenteDaoImpl();
	@Override
	public void add(Traite t) {
		String sql="insert into traite (date,id_vente,id_cheque) values (?,?,?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			Date date =Date.valueOf(t.getDate());
			ps.setDate(1, date);
			ps.setLong(2, t.getVente().getId());
			ps.setLong(3, t.getCheque().getId());
				ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
		
	}

	@Override
	public void delete(long id) {
		String sql="delete from traite where id=?";
		try{
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public Traite getOne(long id) {
		String sql="select* from traite where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, id);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 Date date=rs.getDate("date");
			 Cheque c=chdao.getOne(rs.getLong("id_cheque"));
			 Vente v=vdao.getOne(rs.getLong("id_vente"));
			 Traite t=new Traite(rs.getLong("id"),date.toLocalDate(), v, c);
			 return t;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;
	}

	@Override
	public List<Traite> getAll() {
		List<Traite> liste=new ArrayList<Traite>();
		 String sql="select* from traite";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Date date=rs.getDate("date");
			 Cheque c=chdao.getOne(rs.getLong("id_cheque"));
			 Vente v=vdao.getOne(rs.getLong("id_vente"));
			 Traite t=new Traite(date.toLocalDate(), v, c);
			 liste.add(t);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;
	
	}

	@Override
	public List<Traite> getAll(Vente v) {
		
		List<Traite> liste=new ArrayList<Traite>();
		 String sql="select* from traite where id_vente=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, v.getId());
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 Date date=rs.getDate("date");
			 Cheque c=chdao.getOne(rs.getLong("id_cheque"));
			 Traite t=new Traite(rs.getLong("id"),date.toLocalDate(), v, c);
			 liste.add(t);
		 }
		 }catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		 return liste;
	}

}
