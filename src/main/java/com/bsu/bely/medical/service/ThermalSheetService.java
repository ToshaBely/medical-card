package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.ThermalSheet;

import java.util.List;

public interface ThermalSheetService {
    List<ThermalSheet> getAll();
    void add(ThermalSheet thermalSheet);
    List<ThermalSheet> getThermalSheetsByPatientId(long patientId);
}
