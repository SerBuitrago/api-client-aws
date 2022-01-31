package com.pragma.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.pragma.mapper.IClientMapper;
import com.pragma.model.dto.ClientDTO;
import com.pragma.model.entity.Client;

public class ClientMapperImpl implements IClientMapper {
	
	@Override
	public Client toEntity(ClientDTO clientDTO) {
		if (clientDTO == null)
			return null;
		Client client = new Client();
		client.setId(clientDTO.getId());
		client.setName(clientDTO.getName());
		client.setSubname(clientDTO.getSubname());
		client.setType(clientDTO.getType());
		client.setDocument(clientDTO.getDocument());
		client.setAge(clientDTO.getAge());
		client.setCityBirth(clientDTO.getCityBirth());
		return client;
	}

	@Override
	public List<Client> toEntityList(List<ClientDTO> clientDTOs) {
		List<Client> clients = new ArrayList<>();
		for (ClientDTO clientDTO : clientDTOs)
			clients.add(toEntity(clientDTO));
		return clients;
	}

	@Override
	public ClientDTO toDto(Client client) {
		if (client == null)
			return null;
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(client.getId());
		clientDTO.setName(client.getName());
		clientDTO.setSubname(client.getSubname());
		clientDTO.setType(client.getType());
		clientDTO.setDocument(client.getDocument());
		clientDTO.setAge(client.getAge());
		clientDTO.setCityBirth(client.getCityBirth());
		return clientDTO;
	}

	@Override
	public List<ClientDTO> toDtoList(List<Client> clients) {
		List<ClientDTO> clientDTOs = new ArrayList<>();
		for (Client client : clients)
			clientDTOs.add(toDto(client));
		return clientDTOs;
	}
}
