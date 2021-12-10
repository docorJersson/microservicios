package com.DoCor.Model.Vista;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "listWebService")
@Immutable
@Getter
@Setter
@XmlRootElement
public class VistaList {
	@Id
	@Column(name = "idsolicitud", updatable = false, nullable = false)
	
	private Integer idSolicitud;

	@Column(columnDefinition = "CHAR")
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private Float monto;
	
	@Column(columnDefinition = "ENUM")
	private String estadoSolicitud;
	
	@Column
	private Date fecha;

}
