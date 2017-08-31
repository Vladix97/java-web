package com.residentevil.models.bindingModels;

import com.residentevil.validations.PresentOrFuture;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class AddVirus {

    private String name;

    private String description;

    private String sideEffects;

    private String creator;

    private Boolean isDeadly;

    private Boolean isCurable;

    private String mutation;

    private Float turnoverRate;

    private Integer hoursUntilTurn;

    private String magnitude;

    private Date releasedOn;

    private String[] capitals;

    public AddVirus() {
        super();
    }

    @NotNull
    @Size(min = 3, max = 10, message = "Invalid name!")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5, max = 100, message = "Invalid description!")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Size(min = 50, message = "InvalidS side effects!")
    public String getSideEffects() {
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @NotNull
    @Pattern(regexp = "^.*[Cc]orp.*$", message = "Invalid creator")
    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getDeadly() {
        return this.isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getCurable() {
        return this.isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    @NotNull(message = "Mutation cannot be null!")
    public String getMutation() {
        return this.mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    @Max(value = 100, message = "Invalid turnover rate!")
    @Min(value = 0, message = "Invalid turnover rate!")
    public Float getTurnoverRate() {
        return this.turnoverRate;
    }

    public void setTurnoverRate(Float turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @Max(value = 12, message = "Invalid hours!")
    @Min(value = 1, message = "Invalid hours!")
    public Integer getHoursUntilTurn() {
        return this.hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    @NotNull(message = "Magnitude cannot be null!")
    public String getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PresentOrFuture(message = "The release date should be in a future moment!")
    public Date getReleasedOn() {
        return this.releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    @NotEmpty(message = "You must select capitals!")
    public String[] getCapitals() {
        return this.capitals;
    }

    public void setCapitals(String[] capitals) {
        this.capitals = capitals;
    }
}
