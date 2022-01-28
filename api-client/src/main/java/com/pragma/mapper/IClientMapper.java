package com.pragma.mapper;

import java.util.List;

import com.pragma.model.dto.ClientDTO;
import com.pragma.model.entity.Client;

public interface IClientMapper {
	
	Client toEntity(ClientDTO clientDTO);
	
	List<Client> toEntityList(List<ClientDTO> clientDTOs);
	
	ClientDTO toDto(Client client);
	
	List<ClientDTO> toDtoList(List<Client> clients);
}
