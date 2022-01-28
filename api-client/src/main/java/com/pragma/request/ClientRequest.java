package com.pragma.request;

import com.pragma.model.dto.ClientDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientRequest {
	
	private Long id;
    private String httpMethod;
    private ClientDTO client;
}
