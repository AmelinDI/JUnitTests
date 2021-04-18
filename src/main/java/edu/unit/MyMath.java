package edu.unit;

public class MyMath {
    public int add(int a, int b){
        return a + b;
    }

    public double div(double a, double b) throws IllegalArgumentException {
        if (b==0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }
}
