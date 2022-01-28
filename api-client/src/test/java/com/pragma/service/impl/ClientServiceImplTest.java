package com.pragma.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression; 
import com.pragma.model.Client;

import static com.pragma.Data.CLIENT;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
	
	@Mock
	DynamoDBMapper mapper;
	
	@Mock
	DynamoDBScanExpression scan;
	
	@InjectMocks
	ClientServiceImpl service;

	@Tag("get")
	@Tag("find")
	@Nested
	@DisplayName("Clase que permite consultar por un condicion y trae un resultado.")
	class ClientServiceImplTestFindBy{
		
		@Test
		@DisplayName("Consultar por el id.")
		void findById() {
			when(mapper.load(Client.class, 1L)).thenReturn(CLIENT);
			
			Client client = service.findById(1L);
			
			assertEquals(CLIENT.getId(), client.getId());
			assertEquals(CLIENT, client);
			
			verify(mapper, timeout(1)).load(Client.class, 1L);
		}
	}
	
	@Tag("get")
	@Tag("findAll")
	@Nested
	@DisplayName("Clase que permite consultar por un condicion y trae varios resultados.")
	class ClientServiceImplTestFindAll{
		
		@Test
		@DisplayName("Consultar por todos los usuarios.")
		void findAll() {
			when(mapper.scan(Client.class, new DynamoDBScanExpression())).thenReturn(null);
			
			service.findAll();
			
			verify(mapper, never()).scan(Client.class, scan);
		}
	}
	
	@Tag("post")
	@Tag("save")
	@Nested
	@DisplayName("Clase que permite registrar cliente.")
	class ClientServiceImplTestSave{
		
		@Test
		@DisplayName("Premite registrar un cliente.")
		void save() {
			verify(mapper, never()).save(CLIENT);
		}
	}
}
