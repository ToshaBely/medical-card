package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Analysis;
import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.AnalysisService;
import com.bsu.bely.medical.service.DoctorService;
import com.bsu.bely.medical.service.PatientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "analysisBean")
@ViewScoped
public class AnalysisBean {

    @ManagedProperty("#{analysisServiceImpl}")
    private AnalysisService analysisService;

    @ManagedProperty("#{patientServiceImpl}")
    private PatientService patientService;

    @ManagedProperty("#{doctorServiceImpl}")
    private DoctorService doctorService;

    private Patient selectedPatient;
    private List<Patient> patientList;
    private List<Doctor> doctorList;
    private Analysis createdAnalysis;
    private List<Analysis> analysisList;

    @PostConstruct
    private void init() {
        createdAnalysis = new Analysis();
        patientList = patientService.getAll();
        doctorList = doctorService.getAll();
        analysisList = new ArrayList<>();
    }

    public void applyFilter()
    {
        if (selectedPatient != null) {
            analysisList = analysisService.getAllByPatientId(selectedPatient.getId());
        }
    }

    public void saveCreatedAnalysis()
    {
        analysisService.add(createdAnalysis);
        createdAnalysis = new Analysis();
        applyFilter();
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Analysis getCreatedAnalysis() {
        return createdAnalysis;
    }

    public void setCreatedAnalysis(Analysis createdAnalysis) {
        this.createdAnalysis = createdAnalysis;
    }

    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
