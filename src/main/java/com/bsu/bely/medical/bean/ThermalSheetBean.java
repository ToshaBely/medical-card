package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.entity.ThermalSheet;
import com.bsu.bely.medical.service.PatientService;
import com.bsu.bely.medical.service.ThermalSheetService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "thermalSheetBean")
public class ThermalSheetBean {

    @ManagedProperty("#{thermalSheetServiceImpl}")
    private ThermalSheetService thermalSheetService;

    @ManagedProperty("#{patientServiceImpl}")
    private PatientService patientService;

    private ThermalSheet thermalSheet;
    private Patient selectedPatient;
    private List<Patient> patientList;
    private List<ThermalSheet> thermalSheetList;

    @PostConstruct
    private void init() {
        thermalSheet = new ThermalSheet();
        patientList = patientService.getAll();
        thermalSheetList = new ArrayList<>();
    }

    public void applyFilter() {
        if (selectedPatient != null) {
            thermalSheetList = thermalSheetService.getThermalSheetsByPatientId(selectedPatient.getId());
        }
    }

    public void saveCreatedThermal() {
        thermalSheetService.add(thermalSheet);
        thermalSheet = new ThermalSheet();
        applyFilter();
    }

    public void temperatureValidator(FacesContext context, UIComponent component, Object value) {
        if (value == null || (double) value < 34.5 || (double) value > 42.5) {
            throw new ValidatorException(new FacesMessage("Wrong temperature"));
        }
    }

    public ThermalSheet getThermalSheet() {
        return thermalSheet;
    }

    public void setThermalSheet(ThermalSheet thermalSheet) {
        this.thermalSheet = thermalSheet;
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

    public List<ThermalSheet> getThermalSheetList() {
        return thermalSheetList;
    }

    public void setThermalSheetList(List<ThermalSheet> thermalSheetList) {
        this.thermalSheetList = thermalSheetList;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void setThermalSheetService(ThermalSheetService thermalSheetService) {
        this.thermalSheetService = thermalSheetService;
    }
}
