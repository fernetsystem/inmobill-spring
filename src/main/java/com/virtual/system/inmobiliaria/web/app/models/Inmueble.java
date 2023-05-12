package com.virtual.system.inmobiliaria.web.app.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="inmuebles")
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name", length = 150, nullable = false)
	private String name;
	@Column(name = "address", length = 500, nullable = false)
	private String address;
	@Column(name = "picture", length = 1200, nullable = true)
	private String picture;
	@Column(name = "price", nullable = false)
	private Double price;
	@Column(name = "dateCreation", nullable = false)
	private LocalDateTime dateCreation;

}
