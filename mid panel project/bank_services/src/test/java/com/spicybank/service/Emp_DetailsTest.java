package com.spicybank.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.spicybank.exceptions.BusinessException;
import com.spicybank.service.Impl.Emp_DetailsImpl;

class Emp_DetailsTest {

	private static Emp_Details service;

	@BeforeAll
	public static void setup() {
		service = new Emp_DetailsImpl();
	}

	@Test
	void testCheckEmpUidForValid() {

		try {
			assertEquals(54235, service.checkEmpUid());
		} catch (BusinessException e) {
			fail("Test case Failed");
		}

	}

	@Test
	void testCheckEmpUidForTrue() {
		int id = 2352;
		try {
			assertFalse(id == service.checkEmpUid());
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}

	@Test
	void testCheckEmpUidForFalse() {
		int id = 54235;
		try {
			assertTrue(id == service.checkEmpUid());
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}

	@Test
	void testCheckEmpPasswordForValid() {

		try {
			assertTrue(("admin123").equals(service.checkEmpPassword()));
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}
	
	
	@Test
	void testCheckEmpPasswordForTrue() {
		String s="admin123";
		try {
			assertTrue(s.equals(service.checkEmpPassword()));
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}
	
	
	@Test
	void testCheckEmpPasswordForFalse() {
		String s="Admin123";
		try {
			assertFalse(s.equals(service.checkEmpPassword()));
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}
	

	@Test
	void testGetEmpNameForValid() {
		
		try {
			assertEquals("admin", service.getEmpName());
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}
	
	@Test
	void testGetEmpNameForTrue() {
		try {
			assertTrue(service.getEmpName().equals("admin"));
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}
	
	@Test
	void testGetEmpNameForFalse() {
		try {
			assertFalse(service.getEmpName().equals("Admin"));
		} catch (BusinessException e) {
			fail("Test case Failed");
		}
	}

	

//	@Test
//	void testCheckUserAccountForValid() {
//		
//		try {
//			assertEquals(true, service.checkUserAccount(7000004));
//		} catch (BusinessException e) {
//			fail("Not yet implemented");
//		}
//	}
	
	@Test
	void testCheckUserAccountForNotValid() {
		
		try {
			assertEquals(false, service.checkUserAccount(70000));
		} catch (BusinessException e) {
			fail("Not yet implemented");
		}
	}

	
//
//	@Test
//	void testGetUserIdByAccountForValid() {
//		
//		try {
//			assertEquals(10001, service.getUserIdByAccount(7000001));
//		} catch (BusinessException e) {
//			fail("Not yet implemented");
//		}
//	}
	

	@Test
	void testGetUserIdByAccountForNotValid() {
		
		try {
			assertFalse(10005 == service.getUserIdByAccount(7000001));
		} catch (BusinessException e) {
			fail("Not yet implemented");
		}
	}

}
