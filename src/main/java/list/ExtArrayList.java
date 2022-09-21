package list;

import sort.QuickSortJen;
@SuppressWarnings("unchecked")
public class ExtArrayList<Type extends Comparable<Type>> implements ExtList<Type> {

    private static final int START_SIZE = 100;
    private int currentPosition = 0;
    private Type[] buffer = (Type[]) new Comparable[START_SIZE];
    QuickSortJen<Type> quickSortJen = new QuickSortJen<>();

    @Override
    public boolean add(Type element) {
        if(currentPosition >= buffer.length)
            increaseBuffSize();
        buffer[currentPosition] = element;
        currentPosition++;
        return true;
    }

    @Override
    public Type get(int index) {
        if(index < 0 || index >= currentPosition)
            return null;
        return buffer[index];
    }

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

        int decriseSize = buffer.length / 2;
        if(currentPosition < decriseSize) {
            decriseBuffSize(decriseSize);
        }
        return element;
    }

    @Override
    public int size() {
        return currentPosition;
    }

    @Override
    public void clearAll() {
        for(int i = 0; i < currentPosition; i++) {
            buffer[i] = null;
        }
        currentPosition = 0;
    }

    @Override
    public void sort() {
        quickSortJen.sort(buffer);
    }

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
        Type[] newBuffer = (Type[]) new Comparable[currentPosition + currentPosition / 2];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        buffer = newBuffer;
    }

    private void decriseBuffSize(int newSize) {
        Type[] newBuffer = (Type[]) new Comparable[newSize];
        System.arraycopy(buffer, 0, newBuffer, 0, newSize);
        buffer = newBuffer;
    }
}
