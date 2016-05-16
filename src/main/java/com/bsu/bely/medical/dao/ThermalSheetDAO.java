package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.ThermalSheet;

import java.util.Date;
import java.util.List;

public interface ThermalSheetDAO {
    List<ThermalSheet> getAll();
    void add(ThermalSheet thermalSheet);
    List<ThermalSheet> getThermalSheetsByPatientIdInDates(long patientId, Date startDate, Date endDate);
}
