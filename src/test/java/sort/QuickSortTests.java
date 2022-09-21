package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.DataProvider;
import utils.Performance;
import utils.Shape;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static utils.DataProvider.generateRandomShapeArray;
import static utils.DataProvider.generateRandomShapeArrayRandomAngles;

@Slf4j
@ExtendWith(MockitoExtension.class)
class QuickSortTests {

    @InjectMocks
    private QuickSortJen<Shape> quickSortJen;

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

    @Test
    public void testQuickSortJen() {
       Shape[] testArr = generateRandomShapeArray(100);
       Shape[] compareArr = Arrays.copyOfRange(testArr, 0, testArr.length);

        log.info("QuickSort");
        Performance.start();
        quickSortJen.sort(testArr);
        Performance.stop();

        System.out.println();

        log.info("Arrays.sort");
        Performance.start();
        Arrays.sort(compareArr);
        Performance.stop();

        assertArrayEquals(testArr, compareArr);
    }

    @Test
    public void testQuickSortJenRandomAngles() {
        Shape[] testArr = generateRandomShapeArrayRandomAngles(100);
        Shape[] compareArr = Arrays.copyOfRange(testArr, 0, testArr.length);

        log.info("QuickSort");
        Performance.start();
        quickSortJen.sort(testArr);
        Performance.stop();

        System.out.println();

        log.info("Arrays.sort");
        Performance.start();
        Arrays.sort(compareArr);
        Performance.stop();

        assertArrayEquals(testArr, compareArr);
    }
}