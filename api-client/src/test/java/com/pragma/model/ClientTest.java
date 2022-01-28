package com.pragma.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pragma.model.entity.Client;

import static com.pragma.Data.CLIENT;

@ExtendWith(MockitoExtension.class)
public class ClientTest {
	
	Client client;
	
	@BeforeEach 
	void before() {
		client = CLIENT;
	}
	
	@Tag("id")
	@ParameterizedTest(name = "Prueba {index} cliente con el id {0}.")
	@ValueSource(longs = { 12L, 22L, 32L, 42L, 52L })
	@DisplayName("Prueba el id del cliente.")
	void id(Long value) {	
		client.setId(value);
		
		assertEquals(value, client.getId());
	}

	@Tag("name")
	@ParameterizedTest(name = "Prueba {index} cliente con el nombre {0}.")
	@CsvSource({ "Sergio", "Claudia", "Jhonatan", "Javier", "Patricia" })
	@DisplayName("Prueba el nombre del cliente.")
	void name(String name) {
		client.setName(name);
		
		assertEquals(name, client.getName());
	}
	
	@Tag("subname")
	@ParameterizedTest(name = "Prueba {index} cliente con el apellido {0}.")
	@CsvSource({ "Buitrago", "Barrios", "Hernandez", "Mendoza", "Garcia" })
	@DisplayName("Prueba el apellido del cliente.")
	void subname(String subname) {
		client.setSubname(subname);
		
		assertEquals(subname, client.getSubname());
	}
	
	@Tag("type")
	@ParameterizedTest(name = "Prueba {index} cliente con el tipo de documento {0}.")
	@CsvSource({ "TI", "CC" })
	@DisplayName("Prueba el tipo de documento del cliente.")
	void type(String type) {
		client.setType(type);
		
		assertEquals(type, client.getType());
	}
	
	@Tag("document")
	@ParameterizedTest(name = "Prueba {index} cliente con el documento {0}.")
	@ValueSource(longs = { 123L, 456L, 789L, 012L, 345L })
	@DisplayName("Prueba el documento del cliente.")
	void document(Long document) {
		client.setDocument(document);;
		
		assertEquals(document, client.getDocument());
	}
	
	@Tag("age")
	@ParameterizedTest(name = "Prueba {index} cliente con la edad {0}.")
	@ValueSource(ints = { 21, 22, 23, 24, 25 })
	@DisplayName("Prueba la edad del cliente.")
	void age(Integer age) {
		client.setAge(age);;
		
		assertEquals(age, client.getAge());
	}
	
	@Tag("city")
	@Test
	@DisplayName("Prueba la ciudad de nacimiento del cliente.")
	void city() {
		client.setCityBirth("Cali");;
		
		assertEquals("Cali", client.getCityBirth());
	}
}
