package com.pragma.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

@Data
@AllArgsConstructor
@Generated
@DynamoDBTable(tableName = "client")
public class Client {

	@DynamoDBHashKey
	private Long id;

	@DynamoDBAttribute
	private String name;

	@DynamoDBAttribute
	private String subname;

	@DynamoDBAttribute
	private String type;

	@DynamoDBAttribute
	private Long document;

	@DynamoDBAttribute
	private Integer age;

	@DynamoDBAttribute
	private String cityBirth;
}
