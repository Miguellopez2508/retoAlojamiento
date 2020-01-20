package com.grupo1.retoAlojamientos;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import TratamientoDatos.DescargaXml;

public class DescargaXmlTest {

	DescargaXml descargarXml = new DescargaXml();
	
	@Test
	public void test() throws IOException {
		String campings = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/campings_de_euskadi/opendata/alojamientos.xml";
		
		assertTrue(descargarXml.descargarXml(campings, "campingsTest.xml"));
		assertFalse(descargarXml.descargarXml("marca.com", "campingsTest.xml"));
		assertTrue(descargarXml.descargarXml("http://marca.com", "campingsTest.xml"));
	}

}
