package list;

public interface ExtList<Type extends Comparable<Type>> {
    boolean add(Type element);

    Type get(int index);

    Type delete(int index);

    int size();

    void clearAll();

    void sort();
}
