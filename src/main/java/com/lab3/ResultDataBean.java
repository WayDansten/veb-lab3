package com.lab3;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Named("resultDataBean")
@ViewScoped
@Entity
@Table(name="resultData")
public class ResultDataBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultdata_seq")
    @SequenceGenerator(name = "resultdata_seq", sequenceName = "resultdata_seq", allocationSize = 1)
    private long id;

    @Column(name="x", nullable = false)
    private double selectedX;

    @Column(name="y", nullable = false)
    private double selectedY;

    @Column(name="r", nullable = false)
    private double selectedR = 1;

    @Column(name="result", nullable = false)
    private boolean result;

    @Column(name="exec_time", nullable = false)
    private long execTime;

    @Column(name="curr_time", nullable = false)
    private String currTime;

}
