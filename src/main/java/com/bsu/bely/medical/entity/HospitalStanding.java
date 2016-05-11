package com.bsu.bely.medical.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hospital_standing")
public class HospitalStanding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entering_date")
    private Date enteringDate;

    @Column(name = "diagnose")
    private String diagnose;

    @Column(name = "survey_plan")
    private String surveyPlan;

    @Column(name = "treatment_plan")
    private String treatmentPlan;

    @Column(name = "discharge_date")
    private Date dischargeDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "department_head_id")
    private Doctor departmentHead;

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Doctor therapist;

    public Long getId() {
        return id;
    }

    public Date getEnteringDate() {
        return enteringDate;
    }

    public void setEnteringDate(Date enteringDate) {
        this.enteringDate = enteringDate;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getSurveyPlan() {
        return surveyPlan;
    }

    public void setSurveyPlan(String surveyPlan) {
        this.surveyPlan = surveyPlan;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(Doctor departmentHead) {
        this.departmentHead = departmentHead;
    }

    public Doctor getTherapist() {
        return therapist;
    }

    public void setTherapist(Doctor therapist) {
        this.therapist = therapist;
    }
}
