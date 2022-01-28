package com.pragma.service.impl;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.pragma.mapper.IClientMapper;
import com.pragma.model.dto.ClientDTO;
import com.pragma.model.entity.Client;
import com.pragma.service.IClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService{

	private final DynamoDBMapper mapper;
	private final IClientMapper iClientMapper;
	
	@Override
	public ClientDTO findById(Long id) {
		
		return iClientMapper.toDto(mapper.load(Client.class, id));
	}
	
	@Override
	public List<ClientDTO> findAll(){
		return iClientMapper.toDtoList(mapper.scan(Client.class, new DynamoDBScanExpression()));
	} 
	
	@Override
	public ClientDTO save(ClientDTO client) {
		mapper.save(iClientMapper.toEntity(client));
		return client;
	}
	
	@Override
	public ClientDTO deleteById(Long id) {
		ClientDTO client = findById(id);
		if (client != null)
			mapper.delete(iClientMapper.toEntity(client));
		return client;
	}
}
