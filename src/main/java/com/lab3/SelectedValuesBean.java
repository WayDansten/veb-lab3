package com.lab3;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Named("selectedValuesBean")
@RequestScoped
public class SelectedValuesBean {

    private double selectedX = 0;
    private double selectedY = 0;
    private double selectedR = 1;
}
