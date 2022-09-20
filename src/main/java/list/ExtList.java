package list;

public interface ExtList<Type> {
    boolean add(Type element);

    Type get(int index);

    Type delete(int index);

    public int size();

    void clearAll();

    ExtList<Type> sort();
}
