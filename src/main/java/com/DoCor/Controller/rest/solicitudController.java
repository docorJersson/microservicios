package com.DoCor.Controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoCor.Model.solicitud;
import com.DoCor.Services.solicitudService;

@RequestMapping("/solicitud")
@RestController()
public class solicitudController {
	@Autowired
	solicitudService impl;

	@GetMapping("/detail/{dni}")
	public ResponseEntity<solicitud> getConsulta(@PathVariable String dni) {
		return new ResponseEntity<solicitud>(impl.consulta(dni), HttpStatus.OK);

	}
	@GetMapping("{id}")
	public ResponseEntity<solicitud> getById(@PathVariable Integer id) {
		return new ResponseEntity<solicitud>(impl.finSolicitud(id), HttpStatus.OK);
	}

	/**
	 * @GetMapping public Iterable<solicitud> listAll() { List<solicitud> l=new
	 *             ArrayList(); impl.findAll().forEach(l::add);
	 *             l.forEach(System.out::println); return l;
	 * 
	 *             }
	 **/
}
