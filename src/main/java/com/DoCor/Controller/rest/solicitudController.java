package com.DoCor.Controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoCor.Model.solicitud;
import com.DoCor.Repository.solicitudRepository;

@RequestMapping("/solicitud")
@RestController()
public class solicitudController {
	@Autowired
	solicitudRepository impl;
	
	@PostMapping
	public void save(@RequestBody solicitud solicitud)
	{
		impl.save(solicitud);
	}
	
	@GetMapping
	public Iterable<solicitud> listAll()
	{
		List<solicitud> l=new ArrayList();
		impl.findAll().forEach(l::add);
		l.forEach(System.out::println);
		return l;
		
	}
}
