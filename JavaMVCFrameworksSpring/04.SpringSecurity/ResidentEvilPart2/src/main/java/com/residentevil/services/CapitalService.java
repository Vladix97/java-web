package com.residentevil.services;

import com.residentevil.models.viewModels.CapitalNameViewModel;

import java.util.Set;

public interface CapitalService {

    Set<CapitalNameViewModel> getAllCapitals();
}
