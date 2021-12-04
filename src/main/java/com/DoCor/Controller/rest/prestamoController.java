package com.DoCor.Controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoCor.Model.prestamos;
import com.DoCor.Services.prestamoService;

@RestController
@RequestMapping("/api/prestamos")
public class prestamoController {

	@Autowired
	private prestamoService prestamoService;

	@GetMapping
	public List<prestamos> getAllPrestamos() {
		return prestamoService.listAll();
	}

	@PostMapping
	public ResponseEntity<prestamos> savePrestamo(@RequestBody prestamos prestamos) {
		return new ResponseEntity<prestamos>(prestamoService.save(prestamos), HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<prestamos> getById(@PathVariable int id) {
		return new ResponseEntity<prestamos>(prestamoService.findById(id), HttpStatus.OK);
	}
}
