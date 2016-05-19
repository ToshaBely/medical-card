package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.HospitalStanding;
import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.HospitalStandingService;
import com.bsu.bely.medical.service.PatientService;
import org.apache.commons.lang3.StringUtils;

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

    @ManagedProperty("#{hospitalStandingServiceImpl}")
    private HospitalStandingService hospitalService;

    private List<Patient> patientList;
    private List<HospitalStanding> hospitalList;

    private Patient createdPatient;

    @PostConstruct
    private void init() {
        patientList = patientService.getAll();
        createdPatient = new Patient();
        hospitalList = hospitalService.getAll();
    }

    public void saveCreatedPatient() {
        patientService.addPatient(createdPatient);
        createdPatient = new Patient();
        patientList = patientService.getAll();
    }

    public boolean isBlankString(String string) {
        return StringUtils.isBlank(string);
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

    public void setHospitalService(HospitalStandingService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public List<HospitalStanding> getHospitalList() {
        return hospitalList;
    }
}
