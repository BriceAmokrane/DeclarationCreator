package com.projetmipih.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "declarations")
public class Declaration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom_employe")
	private String nomEmploye;
	
	@Column(name = "prenom_employe")
	private String prenomEmploye;
	
	@Column(name = "date_declaration")
	private Date date;
	
	private String intitule;
	
	@Column(length = 4000)
	private String contenu;

	
}
