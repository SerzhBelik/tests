package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<Node<T>>{
    private Node first;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iter();
    }

    public ListIterator<Node<T>> listIterator(){
        return new ListIter();
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (isEmpty()){
            last = newNode;
        }else{
            first.setPrevious(newNode);
        }
        first = newNode;
        size++;
    }


    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        if (isEmpty()){
            last = null;
        }else{
            first.setPrevious(null);
        }
        size--;
        return (T) oldFirst.getValue();
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()){
            first = newNode;
        }else{
            newNode.setPrevious(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = last;
        if (last.getPrevious() != null){
            last.getPrevious().setNext(null);
        } else{
            first = null;
        }
        last = last.getPrevious();
        size--;
        return (T) oldLast.getValue();
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        return (T) first.getValue();
    }

    public T getLast() {
        return (T) last.getValue();
    }

    public int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (isIndexNegative(index)) {
            insertFirst(item);
            return;
        }
        if (isIndexOutOfSize(index)) {
            insertLast(item);
            return;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        newNode.getNext().setPrevious(newNode);
        current.setNext(newNode);
        size++;
    }


    private boolean isIndexNegative(int index) {
        return index <= 0;
    }

    private boolean isIndexOutOfSize(int index) {
        return index >= size;
    }

    public boolean delete(T item) {
        if (isEmpty()) {
            return false;
        }
        if (isThisItem(item)) {
            deleteFirst();
            return true;
        }
        Node current = first;
        while (current!= null &&
                !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (isItemNull(current)){
            return false;
        }
        if (isItemLast(current)){
            deleteLast();
            return true;
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        current.setPrevious(null);
        current.setNext(null);
        size--;
        return true;
    }

    private boolean isItemLast(Node current) {
        return current == last;
    }

    private boolean isItemNull(Node current) {
        return current == null;
    }

    private boolean isThisItem(T item) {
        return first.getValue().equals(item);
    }

    private class Iter implements Iterator<Node<T>> {
        Node current = new Node(null,first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public Node<T> next() {
            current = current.getNext();
            return current;
        }


    }

    private class ListIter implements ListIterator<Node<T>>{
        Node current = new Node(null,first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public Node<T> next() {
            if (!isItemNull(current.getNext())) {
                Node temp = current;
                current = current.getNext();
                return temp;
            } else {
                throw new NoSuchElementException("There is not next element in the list!");
            }
        }

        @Override
        public boolean hasPrevious() {
            return current.getPrevious() != null;

        }

        @Override
        public Node<T> previous() {
            if (isItemNull(current.getPrevious())) {
                Node temp = current;
                current = current.getPrevious();
                return temp;
            } else {
                throw new NoSuchElementException("There is not previous element in the list!");
            }
        }

        @Override
        public int nextIndex() {
            if (hasNext()){
                return indexOf((T)current)+1;
            } else {
                return size();
            }

        }

        @Override
        public int previousIndex() {
            if (hasPrevious()){
                return indexOf((T)current) - 1;
            } else {
                return -1;
            }

        }

        @Override
        public void remove() {
            current.getPrevious().setNext(current.getNext());
            if (!isItemNull(current.getNext())){
                current.getNext().setPrevious(current.getPrevious());
                current = current.getNext();
            } else {
                current = current.getPrevious();
                current.setNext(null);
            }


            size--;
        }

        @Override
        public void set(Node<T> tNode) {
            current = tNode;
            size++;

        }

        @Override
        public void add(Node<T> tNode) {
            if (isEmpty()){
                current = tNode;
                insertFirst((T)tNode);
                size++;
                return;
            }
            tNode.setNext(current.getNext());
            tNode.setPrevious(current);

            if (!isItemNull(current.getNext()))current.getNext().setPrevious(tNode);
            current.setNext(tNode);
//            System.out.println(current.getNext().toString());
            current = current.getNext();
            size++;

        }
    }

    @Override
    public String toString() {
        Node current = first;
        String s = "";
        while (current != null) {
            s += current.getValue() + " ";
            current = current.getNext();
        }
        return s;
    }


}
