package org.kaidzen.study.other;

import java.util.Scanner;

public class SaveThePrisoner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cycles = scanner.nextInt();
        while (cycles-- > 0){
            System.out.print("Enter number of prisoners: ");
            int N = scanner.nextInt(); //total prisoners
            System.out.print("\n Enter number of candies: ");
            int M = scanner.nextInt(); //amount of candies
            System.out.print("\n Choose any prisoner: ");
            int S = scanner.nextInt(); //randomly choose prisoner
            System.out.println("\n Here " + cycles+1 + " will be: " + saveThePrisoner(N, M, S));
        }
    }

    public static int saveThePrisoner(int n, int m, int s) {
        return  ((m - 1) + (s - 1)) % n + 1;

    }
}
