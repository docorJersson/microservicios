package com.DoCor.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoCor.Exception.ResourceNotFoundException;
import com.DoCor.Model.solicitud;
import com.DoCor.Repository.solicitudRepository;

@Service
public class solicitudService {

	@Autowired
	private solicitudRepository repository;
	
	public solicitud consulta(String dni)
	{
	 List<solicitud> lista=repository.findByPrestamos_dni(dni);
	 solicitud s=lista.get(0);
	 return s;
	}
	
	public solicitud finSolicitud(Integer id)
	{
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("solicitud", "idSolicitud", String.valueOf(id)));
	 
	}

}
