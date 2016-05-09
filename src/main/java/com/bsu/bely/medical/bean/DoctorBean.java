package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.service.DoctorService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "doctorBean")
@ViewScoped
public class DoctorBean {

    @ManagedProperty("#{doctorServiceImpl}")
    private DoctorService doctorService;

    private List<Doctor> doctorList;

    @PostConstruct
    private void init() {
        doctorList = doctorService.getAll();
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
