package com.bsu.bely.medical.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "post")
    private String post;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "departmentHead", fetch = FetchType.LAZY)
    private Set<HospitalStanding> hospitalStandingSetAsDepartmentHead;

    @OneToMany(mappedBy = "therapist", fetch = FetchType.LAZY)
    private Set<HospitalStanding> hospitalStandingSetAsTherapist;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<Analysis> analysisSet;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<HospitalStanding> getHospitalStandingSetAsDepartmentHead() {
        return hospitalStandingSetAsDepartmentHead;
    }

    public void setHospitalStandingSetAsDepartmentHead(Set<HospitalStanding> hospitalStandingSetAsDepartmentHead) {
        this.hospitalStandingSetAsDepartmentHead = hospitalStandingSetAsDepartmentHead;
    }

    public Set<HospitalStanding> getHospitalStandingSetAsTherapist() {
        return hospitalStandingSetAsTherapist;
    }

    public void setHospitalStandingSetAsTherapist(Set<HospitalStanding> hospitalStandingSetAsTherapist) {
        this.hospitalStandingSetAsTherapist = hospitalStandingSetAsTherapist;
    }

    public Set<Analysis> getAnalysisSet() {
        return analysisSet;
    }

    public void setAnalysisSet(Set<Analysis> analysisSet) {
        this.analysisSet = analysisSet;
    }
}
