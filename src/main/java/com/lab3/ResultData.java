package com.lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResultData {
    private double x;
    private double y;
    private double r;
    private boolean result;
    private long execTime;
    private String currTime;
}
