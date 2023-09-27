package com.epcafes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Talhao{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long tenant_id;
	
	@NotBlank(message="O nome do talhao é obrigatório. ")
	private String nome;
	
	
	private float area;
	
	@OneToOne
	@JoinColumn(name="cod_unidade")
	private Unidade unidade;
}
