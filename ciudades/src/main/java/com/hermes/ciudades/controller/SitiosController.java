package com.hermes.ciudades.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hermes.ciudades.service.SitiosService;
import com.hermes.domain.Departments;

@Controller
@RestController
@RequestMapping("/listar")
public class SitiosController {

	@Autowired
	private SitiosService sitiosservice;
	
	@GetMapping("/departments")
	public List<String> listardepartaments() throws SQLException{
		return sitiosservice.listardepartamentos();
	}
	
	
	@GetMapping("/provinces")
	public List<String> listarprovinces(@RequestParam("department") String department) throws SQLException{
		
		
		return sitiosservice.listarprovincias(department);
	}
	
	@GetMapping("/districts")
	public List<String> listardistritos(@RequestParam("province") String province) throws SQLException{
		
		
		return sitiosservice.listardistritos(province);
	}

}
