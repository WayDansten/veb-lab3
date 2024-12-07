package com.lab3;

public class CoordinateChecker{
    public boolean checkHit(double x, double y, double r) {
        return (x >= 0 && y >= 0 && (Math.pow(x, 2) + Math.pow(y, 2)) <= (Math.pow(r, 2) / 4)) ||
                (x >= 0 && y <= 0 && y >= (2 * x - r)) ||
                (x <= 0 && x >= -r && y <= 0 && y >= -r);
    }
}
