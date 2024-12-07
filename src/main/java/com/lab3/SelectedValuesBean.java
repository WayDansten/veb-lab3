package com.lab3;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Named("selectedValuesBean")
@RequestScoped
public class SelectedValuesBean {

    private double selectedX = 0;
    @Setter
    private double selectedY = 0;
    private double selectedR = 1;

    public void setSelectedX(double selectedX) {
        this.selectedX = selectedX;
        System.out.println(selectedX);
    }

    public void setSelectedR(double selectedR) {
        this.selectedR = selectedR;
        System.out.println(selectedR);
    }
}
