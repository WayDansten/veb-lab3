package com.lab3;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@ManagedBean
@SessionScoped
public class ResultStorage implements Serializable {
    private final ArrayList<ResultData> tableData = new ArrayList<>();

    public void addTableData(ResultData resultData) {
        tableData.add(resultData);
    }

}
