package com.pragma.request;

import com.pragma.model.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
	
	private int id;
    private String httpMethod;
    private Client client;
}
