package com.pragma;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.pragma.model.Client;
import com.pragma.request.ClientRequest;

public class Handler implements RequestHandler<ClientRequest, Object> {
	
	private AmazonDynamoDB db;
	private DynamoDBMapper mapper;

	@Override
	public Object handleRequest(ClientRequest request, Context context) {
		db = AmazonDynamoDBClientBuilder.defaultClient();
		mapper = new DynamoDBMapper(db);
		Client client = null;

		switch (request.getHttpMethod()) {
		case "GET":
			if (request.getId() == 0) {
				List<Client> clients = new ArrayList<>();
				clients = mapper.scan(Client.class, new DynamoDBScanExpression());
				return clients;
			} else {
				client = mapper.load(Client.class, request.getId());
				return client;
			}
		case "POST":
			client = request.getClient();
			mapper.save(client);
			return client;
		case "DELETE":
			client = mapper.load(Client.class, request.getId());
			if (client != null)
				mapper.delete(client);
			return client;
		}
		return null;
	}
	
}
