package com.pragma.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PragmaTest {
	
	@Test
	void init() {
		Pragma pragma = new Pragma();
		
		assertNotNull(pragma);
	}

	@ParameterizedTest(name = "Prueba {index} long {0}.")
	@ValueSource(longs = { 12L, 22L, 32L, 42L, 52L })
	@DisplayName("Prueba del long.")
	void isLong(Long value) {
		assertEquals(true, Pragma.isLong(value));
	}
	
	@ParameterizedTest(name = "Prueba {index} long {0}.")
	@ValueSource(longs = { -12L, 0L, -32L, -42L, 0L })
	@DisplayName("Prueba de no es long.")
	void noLong(Long value) {
		assertEquals(false, Pragma.isLong(value));
		assertEquals(false, Pragma.isLong(null));
	}
}
