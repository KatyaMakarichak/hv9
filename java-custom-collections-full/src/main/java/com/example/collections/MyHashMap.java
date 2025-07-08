package com.example.collections;

public class MyHashMap<K, V> {
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private Node<K, V>[] buckets = new Node[INITIAL_CAPACITY];
    private int size = 0;

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % buckets.length);
        Node<K, V> node = buckets[index];

        if (node == null) {
            buckets[index] = new Node<>(key, value);
        } else {
            while (true) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                if (node.next == null) break;
                node = node.next;
            }
            node.next = new Node<>(key, value);
        }
        size++;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode() % buckets.length);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = Math.abs(key.hashCode() % buckets.length);
        Node<K, V> node = buckets[index];
        Node<K, V> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }
}