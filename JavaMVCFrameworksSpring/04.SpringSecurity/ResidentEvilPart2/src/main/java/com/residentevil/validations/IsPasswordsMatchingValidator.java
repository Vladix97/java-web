package com.residentevil.validations;

import com.residentevil.models.bindingModels.RegistrationModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordsMatchingValidator implements ConstraintValidator<IsPasswordsMatching, Object> {

    @Override
    public void initialize(IsPasswordsMatching isPasswordsMatching) { }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {
        return userClass instanceof RegistrationModel && ((RegistrationModel) userClass).getPassword()
                .equals(((RegistrationModel) userClass).getConfirmPassword());
    }
}
