package com.pragma;

import java.util.Arrays;
import java.util.List;

import com.pragma.model.Client;

public class Data {
	public static final Client CLIENT = new Client(1L, "Sergio Stives", "Barrios Buitrago", "CC", 1010058716L, 21,
			"Cali");

	public static final List<Client> LIST_CLIENTS = Arrays.asList(CLIENT,
			new Client(1L, "Jhonatan Javier", "Barrios Buitrago", "CC", 10100232L, 22, "Bucaramanga"),
			new Client(2L, "Claudia", "Buitrago", "CC", 60358816L, 52, "Cucuta"));
}
