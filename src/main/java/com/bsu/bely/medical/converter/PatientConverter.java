package com.bsu.bely.medical.converter;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.PatientService;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class PatientConverter implements Converter {
    private final static String SERVICE_NAME = "patientService";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                PatientService service = (PatientService) FacesContextUtils.getWebApplicationContext(facesContext).getBean(SERVICE_NAME);
                return service.getPatient(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid patient."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if(object != null) {
            return String.valueOf(((Patient) object).getId());
        }
        else {
            return null;
        }
    }
}
