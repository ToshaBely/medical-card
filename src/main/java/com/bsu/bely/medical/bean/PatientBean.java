package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.HospitalStanding;
import com.bsu.bely.medical.entity.MedicalJournal;
import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.DoctorService;
import com.bsu.bely.medical.service.HospitalStandingService;
import com.bsu.bely.medical.service.MedicalJournalService;
import com.bsu.bely.medical.service.PatientService;
import com.bsu.bely.medical.utils.DoctorUtils;
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

    @ManagedProperty("#{medicalJournalServiceImpl}")
    private MedicalJournalService medicalJournalService;

    @ManagedProperty("#{doctorServiceImpl}")
    private DoctorService doctorService;

    private List<Patient> patientList;
    private List<HospitalStanding> hospitalList;
    private List<MedicalJournal> medicalJournalList;

    private Patient createdPatient;
    private Doctor me;

    @PostConstruct
    private void init() {
        String login = DoctorUtils.getCurrentDoctorLogin();
        me = doctorService.getDoctorByLogin(login);
        patientList = patientService.getAllForDoctor(me);
        hospitalList = hospitalService.getAllByDoctorId(me.getId());
        medicalJournalList = medicalJournalService.getAllByDoctorId(me.getId());
        createdPatient = new Patient();
    }

    public void saveCreatedPatient() {
        patientService.addPatient(createdPatient);
        createdPatient = new Patient();
        patientList = patientService.getAllForDoctor(me);
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

    public void setMedicalJournalService(MedicalJournalService medicalJournalService) {
        this.medicalJournalService = medicalJournalService;
    }

    public List<MedicalJournal> getMedicalJournalList() {
        return medicalJournalList;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
