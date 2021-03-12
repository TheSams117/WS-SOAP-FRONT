package com.fullstack.test.delegate;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.fullstack.test.wsdl.matriculas.GetEstudiantesMateriaRequest;
import com.fullstack.test.wsdl.matriculas.GetEstudiantesMateriaResponse;
import com.fullstack.test.wsdl.matriculas.GetMateriasEstudianteRequest;
import com.fullstack.test.wsdl.matriculas.GetMateriasEstudianteResponse;

public class MatriculaDelegate extends WebServiceGatewaySupport {
	public GetEstudiantesMateriaResponse getEstudiantesMateria(long materiaId) {

		GetEstudiantesMateriaRequest request = new GetEstudiantesMateriaRequest();
		request.setMateriaId(materiaId);

		GetEstudiantesMateriaResponse response = (GetEstudiantesMateriaResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/matriculas", request,
						new SoapActionCallback("http://www.fullstack-test.com/matricula/GetEstudiantesMateriaRequest"));

		return response;
	}

	public GetMateriasEstudianteResponse getMateriasEstudiante(long estudianteId) {

		GetMateriasEstudianteRequest request = new GetMateriasEstudianteRequest();
		request.setEstudianteId(estudianteId);

		GetMateriasEstudianteResponse response = (GetMateriasEstudianteResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/matriculas", request,
						new SoapActionCallback("http://www.fullstack-test.com/matricula/GetAllMateriasRequest"));

		return response;
	}
}
