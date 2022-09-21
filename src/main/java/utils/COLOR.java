package utils;

import java.util.Random;

public enum COLOR {
    RED, BLUE, GREEN;

    private static final Random PRNG = new Random();

    public static COLOR randomColor()  {
        COLOR[] colors = values();
        return colors[PRNG.nextInt(colors.length)];
    }
}
