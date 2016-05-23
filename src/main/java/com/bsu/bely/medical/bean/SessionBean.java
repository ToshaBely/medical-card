package com.bsu.bely.medical.bean;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.type.RoleType;
import com.bsu.bely.medical.service.DoctorService;
import com.bsu.bely.medical.utils.DoctorUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {
    @ManagedProperty("#{doctorServiceImpl}")
    private DoctorService doctorService;

    public void logoff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + "/j_spring_security_logout");
        } catch (IOException ex) {
            System.out.println("Logoff error");
        }
    }

    public boolean getIsDepartmentHead() {
        Doctor me =  doctorService.getDoctorByLogin(DoctorUtils.getCurrentDoctorLogin());
        return DoctorUtils.hasDoctorRole(me, RoleType.ROLE_DEPARTMENT_HEAD);
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
