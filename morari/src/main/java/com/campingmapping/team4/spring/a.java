package com.campingmapping.team4.spring;

import java.util.stream.IntStream;

public class a {
    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            for (int k = 1; k <= 4 - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        for (int i = 0; i <= 3; i++) {
            for (int k = 1; k <= i + 1; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }

    // for (int i = 1; i <= 9; i++) {
    // for (int j = 1; j <= 9; j++) {
    // System.out.print(j + " * " + i + " = " + (i * j) + "\t");
    // }
    // System.out.println();
    // }

}
// public static void main(String[] args) {
// int n = 9;
// // 使用Lambda表达式打印出九九乘法表
// IntStream.rangeClosed(1, n)
// .forEach(i -> {
// IntStream.rangeClosed(1, n)
// .forEach(j -> {
// System.out.print(j + " x " + i + " = " + i * j + "\t");
// });
// System.out.println();
// });
// }
