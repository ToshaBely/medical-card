package com.bsu.bely.medical.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport")
    private String passport;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "birth_day")
    private Date birthDay;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<HealthStatus> overallHealthSet;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<ThermalSheet> thermalSheets;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<HospitalStanding> hospitalStandingSet;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Analysis> analysisSet;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Patient)) {
            return false;
        }
        Patient p = (Patient) obj;
        return Objects.equals(this.id, p.id);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Set<HealthStatus> getOverallHealthSet() {
        return overallHealthSet;
    }

    public void setOverallHealthSet(Set<HealthStatus> overallHealthSet) {
        this.overallHealthSet = overallHealthSet;
    }

    public Set<ThermalSheet> getThermalSheets() {
        return thermalSheets;
    }

    public void setThermalSheets(Set<ThermalSheet> thermalSheets) {
        this.thermalSheets = thermalSheets;
    }

    public Set<HospitalStanding> getHospitalStandingSet() {
        return hospitalStandingSet;
    }

    public void setHospitalStandingSet(Set<HospitalStanding> hospitalStandingSet) {
        this.hospitalStandingSet = hospitalStandingSet;
    }

    public Set<Analysis> getAnalysisSet() {
        return analysisSet;
    }

    public void setAnalysisSet(Set<Analysis> analysisSet) {
        this.analysisSet = analysisSet;
    }
}
