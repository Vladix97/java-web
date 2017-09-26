package com.social.services;

import com.social.entities.Bike;
import com.social.exceptions.BikeNotFoundException;
import com.social.models.viewModels.BikeViewModel;
import com.social.repositories.BikeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BikeServiceImpl(
            BikeRepository bikeRepository,
            ModelMapper modelMapper) {
        this.bikeRepository = bikeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BikeViewModel findById(long id) {
        Bike one = this.bikeRepository.findOne(id);
        if (one == null) {
            throw new BikeNotFoundException();
        }

        return this.modelMapper.map(one, BikeViewModel.class);
    }

    @Override
    public List<BikeViewModel> findAll() {
        List<Bike> all = this.bikeRepository.findAll();
        List<BikeViewModel> result = new ArrayList<>();
        for (Bike bike : all) {
            result.add(this.modelMapper.map(bike, BikeViewModel.class));
        }

        return result;
    }

    @Override
    public Page<BikeViewModel> findAll(Pageable pageable) {
        Page<Bike> bikes = this.bikeRepository.findAll(pageable);
        List<BikeViewModel> result = new ArrayList<>();
        for (Bike bike : bikes) {
            result.add(this.modelMapper.map(bike, BikeViewModel.class));
        }

        return new PageImpl<>(result, pageable, bikes.getTotalElements());
    }
}
