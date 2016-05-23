package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Analysis;
import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.AnalysisService;
import com.bsu.bely.medical.service.DoctorService;
import com.bsu.bely.medical.service.PatientService;
import com.bsu.bely.medical.utils.DoctorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean(name = "analysisBean")
@ViewScoped
public class AnalysisBean {

    public class ResultPair {
        private String first;
        private String second;

        public ResultPair() {
            this.first = "";
            this.second = "";
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }
    }

    @ManagedProperty("#{analysisServiceImpl}")
    private AnalysisService analysisService;

    @ManagedProperty("#{patientServiceImpl}")
    private PatientService patientService;

    @ManagedProperty("#{doctorServiceImpl}")
    private DoctorService doctorService;

    private Gson gson;

    private Patient selectedPatient;
    private List<Patient> patientList;
    private Analysis createdAnalysis;
    private List<Analysis> analysisList;
    private Doctor me;

    private List<Map.Entry<String, Object>> resultList;
    private List<ResultPair> createdResultList;

    @PostConstruct
    private void init() {
        gson = new Gson();
        String login = DoctorUtils.getCurrentDoctorLogin();
        me = doctorService.getDoctorByLogin(login);
        patientList = patientService.getAllForDoctor(me);
        createdAnalysis = new Analysis();
        createdResultList = new ArrayList<>();
        analysisList = analysisService.getAll();
        resultList = new ArrayList<>();
    }

    public void saveCreatedAnalysis() {
        createdAnalysis.setResult(createResultJSON());
        createdAnalysis.setDoctor(me);
        analysisService.add(createdAnalysis);
        createdAnalysis = new Analysis();
        createdResultList = new ArrayList<>();
        analysisList = analysisService.getAll();
    }

    private String createResultJSON() {
        Map<String, Object> map = new HashMap<>();
        for (ResultPair entry : createdResultList) {
            map.put(entry.getFirst(), entry.getSecond());
        }
        return gson.toJson(map);
    }

    public void addResultRowToList() {
        createdResultList.add(new ResultPair());
    }

    public void prepareToShow(Analysis analysis) {
        Map <String, Object> map = gson.fromJson(analysis.getResult(), new TypeToken<Map<String, Object>>() {
        }.getType());
        resultList.addAll(map.entrySet().stream().collect(Collectors.toList()));
    }

    public void afterShow() {
        resultList = new ArrayList<>();
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

    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public List<Map.Entry<String, Object>> getResultList() {
        return resultList;
    }

    public void setResultList(List<Map.Entry<String, Object>> resultList) {
        this.resultList = resultList;
    }

    public List<ResultPair> getCreatedResultList() {
        return createdResultList;
    }

    public void setCreatedResultList(List<ResultPair> createdResultList) {
        this.createdResultList = createdResultList;
    }
}
