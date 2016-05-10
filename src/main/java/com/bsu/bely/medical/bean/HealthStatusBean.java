package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.HealthStatus;
import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.entity.ThermalSheet;
import com.bsu.bely.medical.entity.type.*;
import com.bsu.bely.medical.service.HealthStatusService;
import com.bsu.bely.medical.service.PatientService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "healthStatusBean")
@ViewScoped
public class HealthStatusBean {

    @ManagedProperty("#{healthStatusServiceImpl}")
    private HealthStatusService healthService;

    @ManagedProperty("#{patientServiceImpl}")
    private PatientService patientService;

    private List<HealthStatus> healthStatusList;
    private HealthStatus healthStatus;
    private List<Patient> patientList;
    private Patient selectedPatient;

    private List<BodyType> bodyTypes = Arrays.asList(BodyType.values());
    private List<FeelingType> feelingTypes = Arrays.asList(FeelingType.values());
    private List<LiverType> liverTypes = Arrays.asList(LiverType.values());
    private List<LymphNodesType> lymphNodesTypes = Arrays.asList(LymphNodesType.values());
    private List<OverallHealthType> overallHealthTypes = Arrays.asList(OverallHealthType.values());
    private List<SkinType> skinTypes = Arrays.asList(SkinType.values());

    @PostConstruct
    private void init() {
        patientList = patientService.getAll();
        healthStatusList = new ArrayList<>();
        healthStatus = new HealthStatus();
    }

    public void applyFilter() {
        if (selectedPatient != null) {
            healthStatusList = healthService.getHealthStatusByPatientId(selectedPatient.getId());
        }
    }

    public void temperatureValidator(FacesContext context, UIComponent component, Object value) {
        if (value == null || (double) value < 34.5 || (double) value > 42.5) {
            throw new ValidatorException(new FacesMessage("Wrong temperature"));
        }
    }

    public void saveCreatedThermal() {
        healthService.add(healthStatus);
        healthStatus = new HealthStatus();
        applyFilter();
    }

    public void setHealthService(HealthStatusService healthService) {
        this.healthService = healthService;
    }

    public List<HealthStatus> getHealthStatusList() {
        return healthStatusList;
    }

    public void setHealthStatusList(List<HealthStatus> healthStatusList) {
        this.healthStatusList = healthStatusList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public List<BodyType> getBodyTypes() {
        return bodyTypes;
    }

    public void setBodyTypes(List<BodyType> bodyTypes) {
        this.bodyTypes = bodyTypes;
    }

    public List<FeelingType> getFeelingTypes() {
        return feelingTypes;
    }

    public void setFeelingTypes(List<FeelingType> feelingTypes) {
        this.feelingTypes = feelingTypes;
    }

    public List<LiverType> getLiverTypes() {
        return liverTypes;
    }

    public void setLiverTypes(List<LiverType> liverTypes) {
        this.liverTypes = liverTypes;
    }

    public List<LymphNodesType> getLymphNodesTypes() {
        return lymphNodesTypes;
    }

    public void setLymphNodesTypes(List<LymphNodesType> lymphNodesTypes) {
        this.lymphNodesTypes = lymphNodesTypes;
    }

    public List<OverallHealthType> getOverallHealthTypes() {
        return overallHealthTypes;
    }

    public void setOverallHealthTypes(List<OverallHealthType> overallHealthTypes) {
        this.overallHealthTypes = overallHealthTypes;
    }

    public List<SkinType> getSkinTypes() {
        return skinTypes;
    }

    public void setSkinTypes(List<SkinType> skinTypes) {
        this.skinTypes = skinTypes;
    }
}
