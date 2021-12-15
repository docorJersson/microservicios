package com.DoCor.Controller.rest.Vista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoCor.Model.Vista.VistaList;
import com.DoCor.Services.Vista.VistaListService;

@RestController
@RequestMapping("/api/xml/list")
public class VistaListController {

	@Autowired
	private VistaListService service;

	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<VistaList> list() {
		return service.list();
	}
	
	
}
