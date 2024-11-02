package com.example.mutantes;


import com.example.mutantes.service.MutantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MutantApplicationTests {

	@Autowired
	private MutantService servicio;

	// Test
	@Test
	public void arrayVacio() {
		String[] adn = {};
		Assumptions.assumeFalse(servicio.isMutant(adn));
	}

	@Test
	public void arrayNxM() {
		String[] adn = {
				"BBBBB",
				"BBBBB",
				"BBBBB",
				"BBBBB"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			servicio.isMutant(adn);
		});
	}

	@Test
	public void arrayNumeros() {
		String[] adn = {
				"5555",
				"5555",
				"5555",
				"5555"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			servicio.isMutant(adn);
		});
	}

	@Test
	public void recibirNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			servicio.isMutant(null);
		});
	}

	@Test
	public void arrayOtrasLetras() {
		String[] adn = {
				"BBBB",
				"HHHH",
				"BBBB",
				"HHHH"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			servicio.isMutant(adn);
		});
	}

	@Test
	public void prueba1() {
		String[] adn = {
				"AAAA",
				"CCCC",
				"TCAG",
				"GGTC"
		};
		Assumptions.assumeTrue(servicio.isMutant(adn));
	}

	@Test
	public void prueba2() {
		String[] adn = {
				"AAAT",
				"AACC",
				"AAAC",
				"CGGG"
		};
		Assumptions.assumeFalse(servicio.isMutant(adn));
	}

	@Test
	public void prueba3() {
		String[] adn = {
				"TGAC",
				"AGCC",
				"TGAC",
				"GGTC"
		};
		Assumptions.assumeTrue(servicio.isMutant(adn));
	}

	@Test
	public void prueba4() {
		String[] adn = {
				"AAAA",
				"AAAA",
				"AAAA",
				"AAAA"
		};
		Assumptions.assumeTrue(servicio.isMutant(adn));
	}

	@Test
	public void prueba5() {
		String[] adn = {
				"TGAC",
				"ATCC",
				"TAAG",
				"GGTC"
		};
		Assumptions.assumeFalse(servicio.isMutant(adn));
	}

	@Test
	public void prueba6() {
		String[] adn = {
				"TCGGGTGAT",
				"TGATCCTTT",
				"TACGAGTGA",
				"AAATGTACG",
				"ACGAGTGCT",
				"AGACACATG",
				"GAATTCCAA",
				"ACTACGACC",
				"TGAGTATCC"
		};
		Assumptions.assumeTrue(servicio.isMutant(adn));
	}


}

