package sort;

/**
 * Реализации алгоритма быстрой сортировки QuickSort для массивов типа int.
 * Все методы не являются потокобезопастными.
 * @author Артем Барышников
 */
public class QuickSort {

    /**
     * Отсортировать переданный массив элементов.
     * @param values массив элементов типа int.
     */
    public static void sort(int[] values) {
        if(values.length > 1) {
            quickSort(values, 0, values.length-1);
        }
    }

    private static void quickSort(int[] values, int startIndex, int pivotIndex) {
        if(startIndex < pivotIndex) {
            int wallIndex = separate(values, startIndex, pivotIndex);
            quickSort(values, startIndex, wallIndex-1);
            quickSort(values, wallIndex+1, pivotIndex);
        }
    }

    private static int separate(int[] array, int startIndex, int pivotIndex) {
        int partitionValue = array[pivotIndex];
        int wallIndex = startIndex;

        for(int i = startIndex; i < pivotIndex; i++) {
            if(array[i] <= partitionValue) {
                wallDrop(array, i, wallIndex);
                ++wallIndex;
            }
        }

        wallDrop(array, wallIndex, pivotIndex);
        return wallIndex;
    }

    private static void wallDrop(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
