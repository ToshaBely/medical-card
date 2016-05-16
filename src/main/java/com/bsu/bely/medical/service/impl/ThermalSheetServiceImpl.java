package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.ThermalSheetDAO;
import com.bsu.bely.medical.entity.ThermalSheet;
import com.bsu.bely.medical.service.ThermalSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ThermalSheetServiceImpl implements ThermalSheetService {
    @Autowired
    private ThermalSheetDAO thermalSheetDAO;

    @Override
    @Transactional
    public List<ThermalSheet> getAll() {
        return thermalSheetDAO.getAll();
    }

    @Override
    @Transactional
    public void add(ThermalSheet thermalSheet) {
        thermalSheetDAO.add(thermalSheet);
    }

    @Override
    @Transactional
    public List<ThermalSheet> getThermalSheetsByPatientIdInDates(long patientId, Date startDate, Date endDate) {
        return thermalSheetDAO.getThermalSheetsByPatientIdInDates(patientId, startDate, endDate);
    }

    @Override
    @Transactional
    public void update(ThermalSheet thermalSheet) {
        thermalSheetDAO.update(thermalSheet);
    }
}
