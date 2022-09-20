package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import utils.DataProvider;
import utils.Performance;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
class QuickSortTest {
    @Test
    public void testQuickSort_simpleOne() {
        int[] testArr = {6,5,1,3,8,4,7,9,2};

        log.info("QuickSort");
        QuickSort.sort(testArr);

        log.info("res = {}", testArr);
    }

    @Test
    public void testQuickSort() {
        int[] testArr = DataProvider.generateRandomPremitiveIntArray(100000);
        int[] compareArr = Arrays.copyOfRange(testArr, 0, testArr.length);

        log.info("QuickSort");
        Performance.start();
        QuickSort.sort(testArr);
        Performance.stop();

        System.out.println();

        log.info("Arrays.sort");
        Performance.start();
        Arrays.sort(compareArr);
        Performance.stop();

        assertArrayEquals(testArr, compareArr);
    }
}