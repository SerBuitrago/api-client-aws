package com.pragma;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.pragma.request.ClientRequest;
import com.pragma.service.IClientService;
import com.pragma.service.impl.ClientServiceImpl;

import lombok.Generated;

import static com.pragma.util.Pragma.isLong;

@Generated
public class Handler implements RequestHandler<ClientRequest, Object> {

	private AmazonDynamoDB db;
	private DynamoDBMapper mapper;

	@Override
	public Object handleRequest(ClientRequest request, Context context) {
		db = AmazonDynamoDBClientBuilder.defaultClient();
		mapper = new DynamoDBMapper(db);
		IClientService clientService = new ClientServiceImpl(mapper);

		switch (request.getHttpMethod()) {
		case "GET":
			if (!isLong(request.getId())) {
				return clientService.findAll();
			} else {
				return clientService.findById(request.getId());
			}
		case "POST":
			return clientService.save(request.getClient());
		case "DELETE":
			return clientService.deleteById(request.getId());
		}
		return null;
	}
}
