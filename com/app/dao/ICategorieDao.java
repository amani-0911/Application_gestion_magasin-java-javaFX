package com.app.dao;

import java.util.List;

public interface ICategorieDao extends IDAO<Categorie>{
public List<Categorie>  getByName(String intitule);

}
