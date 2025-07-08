package com.example.collections;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        System.out.println("ArrayList get(1): " + arrayList.get(1));

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        System.out.println("LinkedList get(0): " + linkedList.get(0));

        MyQueue<String> queue = new MyQueue<>();
        queue.add("First");
        queue.add("Second");
        System.out.println("Queue peek: " + queue.peek());

        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        stack.push(200);
        System.out.println("Stack pop: " + stack.pop());

        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("name", "Alice");
        map.put("city", "Kyiv");
        System.out.println("Map get(name): " + map.get("name"));
    }
}