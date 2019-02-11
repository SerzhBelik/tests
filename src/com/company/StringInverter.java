package com.company;

public class StringInverter {

    public static String invert(String s){
        StringBuffer sb = new StringBuffer();
        MyStack<Character> stack = new MyStack(s.length());
        for (int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
