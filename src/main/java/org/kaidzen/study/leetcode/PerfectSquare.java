package org.kaidzen.study.leetcode;

public class PerfectSquare {

    public boolean isPerfectSquare2(int num) {
        if (num < 2) {
            return true;
        }

        long start = 2;
        long end = num / 2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long checked = mid * mid;
            if (checked == num) {
                return true;
            } else if (checked > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            } else if (i * i > num) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Input: 16
//        Output: true
        PerfectSquare prefect = new PerfectSquare();
        System.out.println(prefect.isPerfectSquare(16));

//        Input: 14
//        Output: false
        System.out.println(prefect.isPerfectSquare(14));
    }
}
