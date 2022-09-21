package list;

import sort.QuickSortJen;

/**
 * Реализации коллекции ArrayList.
 * Все методы не являются потокобезопастными.
 * Элементы коллекции должны имплементировать интерфейс Comparable для возможности сортировки.
 * @author Артем Барышников
 */
@SuppressWarnings("unchecked")
public class ExtArrayList<Type extends Comparable<Type>> implements ExtList<Type> {

    private static final int START_SIZE = 100;
    private int currentPosition = 0;
    private Type[] buffer = (Type[]) new Comparable[START_SIZE];
    private final QuickSortJen<Type> quickSortJen = new QuickSortJen<>();

    /**
     * Добавить элемент в коллекцию.
     * Допускается добавление null.
     * Динамически увеличивает размер буфера на 50% от его текущего размера при необходимости.
     * @param element элемент который нужно добавить.
     * @return {@code true} если элемент успешно добавлен.
     */
    @Override
    public boolean add(Type element) {
        if(currentPosition >= buffer.length)
            increaseBuffSize();
        buffer[currentPosition] = element;
        currentPosition++;
        return true;
    }

    /**
     * Получить элемент из коллекции по его индексу.
     * Если индекс за границами массива возвращается null.
     * @param index индекс элемента который нужно получить.
     * @return элемент коллекции.
     */
    @Override
    public Type get(int index) {
        if(index < 0 || index >= currentPosition)
            return null;
        return buffer[index];
    }

    /**
     * Удалить элемент из коллекции по его индексу.
     * Если индекс за границами массива возвращается null.
     * Динамически уменьшает размер буфера на 50% от его текущего размера при необходимости.
     * @param index индекс элемента который нужно удалить.
     * @return элемент удаленный из коллекции.
     */
    @Override
    public Type delete(int index) {
        if(index < 0 || index >= currentPosition)
            return null;

        Type element = buffer[index];
        currentPosition--;

        if(index == currentPosition) {
            buffer[currentPosition] = null;
        } else {
            System.arraycopy(buffer, index + 1, buffer, index, currentPosition - index);
        }

        int decriseSize = buffer.length/2;
        if(currentPosition < decriseSize) {
            decriseBuffSize(decriseSize);
        }
        return element;
    }

    /**
     * Получить размер коллекции.
     * @return размер коллекции.
     */
    @Override
    public int size() {
        return currentPosition;
    }

    /**
     * Очистить коллекцию.
     */
    @Override
    public void clearAll() {
        for(int i = 0; i < currentPosition; i++) {
            buffer[i] = null;
        }
        currentPosition = 0;
    }

    /**
     * Отсортировать коллекцию.
     * Сортируем алгоритмом QuickSort.
     * Элементы коллекции должны имплементировать интерфейс Comparable.
     */
    @Override
    public void sort() {
        quickSortJen.sort(buffer);
    }

    /**
     * Строковое представление коллекции.
     * @return элементы коллекции в виде строки, размер коллекции и размер буфера коллекции.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < currentPosition; i++) {
            stringBuilder.append(buffer[i]);
            stringBuilder.append(' ');
        }
        return "vals = " + stringBuilder.toString() + "size = " + currentPosition + " allocated size = " + buffer.length;
    }

    private void increaseBuffSize() {
        Type[] newBuffer = (Type[]) new Comparable[currentPosition + currentPosition/2];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        buffer = newBuffer;
    }

    private void decriseBuffSize(int newSize) {
        Type[] newBuffer = (Type[]) new Comparable[newSize];
        System.arraycopy(buffer, 0, newBuffer, 0, newSize);
        buffer = newBuffer;
    }
}
