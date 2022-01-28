package com.pragma.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pragma.Data.CLIENT;
import static com.pragma.Data.CLIENT_REQUEST;

@ExtendWith(MockitoExtension.class)
public class ClientRequestTest {

	ClientRequest clientRequest;
	
	@BeforeEach
	void before() {
		clientRequest = CLIENT_REQUEST;
	}
	
	@Tag("id")
	@ParameterizedTest(name = "Prueba {index} cliente request con el id {0}.")
	@ValueSource(longs = { 12L, 22L, 32L, 42L, 52L })
	@DisplayName("Prueba el id del cliente request.")
	void id(Long value) {	
		clientRequest.setId(value);
		
		assertEquals(value, clientRequest.getId());
	}
	
	@Tag("http")
	@Tag("method")
	@ParameterizedTest(name = "Prueba {index} metodo http {0}.")
	@CsvSource({ "GET", "POST", "PUT", "PATH", "DELETE" })
	@DisplayName("Prueba del metodo http.")
	void name(String method) {
		clientRequest.setHttpMethod(method);
		
		assertEquals(method, clientRequest.getHttpMethod());
	}
	
	@Tag("client")
	@Test
	@DisplayName("Prueba cliente.")
	void client() {
		clientRequest.setClient(CLIENT);
		
		assertNotNull(clientRequest.getClient());
		assertEquals(CLIENT.getId(), clientRequest.getClient().getId());
	}
}
