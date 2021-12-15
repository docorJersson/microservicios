package com.DoCor.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "prestamos")
@Table(name = "prestamos",uniqueConstraints = {@UniqueConstraint(columnNames = "dni")})
@JsonInclude(value = Include.NON_DEFAULT)
public class prestamos{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprestamo"	)
	private Integer idPrestamo;
	
	@Column(unique = true,name = "dni",columnDefinition = "CHAR")
	private String dni;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private float monto;
	@Column(name = "fprestamo",insertable = false)
	private Date fPrestamo;
	@Column(columnDefinition = "ENUM")
	private String periodo;
	@Column(name = "cantidadperiodo")
	private Integer cantidadPeriodo;
	@Column(name = "estadosolicitud",columnDefinition = "ENUM",insertable = false)
	private String estadoSolicitud;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(mappedBy = "prestamos",cascade = CascadeType.ALL,targetEntity = solicitud.class)
	private solicitud solicitud;

	public prestamos(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public prestamos(Integer idPrestamo, String dni, String nombre, String apellidos, String phone, String email,
			float monto, Date fPrestamo, String periodo, Integer cantidadPeriodo) {
		super();
		this.idPrestamo = idPrestamo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.phone = phone;
		this.email = email;
		this.monto = monto;
		this.fPrestamo = fPrestamo;
		this.periodo = periodo;
		this.cantidadPeriodo = cantidadPeriodo;
	}
	
	
	
	
	
	

}
