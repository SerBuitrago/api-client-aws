package com.pragma.service;

import java.util.List;

import com.pragma.model.dto.ClientDTO;

public interface IClientService {
	
	ClientDTO findById(Long id);
	
	List<ClientDTO> findAll();
	
	ClientDTO save(ClientDTO client);
	
	ClientDTO deleteById(Long id);
}
