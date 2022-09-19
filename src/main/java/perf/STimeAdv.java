package perf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class STimeAdv {
    private static long timer;
    private static Mode mode = Mode.MILLI;

    public static void setMode(Mode md) {
        mode = md;
    }

    public static void startTimeChecking() {
        timer = System.nanoTime();
    }

    public static void stopTimeChecking() {
        printResult(System.nanoTime() - timer);
        timer = 0;
    }

    private static void printResult(long deltatime) {
        switch(mode) {
            case SEC:
                printDeltaInSeconds(deltatime);
                break;
            case MILLI:
                printDeltaInMilliSeconds(deltatime);
                break;
            case MICRO:
                printDeltaInMicroSeconds(deltatime);
                break;
            case NANO:
                printDeltaInNanoSeconds(deltatime);
                break;
            default:
                log.error("wrong mode");
        }
    }

    private static double getDeltaInSeconds(long deltatime) {
        //--- convert nano result to seconds. 1 sec = 10e9 nanosec
        return (double) deltatime / 1000000000;
    }

    private static double getDeltaInMilliSeconds(long deltatime) {
        //--- convert nano result to msec. 1 msec = 10e6 nanosec, 1 sec = 10e3 msec
        return (double) deltatime / 1000000;
    }

    private static double getDeltaInMicroSeconds(long deltatime) {
        //--- convert nano result to mcrs.  1 mcrsec = 10e3 nanosec, 1 sec = 10e6 mcrsec
        return (double) deltatime / 1000;
    }

    public static void printDeltaInSeconds(long deltatime) {
        log.info(String.format("time = %.3f sec", getDeltaInSeconds(deltatime)));
    }

    public static void printDeltaInMilliSeconds(long deltatime) {
        log.info(String.format("time = %.3f millisec", getDeltaInMilliSeconds(deltatime)));
    }

    public static void printDeltaInMicroSeconds(long deltatime) {
        log.info(String.format("time = %.3f microsec", getDeltaInMicroSeconds(deltatime)));
    }

    public static void printDeltaInNanoSeconds(long deltatime) {
        log.info(String.format("time = %d nanosec", deltatime));
    }

    public enum Mode {
        SEC,
        MILLI,
        MICRO,
        NANO
    }
}
