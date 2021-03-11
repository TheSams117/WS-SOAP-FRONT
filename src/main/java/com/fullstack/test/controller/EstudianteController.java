package com.fullstack.test.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

import com.fullstack.test.wsdl.estudiantes.EstudianteData;

@ManagedBean(name = "estudiante", eager = true)
@RequestScoped
@Component
public class EstudianteController {

	private EstudianteData estudiante;
	private String nom = "S";

	public String getNom() {
		return nom;
	}

	public void setEstudiante(EstudianteData estudiante) {
		this.estudiante = estudiante;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
