package com.lab3;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@ManagedBean
@SessionScoped
@Named("resultStorageBean")
public class ResultStorageBean implements Serializable {

    private final ArrayList<ResultDataBean> tableData = new ArrayList<>();

    public void addData(ResultDataBean resultData) {
        tableData.add(resultData);
    }

}
