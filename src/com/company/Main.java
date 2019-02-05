
package com.company;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] argv) {

        PrintWriter pw;
        Scanner sc;

        sc = new Scanner(System.in);
        String a = sc.nextLine();
        pw = new PrintWriter(System.out);
        String[] b = a.split(" ");

        for (int i = 1; i < b.length; i++){
            while (b[0].length() > b[i].length()) {
                StringBuffer c = new StringBuffer(b[i]);
                c.insert(0, 0);
                b[i] = c.toString();
            }
            while (b[i].length() > b[0].length()) {
                StringBuffer c = new StringBuffer(b[0]);
                c.insert(0, 0);
                b[0] = c.toString();
            }


            if (b[0].compareTo(b[i]) < 0){
                b[0] = b[i];
            }
        }
        System.out.println(b[0]);

        pw.close();

    }
}