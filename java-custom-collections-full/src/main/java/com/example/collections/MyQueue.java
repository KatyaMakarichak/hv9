package com.example.collections;

public class MyQueue<T> {
    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(T value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    public T poll() {
        if (head == null) return null;
        T value = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}