package com.example.collections;

import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] data = new Object[10];
    private int size = 0;

    public void push(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public T peek() {
        if (size == 0) throw new EmptyStackException();
        return (T) data[size - 1];
    }

    public T pop() {
        if (size == 0) throw new EmptyStackException();
        T value = (T) data[--size];
        data[size] = null;
        return value;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}