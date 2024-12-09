package com.lab3;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestScoped
@Named("dataManagementBean")
public class DataManagementBean {

    @Inject
    ResultStorageBean resultStorageBean;

    public void processForm(ResultDataBean data) {

        long startTime = System.nanoTime();
        data.setResult(CoordinateChecker.checkHit(data.getSelectedX(), data.getSelectedY(), data.getSelectedR()));
        long execTime = (System.nanoTime() - startTime) / 1000;
        data.setExecTime(execTime);
        String currTime = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
        data.setCurrTime(currTime);

        resultStorageBean.addData(data);

    }

}
