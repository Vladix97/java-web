package com.residentevil.services;

import com.residentevil.models.bindingModels.AddVirusBindingModel;
import com.residentevil.models.bindingModels.EditVirusBindingModel;
import com.residentevil.models.viewModels.VirusViewModel;

import java.util.List;

public interface VirusService {

    String findAllMapViruses();

    List<VirusViewModel> findAllViruses();

    void save(AddVirusBindingModel addVirusBindingModel);

    void save(EditVirusBindingModel editVirusBindingModel);

    void deleteById(long virusId);

    EditVirusBindingModel findVirusById(long virusId);
}
