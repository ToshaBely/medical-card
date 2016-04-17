package com.bsu.bely.medical.bean;

//import javax.faces.bean.ManagedBean;

//@ManagedBean(name = "main")
public class MainBean {

    private String value = "Value from MainBean.";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
