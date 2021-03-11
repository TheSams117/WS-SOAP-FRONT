package com.fullstack.test;

import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullstack.test.delegate.EstudianteDelegate;

@Component
@ViewScoped
public class HelloBean {

	@Autowired
	private EstudianteDelegate delegate;

	public String getMsg() {
		return delegate.getEstudiante(1).getEstudiante().getNombre() + " - "
				+ delegate.getEstudiante(1).getEstudiante().getIdentificacion();
	}
}