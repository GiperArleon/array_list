package list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.COLOR;
import utils.Shape;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static utils.DataProvider.generateRandomIntArray;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ExtArrayListTest {
    Random rd = new Random();

    @Test
    void add() {
        ExtList<Integer> extList = new ExtArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for(Integer val: generateRandomIntArray(101, 10)) {
            if(!extList.add(val))
                log.info("extList: can not add elem {}", val);
            expected.add(val);
        }
        compareWithOriginalList(extList, expected);
    }

    @Test
    void get() {
        ExtList<Integer> extList = new ExtArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for(Integer val: generateRandomIntArray(101, 10)) {
            if(!extList.add(val))
                log.info("extList: can not add elem {}", val);
            expected.add(val);
        }
        assertEquals(extList.size(), expected.size());

        log.info("1 elem: {}, 3 elem: {}, extList size: {}", extList.get(0), extList.get(2), extList.size());
        log.info("1 elem: {}, 3 elem: {}, extList size: {}", expected.get(0), expected.get(2), expected.size());

        for(int i = 0; i<20; i++) {
            int index = rd.nextInt(extList.size());
            assertEquals(extList.get(index), expected.get(index));
        }
    }

    @Test
    void delete() {
        ExtList<Integer> extList = new ExtArrayList<>();
        List<Integer> expected = new ArrayList<>();
        int checkSize = 101;

        for(Integer val: generateRandomIntArray(checkSize, 10)) {
            if(!extList.add(val))
                log.info("extList: can not add elem {}", val);
            expected.add(val);
        }
        assertEquals(extList.size(), expected.size());

        Integer val1 = extList.delete(checkSize-1);
        Integer val2 = expected.remove(checkSize-1);
        assertEquals(val1, val2);

        for(int i = 10; i<37; i++) {
            val1 = extList.delete(i);
            val2 = expected.remove(i);
            assertEquals(val1, val2);
        }

        compareWithOriginalList(extList, expected);
    }

    @Test
    void delete_indexOutofBonds() {
        ExtList<Integer> extList = new ExtArrayList<>();
        int checkSize = 10;

        for(Integer val: generateRandomIntArray(checkSize, 10)) {
            if(!extList.add(val))
                log.info("extList: can not add elem {}", val);
        }
        assertEquals(extList.size(), checkSize);

        for(int i = 20; i<37; i++) {
            Integer val1 = extList.delete(i);
            assertNull(val1);
        }
    }

    @Test
    void size() {
        ExtList<Integer> extList = new ExtArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for(Integer val: generateRandomIntArray(101, 10)) {
            if(!extList.add(val))
                log.info("extList: can not add elem {}", val);
            expected.add(val);
        }
        assertEquals(extList.size(), expected.size());

        for(int i = 10; i<37; i++) {
            Integer val1 = extList.delete(i);
            Integer val2 = expected.remove(i);
            assertEquals(val1, val2);
        }
        assertEquals(extList.size(), expected.size());

        for(int i = 0; i<100; i++) {
            int val = rd.nextInt(extList.size());
            extList.add(val);
            expected.add(val);
        }
        assertEquals(extList.size(), expected.size());
    }

    @Test
    void clearAll() {
        ExtList<Integer> extList = new ExtArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for(Integer val: generateRandomIntArray(101, 10)) {
            if(!extList.add(val))
                log.info("extList: can not add elem {}", val);
            expected.add(val);
        }
        assertEquals(extList.size(), expected.size());

        for(int i = 0; i<100; i++) {
            int val = rd.nextInt(extList.size());
            extList.add(val);
            expected.add(val);
        }
        assertEquals(extList.size(), expected.size());

        extList.clearAll();
        expected.clear();
        assertEquals(extList.size(), expected.size());
        log.info("1 elem: {}, 3 elem: {}, extList size: {}", extList.get(0), extList.get(2), extList.size());
    }

    @Test
    void sort() {
        Shape square1 = new Shape("Square", COLOR.RED, 4);
        Shape triangle1 = new Shape("Triangle", COLOR.RED, 3);
        Shape triangle2 = new Shape("Triangle", COLOR.BLUE, 3);
        Shape someFigure1 = new Shape("AAA", COLOR.BLUE, 31);
        Shape circle1 = new Shape("Circle", COLOR.GREEN, 0);
        ExtList<Shape> shapeList = new ExtArrayList<>();
        List<Shape> expected = new ArrayList<>(List.of(square1, triangle1, triangle2, someFigure1, circle1));

        shapeList.add(square1);
        shapeList.add(triangle1);
        shapeList.add(triangle2);
        shapeList.add(someFigure1);
        shapeList.add(circle1);
        log.info("extList: {}", shapeList);
        log.info("expected: {}", expected);
        compareWithOriginalList(shapeList, expected);


        expected.sort(Comparator
                .comparing(Shape::getName)
                .thenComparing(Shape::getAngles)
                .thenComparing(Shape::getColor)
        );
        shapeList.sort();

        log.info("extList: {}", shapeList);
        log.info("expected: {}", expected);
        compareWithOriginalList(shapeList, expected);
    }

    private <T extends Comparable<T>> void compareWithOriginalList(ExtList<T> extList, List<T> expected) {
        assertEquals(extList.size(), expected.size());

        for(int i = 0; i<expected.size(); i++) {
            T val1 = extList.get(i);
            T val2 = expected.get(i);
            assertEquals(val1, val2);
        }
    }
}