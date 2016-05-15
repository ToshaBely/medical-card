package com.bsu.bely.medical.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {
    public void logoff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + "/j_spring_security_logout");
        } catch (IOException ex) {
            System.out.println("Logoff error");
        }
    }
}
