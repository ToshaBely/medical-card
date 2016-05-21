package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.entity.ThermalSheet;
import com.bsu.bely.medical.service.PatientService;
import com.bsu.bely.medical.service.ThermalSheetService;
import com.bsu.bely.medical.utils.DateUtil;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    private boolean isEditing = false;

    private Date startDate;
    private Date endDate;

    private LineChartModel lineModel;

    @PostConstruct
    private void init() {
        thermalSheet = new ThermalSheet();
        patientList = patientService.getAll();
        thermalSheetList = new ArrayList<>();
        createLineModel();
        endDate = DateUtil.getEndOfDay(new Date());
        startDate = DateUtil.getBeginOfDay(DateUtil.addMonth(endDate, -1));

    }

    public void applyFilter() {
        if (selectedPatient != null) {
            thermalSheetList = thermalSheetService.getThermalSheetsByPatientIdInDates(selectedPatient.getId(), startDate, endDate);
            addSeriesToLineChart();
        }
    }

    public boolean getIsEmptyList() {
        return thermalSheetList.isEmpty();
    }

    public void saveCreatedThermal() {
        thermalSheetService.add(thermalSheet);
        thermalSheet = new ThermalSheet();
        applyFilter();
    }

    public void prepareEditedThermal(ThermalSheet editSheet) {
        thermalSheet = editSheet;
        isEditing = true;
    }

    public void saveEditedThermal() {
        thermalSheetService.update(thermalSheet);
        thermalSheet = new ThermalSheet();
        applyFilter();
        isEditing = false;
    }

    public void cancelEditAdd() {
        if (isEditing) {
            thermalSheet = new ThermalSheet();
            isEditing = false;
        }
    }

    public void temperatureValidator(FacesContext context, UIComponent component, Object value) {
        if (value == null || (double) value < 34.5 || (double) value > 42.5) {
            throw new ValidatorException(new FacesMessage("Wrong temperature"));
        }
    }

    private void createLineModel() {
        lineModel = new LineChartModel();
        lineModel.setShowPointLabels(true);
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("Temperature");
        yAxis.setMin(34);
        yAxis.setMax(43);

        DateAxis dateAxis = new DateAxis("Dates");
        dateAxis.setTickAngle(-50);
        dateAxis.setTickFormat("%b %#d, %y %H:%M");

        lineModel.getAxes().put(AxisType.X, dateAxis);
    }

    private void addSeriesToLineChart() {
        LineChartSeries series = new LineChartSeries();
        for (ThermalSheet thermal : thermalSheetList) {
            series.set(thermal.getDate().getTime(), thermal.getTemperature());
        }
        lineModel.clear();
        lineModel.addSeries(series);
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

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getIsEditing() {
        return isEditing;
    }
}
