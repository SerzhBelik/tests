package com.company;

import javax.swing.*;

public class LinearProbingHashST<Key, Value> {
    private int capacity = 97;
    private int size = 0;
    private Key DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int capacity, Key DELETED) {
        this.capacity = capacity;
        this.DELETED = DELETED;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
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
        int step = hashFuncDouble(i);
        while ((keys[i] != null) && (!keys[i].equals(DELETED))) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            i = (i + step) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        int step = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (i + step) % capacity;
        }
        return null;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        int step = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                keys[i] = DELETED;
                size--;
                return;
            }
            i = (i + step) % capacity;
        }
    }
    private int hashFuncDouble(int key){
        return 97 - key % 97;
    }

}