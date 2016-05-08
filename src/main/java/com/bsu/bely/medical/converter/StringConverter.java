package com.bsu.bely.medical.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class StringConverter implements Converter {
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value != null ? value.trim() : null;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }
}
