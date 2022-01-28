package com.pragma.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.pragma.model.Client;

import static com.pragma.Data.CLIENT;
import static com.pragma.Data.LIST_CLIENTS;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
	
	@Mock
	DynamoDBMapper mapper;
	@Mock
	PaginatedScanList<Client> scanResult;
	
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
		
		@BeforeEach
		void before(){
			scanResult.addAll(LIST_CLIENTS);
		}
		
		@Test
		@DisplayName("Consultar por todos los usuarios.")
		@Disabled
		void findAll() {
			
			when(mapper.scan(Client.class, scan)).thenReturn(scanResult);
			
			List<Client> list = service.findAll();
			
			assertEquals(LIST_CLIENTS.size(), list.size());
			
			verify(mapper, never()).scan(Client.class, scan);
		}
	}
	
	@Tag("post")
	@Tag("save")
	@Nested
	@DisplayName("Clase que permite registrar cliente.")
	class ClientServiceImplTestSave{
		
		@Test
		@DisplayName("Permite registrar un cliente.")
		void save() {
			doNothing().when(mapper).save(CLIENT);
			
			Client client = service.save(CLIENT);
			
			assertEquals(CLIENT.getId(), client.getId());
			
			verify(mapper).save(CLIENT);
		}
	}
	
	@Tag("delete")
	@Nested
	@DisplayName("Clase que permite registrar cliente.")
	class ClientServiceImplTestDelete{
		@Test
		@DisplayName("Permite eliminar un cliente.")
		void deleteById() {
			when(mapper.load(Client.class, 1L)).thenReturn(CLIENT);
			doNothing().when(mapper).delete(CLIENT);
			
			Client client = service.deleteById(1L);
			
			assertEquals(CLIENT.getId(), client.getId());
			
			verify(mapper).delete(CLIENT);
		}
	}
}
