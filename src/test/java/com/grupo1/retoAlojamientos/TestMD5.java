package com.grupo1.retoAlojamientos;

import static org.junit.Assert.*;

import org.junit.Test;

import TratamientoDatos.TratarMD5;

public class TestMD5 {

	@Test
	public void test() {
		TratarMD5 tratar = new TratarMD5();
		
		assertEquals(tratar.stringToMD5("perro"), "d44b121fc3524fe5cdc4f3feb31ceb78");
	}

}
