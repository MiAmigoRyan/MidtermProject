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

class TrainTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Train train;

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
		train = em.find(Train.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		train = null;
	}

	@Test
	void test_Train_basic_mappings() {
		assertNotNull(train);
		assertEquals("Georgetown Loop Railroad", train.getName());
	}

	@Test
	void test_Train_to_RailGauge_OneToOne_Mapping() {
		assertNotNull(train);
		assertEquals("Narrow Gauge", train.getRailGauge().getType());
	}

	@Test
	void test_Train_to_Engine_ManyToMany_Mapping() {
		assertNotNull(train);
		assertTrue(train.getEngines().size()>0);
	}

	@Test
	void test_Train_to_User_ManyToOne_Mapping() {
		assertNotNull(train);
		assertEquals("admin", train.getUser().getUsername());
	}

	@Test
	void test_Train_to_Amenity_ManyToMany_Mapping() {
		assertNotNull(train);
		assertNotNull(train.getAmenities());
	}

	@Test
	void test_Train_to_User_ManyToMany_Mapping_WishList() {
		train = em.find(Train.class, 3);
		assertNotNull(train);
		assertNotNull(train.getUsers());
		assertTrue(train.getUsers().size() > 0);
	}

	@Test
	void test_Train_to_Comment_ManyToOne_Mapping() {
		assertNotNull(train);
		assertTrue(train.getTrainComments().size() > 0);
	}
	@Test
	void test_Train_to_Route_OneToMany_Mapping() {
		assertNotNull(train);
		assertTrue(train.getRoutes().size() > 0);
	}
}
