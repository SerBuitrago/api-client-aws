package com.pragma;

import java.util.Arrays;
import java.util.List;

import com.pragma.model.dto.ClientDTO;
import com.pragma.model.entity.Client;
import com.pragma.request.ClientRequest;

public class Data {
	
	public static final ClientDTO CLIENT = new ClientDTO(1L, "Sergio Stives", "Barrios Buitrago", "CC", 1010058716L, 21,
			"Cali");
	public static final Client CLIENT_ENTITY = new Client(1L, "Sergio Stives", "Barrios Buitrago", "CC", 1010058716L, 21,
			"Cali");
	
	public static final ClientRequest CLIENT_REQUEST = new ClientRequest(1L, "GET", CLIENT);

	public static final List<ClientDTO> LIST_CLIENTS = Arrays.asList(CLIENT,
			new ClientDTO(1L, "Jhonatan Javier", "Barrios Buitrago", "CC", 10100232L, 22, "Bucaramanga"),
			new ClientDTO(2L, "Claudia", "Buitrago", "CC", 60358816L, 52, "Cucuta"));
	public static final List<Client> LIST_CLIENTS_ENTITY = Arrays.asList(CLIENT_ENTITY,
			new Client(1L, "Jhonatan Javier", "Barrios Buitrago", "CC", 10100232L, 22, "Bucaramanga"),
			new Client(2L, "Claudia", "Buitrago", "CC", 60358816L, 52, "Cucuta"));
}
