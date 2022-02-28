package com.hermes.ciudades.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



public interface Dao<T> {

    
	String getid(String placename) throws SQLException;
    
    List<String> getAll() throws SQLException;
    
    List<String> getplacesbyplacename(String placename) throws SQLException;
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
}
