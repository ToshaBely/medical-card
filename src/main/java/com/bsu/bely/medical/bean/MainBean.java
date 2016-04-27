package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.PatientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mainBean")
@ViewScoped
public class MainBean {

    private String value = "Value from MainBean.";
    private String selectedString;

    @ManagedProperty(value = "#{patientServiceImpl}")
    private PatientService patientService;

    private List<String> list;

    @PostConstruct
    public void init() {
        list = createList();
        selectedString = "BB";
    }

    private List<String> createList() {
        List<String> list = new ArrayList<String>();
        list.add("AA");
        list.add("BB");

        return list;
    }

    public void saveString() {
//        Patient patient = new Patient();
//        patient.setFirstName("Anton");
//        patient.setLastName("Bely");
//        patient.setPassport("MP3025105");
//        patient.setTelephoneNumber("+375256560507");
//
        if (patientService != null)
        {
            int a = 8;
//            patientService.addPatient(patient);
        }
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getSelectedString() {
        return this.selectedString;
    }

    public void setSelectedString(String selectedString) {
        this.selectedString = selectedString;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}
