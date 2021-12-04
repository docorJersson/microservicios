package com.DoCor.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "solicitud",uniqueConstraints = {@UniqueConstraint(columnNames =  "idPrestamo")})
@Entity(name = "solicitud")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class solicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsolicitud")
	private Integer idSolicitud;

	@Column(columnDefinition = "ENUM")
	private String estado;
	@Column
	private Date fecha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idprestamo")
	@JsonBackReference
	private prestamos prestamos;
	
}
