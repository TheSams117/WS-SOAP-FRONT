package com.fullstack.test.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullstack.test.delegate.MateriaDelegate;
import com.fullstack.test.delegate.MatriculaDelegate;
import com.fullstack.test.wsdl.materias.MateriaData;
import com.fullstack.test.wsdl.matriculas.EstudianteData;

@Component
@ViewScoped
public class MateriaController {
	@Autowired
	private MateriaDelegate delegate;

	@Autowired
	private MatriculaDelegate delegateMatricula;

	private MateriaData materiaSeleccionado;

	public void addMateria() {
		if (materiaSeleccionado.getId() != 0) {
			delegate.updateMateria(materiaSeleccionado.getId(), materiaSeleccionado.getNombre(),
					materiaSeleccionado.getSerial());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Materia actualizada"));
			PrimeFaces.current().executeScript("PF('manageMateriaDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form:dt-materias");
		} else {
			delegate.addMateria(materiaSeleccionado.getNombre(), materiaSeleccionado.getSerial());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Materia guardada"));
			PrimeFaces.current().executeScript("PF('manageMateriaDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form:dt-materias");
		}

	}

	public void deleteMateria() {
		delegate.deleteMateria(materiaSeleccionado.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Materia Eliminado"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-materias");
	}

	public List<EstudianteData> getEstudiantes() {
		return delegateMatricula.getEstudiantesMateria(materiaSeleccionado.getId()).getEstudiante();
	}

	public List<MateriaData> getMaterias() {
		return delegate.getAllMaterias().getMateria();
	}

	public MateriaData getMateriaSeleccionado() {
		return materiaSeleccionado;
	}

	public void nuevaMateria() {
		materiaSeleccionado = new MateriaData();
	}

	public void setMateriaSeleccionado(MateriaData MateriaSeleccionado) {
		this.materiaSeleccionado = MateriaSeleccionado;
	}
}
