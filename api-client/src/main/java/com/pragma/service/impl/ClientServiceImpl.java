package com.pragma.service.impl;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.pragma.model.Client;
import com.pragma.service.IClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService{

	private final DynamoDBMapper mapper;
	
	@Override
	public Client findById(Long id) {
		return mapper.load(Client.class, id);
	}
	
	@Override
	public List<Client> findAll(){
		return mapper.scan(Client.class, new DynamoDBScanExpression());
	} 
	
	@Override
	public Client save(Client client) {
		mapper.save(client);
		return client;
	}
	
	@Override
	public Client deleteById(Long id) {
		Client client = mapper.load(Client.class, id);
		if (client != null)
			mapper.delete(client);
		return client;
	}
}
