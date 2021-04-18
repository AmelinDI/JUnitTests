package edu.unit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        MyMath myMath = new MyMath();
        System.out.println(myMath.add(3,2));
        System.out.println(myMath.div(10,5));

        Integer[][] myList = new Integer[][] {{1,2,3},{1,2,3}};
        Arrays.stream(myList).forEach(c -> System.out.println(c[0]+" + "+c[1]+" = "+c[2]));
    }
}
