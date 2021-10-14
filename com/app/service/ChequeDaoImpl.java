package com.app.service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.app.dao.Cheque;
import com.app.dao.IChequeDao;


public class ChequeDaoImpl extends AbstractDAO implements IChequeDao{

	@Override
	public void add(Cheque c) {
		String sql="insert into cheque (montant,propriétaire,banque,nemero) values (?,?,?,?)";
		try{ 
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setDouble(1, c.getMontant());
			ps.setString(2, c.getPropriétaire());
			ps.setString(3,c.getBanque());
			ps.setString(4,c.getNuméro());
			ps.execute();
		}catch(SQLException exp){
			System.out.println(exp.getMessage()); 
		 }
		
	}

	@Override
	public Cheque getOne(Long id) {
		String sql="select* from cheque where id=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setLong(1, id);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			Cheque c=new Cheque(rs.getLong("id"), rs.getDouble("montant"), rs.getString("propriétaire"), rs.getString("banque"), rs.getString("nemero"));
			return c;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;	
	}
	@Override
     public void delete(long id){
    	 String sql="delete from cheque where id=?";
 		try{
 		PreparedStatement ps=connection.prepareStatement(sql);
 		ps.setLong(1, id);
 		ps.execute();
 		}catch(SQLException exp){
 			System.out.println(exp.getMessage()); 
 		 }
     }

	@Override
	public Cheque getOne(String numéro) {
		String sql="select* from cheque where nemero=?";
		 try{
		 PreparedStatement ps=connection.prepareStatement(sql);
		 ps.setString(1, numéro);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			Cheque c=new Cheque(rs.getLong("id"), rs.getDouble("montant"), rs.getString("propriétaire"), rs.getString("banque"), rs.getString("nemero"));
			return c;
		 }
		 }catch(SQLException exp){
				System.out.println(exp.getMessage()); 
			 }
		 return null;
	}
}
