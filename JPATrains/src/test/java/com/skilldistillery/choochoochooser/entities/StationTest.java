package com.skilldistillery.choochoochooser.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Station station;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPATrains");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		station = em.find(Station.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		station = null;
	}

	@Test
	void test_Station_mapping() {
		assertNotNull(station);
		assertEquals("Georgetown Devil's Gate Station", station.getName());
	}

	@Test
	void test_Station_to_Route_Start_OneToMany_mapping() {
		assertNotNull(station);
		assertTrue(station.getStartRoutes().size() > 0);
	}

	@Test
	void test_Station_to_Route_End_OneToMany_mapping() {
		assertNotNull(station);
		assertTrue(station.getEndRoutes().size() > 0);
	}

}
