package com.residentevil.services;

import com.residentevil.models.viewModels.CapitalNameViewModel;
import com.residentevil.repositories.CapitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CapitalServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository) {
        this.capitalRepository = capitalRepository;
    }

    @Override
    public Set<CapitalNameViewModel> getAllCapitals() {
        return null;
    }
}
