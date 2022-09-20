package utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SMemoryAdv {
    private static final long SLEEP_INTERVAL_MS = 100;
    private static long memory;

    public static void startMemoryChecking() {
        memory = getMemoryUse();
    }

    public static void stopMemoryChecking() {
        printUsedMemory(getMemoryUse() - memory);
        memory = 0;
    }

    private static void collectGarbage() {
        try {
            System.gc();
            System.gc();
            System.gc();
            Thread.sleep(SLEEP_INTERVAL_MS);
            System.runFinalization();
            Thread.sleep(SLEEP_INTERVAL_MS);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static void putOutTheGarbage() {
        collectGarbage();
        collectGarbage();
        collectGarbage();
    }

    private static long getMemoryUse() {
        putOutTheGarbage();
        long totalMemory = Runtime.getRuntime().totalMemory();
        putOutTheGarbage();
        long freeMemory = Runtime.getRuntime().freeMemory();
        return(totalMemory - freeMemory);
    }

    private static void printUsedMemory(long delta) {
        log.info(String.format("used memory = %d byte", delta));
    }
}
