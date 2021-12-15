package com.DoCor.Model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "solicitud",uniqueConstraints = {@UniqueConstraint(columnNames =  "idPrestamo")})
@Entity(name = "solicitud")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@JsonInclude(Include.NON_NULL)
public class solicitud {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsolicitud")
	private Integer idSolicitud;

	@Column(columnDefinition = "ENUM")
	private String estado;
	@Column
	private Date fecha;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = prestamos.class)
	@JoinColumn(name="idprestamo")
	private prestamos prestamos;

	public solicitud(String estado, String dni,String nombre,String apellido) {
		this.estado = estado;
		this.prestamos = new prestamos(dni, nombre, apellido);
	}
	
	
	
}
