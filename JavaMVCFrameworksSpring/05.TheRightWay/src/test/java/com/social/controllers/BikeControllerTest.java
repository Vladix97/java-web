package com.social.controllers;

import com.social.exceptions.BikeNotFoundException;
import com.social.models.viewModels.BikeViewModel;
import com.social.services.BikeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
//import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
//import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BikeController.class)
@ActiveProfiles("test")
@EnableSpringDataWebSupport
public class BikeControllerTest {

    private static final long VALID_ID = 1;

    private static final String MODEL = "BMX";

    private static final int INVALID_ID = -1;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BikeService bikeService;

    @Mock
    private Pageable pageable;

    @Captor
    private ArgumentCaptor<Pageable> captor;

    @Before
    public void setUp() {
        BikeViewModel bikeViewModel = new BikeViewModel();
        bikeViewModel.setId(VALID_ID);
        bikeViewModel.setModel(MODEL);
        Page<BikeViewModel> bikePage = new PageImpl<BikeViewModel>(Arrays.asList(bikeViewModel, bikeViewModel));

        when(this.bikeService.findById(VALID_ID)).thenReturn(bikeViewModel);
        when(this.bikeService.findById(INVALID_ID)).thenThrow(new BikeNotFoundException());
        when(this.bikeService.findAll(this.pageable)).thenReturn(bikePage);
    }

    @Test
    @WithMockUser
    public void showBikeById_ShouldReturnCorrectBike() throws Exception {
        this.mvc
                .perform(get("/bikes/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("bike-show"))
                .andExpect(model().attribute("bike", hasProperty("id", is(VALID_ID))))
                .andExpect(model().attribute("bike", hasProperty("model", is(MODEL))))
                .andExpect(model().attribute("bike", hasProperty("gears", is(0))));

        verify(this.bikeService, times(1)).findById(VALID_ID);
        verifyNoMoreInteractions(this.bikeService);
    }

    @Test
    @WithMockUser(username = "test@abv.bg", password = "123456", roles = "USER")
    public void getBikes_ShouldReturnExpectedPage() throws Exception {
        this.mvc
                .perform(get("/bikes"))
                .andExpect(status().isOk())
                .andExpect(view().name("bikes"))
                .andExpect(authenticated().withUsername("test@abv.bg").withRoles("USER"));
    }
}
