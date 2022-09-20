package utils;

import java.util.Random;

public class DataProvider {
    public static Integer[] generateRandomIntArray(int size, int bound) {
        Random rd = new Random();
        Integer[] arr = new Integer[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(bound);
        }
        return arr;
    }
}