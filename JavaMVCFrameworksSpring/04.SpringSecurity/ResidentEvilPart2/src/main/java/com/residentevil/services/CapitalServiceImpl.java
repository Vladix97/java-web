package com.residentevil.services;

import com.residentevil.entities.Capital;
import com.residentevil.models.viewModels.CapitalNameViewModel;
import com.residentevil.repositories.CapitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CapitalServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<CapitalNameViewModel> getAllCapitals() {
        Set<CapitalNameViewModel> result = new LinkedHashSet<>();
        List<Capital> all = this.capitalRepository.findAll();

        for (Capital capital : all) {
            CapitalNameViewModel c = this.modelMapper.map(capital, CapitalNameViewModel.class);
            result.add(c);
        }

        return result;
    }
}
