package com.epcafes.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
@Getter
@Setter
public class Unidade implements Serializable {
	
	private static final long serialVersionUID = 82375949344894033L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	
	@NotBlank(message="O nome é obrigatório")
	private String nome;
	
	private String contato;
	
	private long tenant_id;
	
}
