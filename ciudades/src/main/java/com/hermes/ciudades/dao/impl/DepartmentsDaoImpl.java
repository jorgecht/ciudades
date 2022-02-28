package com.hermes.ciudades.dao.impl;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.activation.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hermes.ciudades.configuration.DatasourceConfig;
import com.hermes.ciudades.dao.Dao;
import com.hermes.domain.Departments;

public class DepartmentsDaoImpl implements Dao<Departments>{

	private SimpleJdbcCall simpleJdbcCall;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String getid(String placename) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();;
		 
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/orcl");
		dataSource.setUsername("ORACLEJ");
		dataSource.setPassword("maskedhero2");
		return dataSource;
		
	}
	
	@Override
	public List<String> getAll() throws SQLException {
		logger.info("hgtgh");
	
		
		
		simpleJdbcCall = new SimpleJdbcCall(dataSource())
				.withProcedureName("LIST_DEP_NAME")
				.withCatalogName("LIST_PLACES")
				.returningResultSet("c_dep_name", new RowMapper<String>() {
					 
		            @Override
		            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	String department = rs.getString("DEP_NAME");
		                 
//		                contact.setId(rs.getInt("id"));
//		                contact.setName(rs.getString("name"));
//		                contact.setEmail(rs.getString("email"));
//		                contact.setAddress(rs.getString("address"));
//		                contact.setTelephone(rs.getString("telephone"));
		                 
		                return department;
		            }
		        });
		
		Map<String, Object> out = simpleJdbcCall.execute(new HashMap<String, Object>(0));
		
	  
		List<String> departments = (List) out.get("c_dep_name");
		//departments = out.get("dep_name");
		  //logger.info(departments.get(0));
//		  logger.info(departments.get(1));
//		  logger.info(departments.get(2));
		return departments;
	}

	@Override
	public void save(Departments t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Departments t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Departments t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getplacesbyplacename(String placename) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
