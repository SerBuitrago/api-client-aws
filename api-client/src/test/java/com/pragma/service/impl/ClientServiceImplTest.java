package com.pragma.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
import com.pragma.model.Client;

import static com.pragma.Data.CLIENT;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
	
	@Mock
	DynamoDBMapper mapper;
	
	@InjectMocks
	ClientServiceImpl service;

	@Tag("get")
	@Nested
	@DisplayName("Clase que permite consultar por el id.")
	class ClientServiceImplTestFindById{
		
		@Test
		@DisplayName("Consultar por el id.")
		void findById() {
			when(mapper.load(Client.class, 1L)).thenReturn(CLIENT);
			
			Client client = service.findById(1L);
			
			assertEquals(CLIENT.getId(), client.getId());
			
			verify(mapper, timeout(1)).load(Client.class, 1L);
		}
	}
}
