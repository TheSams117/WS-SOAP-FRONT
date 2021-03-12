package com.fullstack.test.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullstack.test.delegate.EstudianteDelegate;
import com.fullstack.test.wsdl.estudiantes.EstudianteData;

@Component
@ViewScoped
public class EstudianteController {

	@Autowired
	private EstudianteDelegate delegate;

	private EstudianteData estudianteSeleccionado;

	public void addEstudiante() {
		if (estudianteSeleccionado.getId() != 0) {
			delegate.updateEstudiante(estudianteSeleccionado.getId(), estudianteSeleccionado.getNombre(),
					estudianteSeleccionado.getIdentificacion());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante actualizado"));
			PrimeFaces.current().executeScript("PF('manageEstudianteDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form:dt-estudiantes");
		} else {
			delegate.addEstudiante(estudianteSeleccionado.getNombre(), estudianteSeleccionado.getIdentificacion());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante guardado"));
			PrimeFaces.current().executeScript("PF('manageEstudianteDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form:dt-estudiantes");
		}

	}

	public void deleteEstudiante() {
		delegate.deleteEstudiante(estudianteSeleccionado.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante Eliminado"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-estudiantes");
	}

	public List<EstudianteData> getEstudiantes() {
		return delegate.getAllEstudiante().getEstudiante();
	}

	public EstudianteData getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}

	public void nuevoEstudiante() {
		estudianteSeleccionado = new EstudianteData();
	}

	public void setEstudianteSeleccionado(EstudianteData estudianteSeleccionado) {
		this.estudianteSeleccionado = estudianteSeleccionado;
	}

}
