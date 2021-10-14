package com.app.dao;

import java.util.List;

public interface IClientDao extends IDAO<Client> {
	public void updateClient(Client c);
	public List<Client> getAll(String nom );
}
