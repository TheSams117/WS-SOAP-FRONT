package com.fullstack.test.delegate;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.fullstack.test.wsdl.materias.AddMateriaRequest;
import com.fullstack.test.wsdl.materias.AddMateriaResponse;
import com.fullstack.test.wsdl.materias.DeleteMateriaRequest;
import com.fullstack.test.wsdl.materias.DeleteMateriaResponse;
import com.fullstack.test.wsdl.materias.GetAllMateriasRequest;
import com.fullstack.test.wsdl.materias.GetAllMateriasResponse;
import com.fullstack.test.wsdl.materias.GetMateriaByIdRequest;
import com.fullstack.test.wsdl.materias.GetMateriaByIdResponse;
import com.fullstack.test.wsdl.materias.UpdateMateriaRequest;
import com.fullstack.test.wsdl.materias.UpdateMateriaResponse;

public class MateriaDelegate extends WebServiceGatewaySupport {
	public AddMateriaResponse addMateria(String nombre, String serial) {

		AddMateriaRequest request = new AddMateriaRequest();
		request.setNombre(nombre);
		request.setSerial(serial);

		AddMateriaResponse response = (AddMateriaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/materias", request,
				new SoapActionCallback("http://www.fullstack-test.com/materia/AddMateriaRequest"));

		return response;
	}

	public DeleteMateriaResponse deleteMateria(long id) {

		DeleteMateriaRequest request = new DeleteMateriaRequest();
		request.setId(id);

		DeleteMateriaResponse response = (DeleteMateriaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/materias", request,
				new SoapActionCallback("http://www.fullstack-test.com/materia/DeleteMateriaRequest"));

		return response;
	}

	public GetAllMateriasResponse getAllMaterias() {

		GetAllMateriasRequest request = new GetAllMateriasRequest();

		GetAllMateriasResponse response = (GetAllMateriasResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/materias", request,
				new SoapActionCallback("http://www.fullstack-test.com/materia/GetAllMateriasRequest"));

		return response;
	}

	public GetMateriaByIdResponse getMateria(long estuidanteID) {

		GetMateriaByIdRequest request = new GetMateriaByIdRequest();
		request.setMateriaId(estuidanteID);

		GetMateriaByIdResponse response = (GetMateriaByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/materias", request,
				new SoapActionCallback("http://www.fullstack-test.com/materia/GetMateriaByIdRequest"));

		return response;
	}

	public UpdateMateriaResponse updateMateria(long id, String nombre, String serial) {

		UpdateMateriaRequest request = new UpdateMateriaRequest();
		request.setId(id);
		request.setNombre(nombre);
		request.setSerial(serial);

		UpdateMateriaResponse response = (UpdateMateriaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/materias", request,
				new SoapActionCallback("http://www.fullstack-test.com/materia/UpdateMateriaRequest"));

		return response;
	}

}
