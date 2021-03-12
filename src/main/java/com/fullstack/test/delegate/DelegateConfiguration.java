package com.fullstack.test.delegate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class DelegateConfiguration {
	@Bean
	public EstudianteDelegate estudianteClient(Jaxb2Marshaller marshaller) {
		EstudianteDelegate client = new EstudianteDelegate();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		String[] contextPaths = { "com.fullstack.test.wsdl.materias", "com.fullstack.test.wsdl.estudiantes" };
		marshaller.setContextPaths(contextPaths);
		return marshaller;
	}

	@Bean
	public MateriaDelegate materiaClient(Jaxb2Marshaller marshaller) {
		MateriaDelegate client = new MateriaDelegate();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
