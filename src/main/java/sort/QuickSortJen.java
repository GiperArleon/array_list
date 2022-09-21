package sort;

/**
 * Реализации алгоритма быстрой сортировки QuickSort для элементов произвольного типа.
 * Все методы не являются потокобезопастными.
 * Элементы сортируемого массива должны имплементировать интерфейс Comparable.
 * @author Артем Барышников
 */
public class QuickSortJen<Type extends Comparable<Type>> {

    /**
     * Отсортировать переданный массив элементов.
     * @param values массив элементов произвольного типа.
     */
    public void sort(Type[] values) {
        if(values.length > 1) {
            quickSort(values, 0, values.length-1);
        }
    }

    private void quickSort(Type[] values, int startIndex, int pivotIndex) {
        if(startIndex < pivotIndex) {
            int wallIndex = separate(values, startIndex, pivotIndex);
            quickSort(values, startIndex, wallIndex-1);
            quickSort(values, wallIndex+1, pivotIndex);
        }
    }

    private int separate(Type[] array, int startIndex, int pivotIndex) {
        Type partitionValue = array[pivotIndex];
        int wallIndex = startIndex;

        for(int i = startIndex; i < pivotIndex; i++) {
            if(array[i] == null)
                continue;
            if(array[i].compareTo(partitionValue) <= 0) {
                wallDrop(array, i, wallIndex);
                ++wallIndex;
            }
        }

        wallDrop(array, wallIndex, pivotIndex);
        return wallIndex;
    }

    private void wallDrop(Type[] array, int i, int j) {
        Type tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
