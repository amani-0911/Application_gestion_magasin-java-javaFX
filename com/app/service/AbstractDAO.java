package com.app.service;

import java.sql.Connection;

public  abstract class AbstractDAO {
protected Connection connection=SingleConnection.getConnection();
}
