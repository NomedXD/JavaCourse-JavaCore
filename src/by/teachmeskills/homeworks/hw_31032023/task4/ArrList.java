package by.teachmeskills.homeworks.hw_31032023.task4;

import java.util.Arrays;

public class ArrList<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int CURRENT_CAPASITY;
    /*
    Понятно, что такая обработка ошибок не самая лучшая, но в любом случае при попытке, например
    добавить на позицию 100 элемент в ArrayList, у которого size <100, то программа вылетает. Поэтому уж лучше так :)
     */

    public ArrList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Provided capacity is <= 0");
        } else {
            list = (T[]) new Object[capacity];
            setCURRENT_CAPASITY(capacity);
        }
    }

    public ArrList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        setCURRENT_CAPASITY(DEFAULT_CAPACITY);
    }

    public int getCURRENT_CAPASITY() {
        return CURRENT_CAPASITY;
    }

    private void setCURRENT_CAPASITY(int CURRENT_CAPASITY) {
        this.CURRENT_CAPASITY = CURRENT_CAPASITY;
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Provided item is null");
        }
        if (size >= getCURRENT_CAPASITY()) {
            setCURRENT_CAPASITY((getCURRENT_CAPASITY() * 3) / 2 + 1);
            list = Arrays.copyOf(list, getCURRENT_CAPASITY());
        }
        list[size++] = item;
    }

    public void add(int index, T item) {
        if (index < 0) {
            throw new IllegalArgumentException("Provided index is < 0 ");
        }
        if (index > size) {
            throw new IllegalArgumentException("Provided index is > size ");
        }
        if (item == null) {
            throw new IllegalArgumentException("Provided item is null");
        }
        if (index >= getCURRENT_CAPASITY()) {
            setCURRENT_CAPASITY((getCURRENT_CAPASITY() * 3) / 2 + 1);
            list = Arrays.copyOf(list, getCURRENT_CAPASITY());
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Provided index is < 0 ");
        }
        if (index >= size) {
            throw new IllegalArgumentException("Provided index is >= size ");
        }
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public int indexOf(T item) {
        /*
          if(item == null)
            throw new IllegalArgumentException("Provided item is null");
         */
        if (item == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Provided item is null");
        }
        int position = indexOf(item);
        if (position < 0) {
            return;
        }
        remove(position);
    }

    public void removeAll(T[] removeList) {
        for (T item : removeList) {
            for (int i = 0; i < size; i++) {
                if (item.equals(list[i])) {
                    remove(item);
                }
            }
        }
    }

    public boolean contains(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Provided item is null");
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Provided index is < 0 ");
        }
        if (index >= size) {
            throw new IllegalArgumentException("Provided index is >= size ");
        }
        return list[index];
    }

    public void set(int index, T item) {
        if (index < 0) {
            throw new IllegalArgumentException("Provided index is < 0 ");
        }
        if (index >= size) {
            throw new IllegalArgumentException("Provided index is >= size ");
        }
        if (item == null) {
            throw new IllegalArgumentException("Provided item is null");
        }
        list[index] = item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size - 1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }
}
