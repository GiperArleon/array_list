package utils;

import java.util.Random;

public class DataProvider {

    private static final String[] names = new String[]{"Square", "Triangle", "Circle"};

    public static Integer[] generateRandomIntArray(int size, int bound) {
        Random rd = new Random();
        Integer[] arr = new Integer[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(bound);
        }
        return arr;
    }

    public static int[] generateRandomPremitiveIntArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public static Shape[] generateRandomShapeArray(int size) {
        Random rd = new Random();
        Shape[] arr = new Shape[size];
        for(int i = 0; i < arr.length; i++) {
            String name = names[rd.nextInt(names.length - 1)];
            arr[i] = new Shape(name, COLOR.randomColor(), getAngles(name));
            rd.nextInt();
        }
        return arr;
    }

    public static Shape[] generateRandomShapeArrayRandomAngles(int size) {
        Random rd = new Random();
        Shape[] arr = new Shape[size];
        for(int i = 0; i < arr.length; i++) {
            String name = names[rd.nextInt(names.length - 1)];
            arr[i] = new Shape(name, COLOR.randomColor(), rd.nextInt(10));
            rd.nextInt();
        }
        return arr;
    }

    public static int getAngles(String name) {
        switch(name) {
            case "Square":
                return 4;
            case "Triangle":
                return 3;
            case "Circle":
                return 0;
            default:
                return -99;
        }
    }
}
