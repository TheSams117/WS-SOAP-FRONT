package com.fullstack.test.delegate;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.fullstack.test.wsdl.estudiantes.GetEstudianteByIdRequest;
import com.fullstack.test.wsdl.estudiantes.GetEstudianteByIdResponse;

public class EstudianteDelegate extends WebServiceGatewaySupport {
	public GetEstudianteByIdResponse getEstudiante(long estuidanteID) {

		GetEstudianteByIdRequest request = new GetEstudianteByIdRequest();
		request.setEstudianteId(estuidanteID);

		GetEstudianteByIdResponse response = (GetEstudianteByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/estudiantes", request,
				new SoapActionCallback("http://www.fullstack-test.com/estudiante/GetEstudianteByIdRequest"));

		return response;
	}
}
