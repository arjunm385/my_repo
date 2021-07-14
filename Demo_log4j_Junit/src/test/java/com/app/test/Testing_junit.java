package com.app.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testing_junit {
		
		@BeforeAll
		public static void helloBeforeAll() {
			System.out.println("im before all");
		}
		@BeforeEach
		public void helloBeforeEach() {
			System.out.println("im before each");
		}
		@Test
		public void test1() {
			System.out.println("im test case 1");
		}
		@Test
		public void test2() {
			System.out.println("im test case 2");
			
		}
		
		@AfterAll
		public static void helloAfterAll() {
			System.out.println("im before all");
		}

	}


