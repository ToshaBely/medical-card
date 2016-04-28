package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.PatientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "createPatientBean")
public class CreatePatientBean {
    @ManagedProperty("#{patientServiceImpl}")
    private PatientService patientService;

    private Patient createdPatient;
    private String lastCreatedPatient;

    @PostConstruct
    private void init() {
        createdPatient = new Patient();
    }

    public void saveCreatedPatient() {
        patientService.addPatient(createdPatient);

        lastCreatedPatient = createdPatient.getFirstName() + " " + createdPatient.getLastName();
        createdPatient = new Patient();
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public Patient getCreatedPatient() {
        return createdPatient;
    }

    public void setCreatedPatient(Patient createdPatient) {
        this.createdPatient = createdPatient;
    }

    public String getLastCreatedPatient() {
        return lastCreatedPatient;
    }
}
