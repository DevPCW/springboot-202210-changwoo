package com.study.springboot202210changwoo;

import java.util.Scanner;

public class practice1 {

    public static void main(String[] args) {
        // 문제 1: 숫자를 하나 입력받아 입력 받은 숫자의 배수를, 500까지 더하는 프로그램을 구현하시오


        Scanner scanner = new Scanner(System.in);

        int integer = scanner.nextInt();


        int total = 0;
//        for (int i = 0; i <= 100; i++) {
//            if (i % integer == 0) {
//                total = total + i;
//            }else if (total + i > 499) {
//                break;
//            }
//            else continue;
//            System.out.println("sum = " + total + ", i = " + i);
//        }
//        System.out.println("total = " + total);

        for ( int i = 0; i < 9999; i++) {
            if(i % integer == 0) {
                total = total + i;

                if((i * integer) > 500) {
                    break;

                }
                System.out.println("sum = " + total + ", i = " + i);
                System.out.println("total = " + total);
            }

        }

    }

}


