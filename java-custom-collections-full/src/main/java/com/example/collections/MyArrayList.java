package com.example.collections;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] data;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
    }

    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}