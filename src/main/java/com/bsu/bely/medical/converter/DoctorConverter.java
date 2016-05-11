package com.bsu.bely.medical.converter;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.service.DoctorService;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DoctorConverter implements Converter {
    private final static String SERVICE_NAME = "doctorService";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                DoctorService service = (DoctorService) FacesContextUtils.getWebApplicationContext(facesContext).getBean(SERVICE_NAME);
                return service.getDoctor(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid doctor."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if(object != null) {
            return String.valueOf(((Doctor) object).getId());
        }
        else {
            return null;
        }
    }
}
