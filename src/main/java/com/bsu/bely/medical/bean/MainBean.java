package com.bsu.bely.medical.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mainBean")
public class MainBean {

    private String value = "Value from MainBean.";

    private List<String> list;

    @PostConstruct
    public void init() {
        list = new ArrayList<String>();
        list.add("AA");
        list.add("BB");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
