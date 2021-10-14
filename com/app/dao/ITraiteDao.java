package com.app.dao;

import java.util.List;

public interface ITraiteDao extends IDAO<Traite>  {
  public List <Traite> getAll(Vente v);
}
