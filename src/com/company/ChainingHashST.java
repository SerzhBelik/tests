package com.company;

import java.util.LinkedList;

public class ChainingHashST<Key, Value> {
    private int capacity;
    private int size = 0;

    private LinkedList<Node>[] st;

    public ChainingHashST(int capacity) {
        if (!isPrime(capacity)){
            capacity = getPrime(capacity);
        }
        this.capacity = capacity;

        st = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            st[i] = new LinkedList<>();
        }
    }

    class Node {
        private Key key;
        private Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не должен быть null");
        }
        return true;
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                s += node.key.toString() + " ";
            }
            s += "\n";
        }

        return "ChainingHashST{" +
                "capacity=" + capacity + "\n" +
                s +
                '}';
    }

    public Value delete(Key key){
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                st[i].remove(node);
                return node.value;
            }
        }
        return null;
    }

    private boolean isPrime(int n){
        for(int j=2; (j*j <= n); j++)
            if( n % j == 0)
                return false;
        return true;
    }

    private int getPrime(int min){
        for(int i = min+1; true; i++)
            if( isPrime(i))
                return i;
    }


}
