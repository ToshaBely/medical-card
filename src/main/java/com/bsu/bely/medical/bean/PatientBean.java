package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.*;
import com.bsu.bely.medical.entity.type.RoleType;
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

import java.util.Date;
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
    private List<Doctor> doctorList;
    private List<HospitalStanding> hospitalList;
    private List<MedicalJournal> medicalJournalList;

    private Patient createdPatient;
    private HospitalStanding hospitalStanding;
    private MedicalJournal createdMedicalJournal;
    private Doctor me;

    private String prevSurvey;
    private String prevTreatment;

    @PostConstruct
    private void init() {
        String login = DoctorUtils.getCurrentDoctorLogin();
        me = doctorService.getDoctorByLogin(login);
        patientList = patientService.getAllForDoctor(me);
        hospitalList = hospitalService.getAllForDoctor(me);
        medicalJournalList = medicalJournalService.getAllForDoctor(me);
        doctorList = doctorService.getAll();
        createdPatient = new Patient();
        hospitalStanding = new HospitalStanding();
        createdMedicalJournal = new MedicalJournal();
    }

    public void saveCreatedPatient() {
        patientService.addPatient(createdPatient);
        createdPatient = new Patient();
        patientList = patientService.getAllForDoctor(me);
    }

    public void saveCreatedHospitalStanding() {
        hospitalStanding.setDepartmentHead(me);
        hospitalService.add(hospitalStanding);
        hospitalStanding = new HospitalStanding();
        hospitalList = hospitalService.getAllForDoctor(me);
    }

    public void prepareEditedHospitalStanding(HospitalStanding editedHospitalStanding) {
        hospitalStanding = editedHospitalStanding;
        prevSurvey = editedHospitalStanding.getSurveyPlan();
        prevTreatment = editedHospitalStanding.getTreatmentPlan();
    }

    public void saveEditedHospital() {
        hospitalService.update(hospitalStanding);
        hospitalStanding = new HospitalStanding();
    }

    public void cancelEdit() {
        hospitalStanding.setSurveyPlan(prevSurvey);
        hospitalStanding.setTreatmentPlan(prevTreatment);
        hospitalStanding = new HospitalStanding();
    }

    public void saveCreatedMedicalJournal() {
        createdMedicalJournal.setDoctor(me);
        medicalJournalService.add(createdMedicalJournal);
        createdMedicalJournal = new MedicalJournal();
        medicalJournalList = medicalJournalService.getAllForDoctor(me);
    }

    public boolean getAvailableReleaseButton(Date dischargeDate) {
        return DoctorUtils.hasDoctorRole(me, RoleType.ROLE_DEPARTMENT_HEAD) && dischargeDate == null;
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

    public HospitalStanding getHospitalStanding() {
        return hospitalStanding;
    }

    public void setHospitalStanding(HospitalStanding hospitalStanding) {
        this.hospitalStanding = hospitalStanding;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public MedicalJournal getCreatedMedicalJournal() {
        return createdMedicalJournal;
    }

    public void setCreatedMedicalJournal(MedicalJournal createdMedicalJournal) {
        this.createdMedicalJournal = createdMedicalJournal;
    }
}
