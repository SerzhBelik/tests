package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        ListIterator<Node<String>> iter = mll.listIterator();
        ArrayList<String> list = new ArrayList<>();

        iter.add(new Node<String>("a"));
        iter.add(new Node<String>("b"));
        iter.add(new Node<String>("c"));
        iter.add(new Node<String>("d"));
        iter.add(new Node<String>("f"));
        iter.remove();

        System.out.println(mll.toString());

    }
}
