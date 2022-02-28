package com.hermes.ciudades.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hermes.ciudades.dao.Dao;
import com.hermes.domain.Districts;

public class DistrictsDaoImpl implements Dao<Districts>{
	
	private SimpleJdbcCall simpleJdbcCall;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();;
		 
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/orcl");
		dataSource.setUsername("ORACLEJ");
		dataSource.setPassword("maskedhero2");
		return dataSource;
		
	}

	@Override
	public String getid(String placename) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getplacesbyplacename(String placename) throws SQLException {
		Connection con = dataSource().getConnection();
		logger.info(placename);	
		String query = "SELECT PROVINCES.PROV_COD FROM PROVINCES WHERE PROVINCES.PROV_NAME = '" + placename +"'";
		Statement smt = (Statement) con.createStatement();
		ResultSet rs = smt.executeQuery(query);
		rs.next();
		
		String cod = rs.getString("PROV_COD");
		logger.info(cod);	
		logger.info("provinces");
		
		simpleJdbcCall = new SimpleJdbcCall(dataSource())
				.withProcedureName("LIST_DIS_NAME")
				.withCatalogName("LIST_PLACES")
				.returningResultSet("c_dis_name", new RowMapper<String>() {
					 
		            @Override
		            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	String province = rs.getString("DIS_NAME");
		                return province;
		            }
		        });
		
		SqlParameterSource parametros = new MapSqlParameterSource().addValue("prov_cod", cod);
		
		Map<String, Object> out = simpleJdbcCall.execute(parametros);
		
	  
		List<String> provinces = (List) out.get("c_dis_name");
		return provinces;
	}

	@Override
	public void save(Districts t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Districts t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Districts t) {
		// TODO Auto-generated method stub
		
	}

}
