package com.social.services;

import com.social.entities.Bike;
import com.social.exceptions.BikeNotFoundException;
import com.social.models.viewModels.BikeViewModel;
import com.social.repositories.BikeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BikeServiceImplTest {

    private static final long VALID_ID = 1;

    private static final String MODEL = "BMX";

    private static final int GEARS = 0;

    private static final int INVALID_ID = -1;

    @Autowired
    private ModelMapper modelMapper;

    @MockBean
    private BikeRepository bikeRepository;

    @Autowired
    private BikeService bikeService;

    @Before
    public void setUp() {
        Bike bike = new Bike();
        bike.setId(VALID_ID);
        bike.setModel(MODEL);
        when(this.bikeRepository.findOne(VALID_ID)).thenReturn(bike);
    }

    @Test
    public void findById_ShouldReturnTheCorrectBike() {
        BikeViewModel bike = this.bikeService.findById(VALID_ID);

        assertEquals(VALID_ID, bike.getId());
        assertEquals(MODEL, bike.getModel());
        assertEquals(GEARS, bike.getGears());
        assertFalse(bike.isSold());
    }

    @Test
    public void findById_ShouldCallRepositoryOnce() {
        this.bikeService.findById(VALID_ID);

        verify(this.bikeRepository, times(1)).findOne(VALID_ID);
    }

    @Test(expected = BikeNotFoundException.class)
    public void findById_InvalidId_ShouldThrowException() {
        this.bikeService.findById(INVALID_ID);
    }
}
