package com.app.dao;

public interface IChequeDao {
   public void add(Cheque c);
   public Cheque getOne(Long id);
   public void delete(long id);
   public Cheque getOne(String numéro);
}
