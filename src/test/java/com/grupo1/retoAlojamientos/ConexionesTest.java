package com.grupo1.retoAlojamientos;

import static org.junit.Assert.*;

import org.junit.Test;

import ConexionesBBDD.SessionFactoryUtil;

public class ConexionesTest {

	@Test
	public void test() {
		SessionFactoryUtil sesion = new SessionFactoryUtil();
		
		
		assertNotEquals(null, sesion.getInstance());
		assertNotEquals(null, SessionFactoryUtil.getInstance());
	}

}
