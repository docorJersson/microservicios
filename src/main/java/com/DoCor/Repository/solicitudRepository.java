package com.DoCor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.DoCor.Model.solicitud;

public interface solicitudRepository extends CrudRepository<solicitud, Integer> {

	@Query(value = "select NEW com.DoCor.Model.solicitud(sol.estado, pre.dni, pre.nombre, pre.apellidos) from solicitud sol inner join sol.prestamos pre where pre.dni =:dni")
//	@Query(value = "select sol.estado,pre.dni, pre.nombre, pre.apellidos from solicitud sol inner join sol.prestamos pre where pre.dni =:dni")
	public List<solicitud> findByPrestamos_dni(@Param("dni") String dni);

}
