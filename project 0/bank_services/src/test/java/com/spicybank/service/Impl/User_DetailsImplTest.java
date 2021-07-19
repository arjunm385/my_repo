package com.spicybank.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.spicybank.exceptions.BusinessException;
import com.spicybank.service.User_Details;

class User_DetailsImplTest {
	
	public static User_Details service;
	
	
	@BeforeAll
	public static void setup() {	
		service = new User_DetailsImpl();
	}

	@Test
	void testGetUserNameByAccountForValid() {
		
		try {
			assertEquals("payal", service.getUserNameByAccount(7000003));
		} catch (BusinessException e) {
			fail("test case failed");
		}
		
	}
	
	@Test
void testGetUserNameByAccountForFalse() {
		
		try {
			assertTrue("payal".equals(service.getUserNameByAccount(7000003)));
		} catch (BusinessException e) {
			fail("test case failed");
		}
	}
	
	
	

}
