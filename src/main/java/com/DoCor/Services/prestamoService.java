package com.DoCor.Services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DoCor.Exception.ResourceNotFoundException;
import com.DoCor.Model.prestamos;
import com.DoCor.Repository.prestamosRepository;

@Service
public class prestamoService {
	@Autowired
	private prestamosRepository prestamosRepository;

	@Transactional
	public prestamos save(prestamos prestamos) {
		return prestamosRepository.save(prestamos);
	}

	public List<prestamos> listAll() {
		List<prestamos> list = new ArrayList<prestamos>();
		prestamosRepository.findAll().forEach(list::add);
		return list;
	}

	public prestamos findById(Integer id) {
		
		return prestamosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("prestamos", "idPrestamo", String.valueOf(id)));
	}
}
