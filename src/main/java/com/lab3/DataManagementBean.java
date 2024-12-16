package com.lab3;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        addToDB(data);

    }

    private void addToDB(ResultDataBean data) {
        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(com.lab3.ResultDataBean.class).buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(data);
                transaction.commit();
            }
        }
    }

}
