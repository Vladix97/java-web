package com.social.repositories;

import com.social.entities.Bike;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class BikeRepositoryTest {

    private static final String MODEL = "BMX";
    private static final int GEARS = 11;
    private static final int EXPECTED_SIZE = 1;

    @Autowired
    private TestEntityManager em;

    @Autowired
    private BikeRepository bikeRepository;

    @Before
    public void setUp() {
        Bike bike = new Bike();
        bike.setModel(MODEL);
        bike.setGears(GEARS);
        this.em.persist(bike);
    }

    @Test
    public void findBikeWithMoreThan10GearsGivenValidBike_ShouldReturnBike() {
        List<Bike> bikes = this.bikeRepository.findBikesWithMoreThan10Gears();

        assertEquals(EXPECTED_SIZE, bikes.size());

        Bike bike = bikes.get(0);
        assertEquals(MODEL, bike.getModel());
        assertEquals(GEARS, bike.getGears());
    }

}