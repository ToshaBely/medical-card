package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.PatientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.util.List;

@ViewScoped
@ManagedBean(name = "patientBean")
public class PatientBean {

    @ManagedProperty("#{patientServiceImpl}")
    private PatientService patientService;

    private List<Patient> patientList;

    private Patient createdPatient;

    @PostConstruct
    private void init() {
        patientList = patientService.getAll();
        createdPatient = new Patient();
    }

    public void saveCreatedPatient() {
        patientService.addPatient(createdPatient);
        createdPatient = new Patient();
        patientList = patientService.getAll();
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public Patient getCreatedPatient() {
        return createdPatient;
    }

    public void setCreatedPatient(Patient createdPatient) {
        this.createdPatient = createdPatient;
    }
}
