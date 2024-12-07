package com.lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultData {
    private boolean result;
    private double x;
    private double y;
    private double r;
    private String execTime;
    private String currTime;
}
