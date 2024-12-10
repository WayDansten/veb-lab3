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

    private final ArrayList<ResultData> tableData = new ArrayList<>();

    public void addData(ResultDataBean data) {
        tableData.add(new ResultData(data.getSelectedX(), data.getSelectedY(), data.getSelectedR(), data.isResult(), data.getExecTime(), data.getCurrTime()));
    }

}
