package com.hermes.ciudades.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hermes.ciudades.dao.impl.DepartmentsDaoImpl;
import com.hermes.ciudades.dao.impl.DistrictsDaoImpl;
import com.hermes.ciudades.dao.impl.ProvincesDaoImpl;
import com.hermes.domain.Departments;

@Service
public class SitiosService {
	
	
	
	public List<String> listardepartamentos() throws SQLException{
		DepartmentsDaoImpl departmentsdaoimpl = new DepartmentsDaoImpl();
		return departmentsdaoimpl.getAll();
		
	}
	
	public List<String> listarprovincias(String department) throws SQLException{
		ProvincesDaoImpl provincesdaoimpl = new ProvincesDaoImpl();
		return provincesdaoimpl.getplacesbyplacename(department);
		
	}

	public List<String> listardistritos(String province) throws SQLException {
		DistrictsDaoImpl districtsdaoimpl = new DistrictsDaoImpl();
		return districtsdaoimpl.getplacesbyplacename(province);
	}
	
 
	
	

}
