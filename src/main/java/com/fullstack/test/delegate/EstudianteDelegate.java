package com.fullstack.test.delegate;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.fullstack.test.wsdl.estudiantes.AddEstudianteRequest;
import com.fullstack.test.wsdl.estudiantes.AddEstudianteResponse;
import com.fullstack.test.wsdl.estudiantes.DeleteEstudianteRequest;
import com.fullstack.test.wsdl.estudiantes.DeleteEstudianteResponse;
import com.fullstack.test.wsdl.estudiantes.GetAllEstudiantesRequest;
import com.fullstack.test.wsdl.estudiantes.GetAllEstudiantesResponse;
import com.fullstack.test.wsdl.estudiantes.GetEstudianteByIdRequest;
import com.fullstack.test.wsdl.estudiantes.GetEstudianteByIdResponse;
import com.fullstack.test.wsdl.estudiantes.UpdateEstudianteRequest;
import com.fullstack.test.wsdl.estudiantes.UpdateEstudianteResponse;

public class EstudianteDelegate extends WebServiceGatewaySupport {
	public AddEstudianteResponse addEstudiante(String nombre, String identificacion) {

		AddEstudianteRequest request = new AddEstudianteRequest();
		request.setNombre(nombre);
		request.setIdentificacion(identificacion);

		AddEstudianteResponse response = (AddEstudianteResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/estudiantes", request,
				new SoapActionCallback("http://www.fullstack-test.com/estudiante/AddEstudianteRequest"));

		return response;
	}

	public DeleteEstudianteResponse deleteEstudiante(long id) {

		DeleteEstudianteRequest request = new DeleteEstudianteRequest();
		request.setId(id);

		DeleteEstudianteResponse response = (DeleteEstudianteResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/estudiantes", request,
				new SoapActionCallback("http://www.fullstack-test.com/estudiante/DeleteEstudianteRequest"));

		return response;
	}

	public GetAllEstudiantesResponse getAllEstudiante() {

		GetAllEstudiantesRequest request = new GetAllEstudiantesRequest();

		GetAllEstudiantesResponse response = (GetAllEstudiantesResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/estudiantes", request,
				new SoapActionCallback("http://www.fullstack-test.com/estudiante/GetAllEstudiantesRequest"));

		return response;
	}

	public GetEstudianteByIdResponse getEstudiante(long estuidanteID) {

		GetEstudianteByIdRequest request = new GetEstudianteByIdRequest();
		request.setEstudianteId(estuidanteID);

		GetEstudianteByIdResponse response = (GetEstudianteByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/estudiantes", request,
				new SoapActionCallback("http://www.fullstack-test.com/estudiante/GetEstudianteByIdRequest"));

		return response;
	}

	public UpdateEstudianteResponse updateEstudiante(long id, String nombre, String identificacion) {

		UpdateEstudianteRequest request = new UpdateEstudianteRequest();
		request.setId(id);
		request.setNombre(nombre);
		request.setIdentificacion(identificacion);

		UpdateEstudianteResponse response = (UpdateEstudianteResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/estudiantes", request,
				new SoapActionCallback("http://www.fullstack-test.com/estudiante/UpdateEstudianteRequest"));

		return response;
	}
}
