package utils;

public class Performance {

    public static void start() {
        STimeAdv.startTimeChecking();
        SMemoryAdv.startMemoryChecking();
    }

    public static void stop() {
        STimeAdv.stopTimeChecking();
        SMemoryAdv.stopMemoryChecking();
    }
}
