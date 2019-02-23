package com.company;


public class Main {
    static int maxlvl; // максимальный уровень на котором сохраняется баланс при обходе левой ветки
    static float avglvl; // средний уровень на котором сохраняется баланс
    static int count;
    static double balancedProportion = 0;
    static int trueBalanced;

    public static void main(String[] args) {

        trial(10000, 3);
//        количество уровней дерева при идеальной балансировке 2
//        max lvl = 1
//        average lvl =0.328
//        balanced proportion = 0.328
        trial(10000, 7);
//        количество уровней дерева при идеальной балансировке 3
//        max lvl = 3
//        average lvl =1.04
//        balanced proportion = 0.0492
        trial(10000, 15);
//        количество уровней дерева при идеальной балансировке 4
//        max lvl = 7
//        average lvl =1.8031
//        balanced proportion = 0.0017
        trial(10000, 31);
//        количество уровней дерева при идеальной балансировке 5
//        max lvl = 13
//        average lvl =2.5161
//        balanced proportion = 0.0
        trial(10000, 63);
//        количество уровней дерева при идеальной балансировке 6
//        max lvl = 14
//        average lvl =3.1602
//        balanced proportion = 0.0
    }

    public static void trial(int loop, int treeElem){
        BST<Integer, Integer> tree;
        maxlvl = 0;
        trueBalanced = 0;
        count = 0;
        for (int j = 0; j < loop; j++) {
            tree = new BST<>();
            for (int i = 0; i < treeElem; i++) {
                int arg = ((int) (Math.random() * 200)) - 100;
                tree.put(arg, arg);
            }
//            System.out.println(tree.isBalanced(tree.root, 0));
            if(tree.isBalanced(tree.root, 0)) trueBalanced++;
//            System.out.println(trueBalanced);
            if (maxlvl < tree.level) maxlvl = tree.level;
            count = count + tree.level;

        }
        avglvl = (float) count/loop;
        balancedProportion = (double) trueBalanced/loop;
        System.out.println("max lvl = " + maxlvl);
        System.out.println("average lvl =" + avglvl);
        System.out.println("balanced proportion = " + balancedProportion);
    }
}


