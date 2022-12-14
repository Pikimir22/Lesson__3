package tests;

import java.util.Random;

public class TestDate {


    public static int randomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


    public static String monthRandom() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int index = randomInt(0, month.length - 1);
        return month[index];
    }
}
