package com.pragma.service;

import java.util.List;

import com.pragma.model.entity.Client;

public interface IClientService {
	
	Client findById(Long id);
	
	List<Client> findAll();
	
	Client save(Client client);
	
	Client deleteById(Long id);
}
