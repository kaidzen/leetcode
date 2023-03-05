package org.kaidzen.study.educative;

public class HappyNumber {

    public static void main(String[] args) {
        final boolean happyNumber = HappyNumber.isHappyNumber(19);
        System.out.println(happyNumber);
    }

    public static boolean isHappyNumber(int n) {

        int num = n;
        while(num > 0 && num != 1){
            num = calculate(num);
            if(num == n){
                return false;
            }
        }
        return num == 1;
    }

    private static int calculate(int num){
        int sum = 0;
        int temp = num;
        Thread t = new Thread();
        t.start();
        while(temp != 0){
            int result = temp % 10;
            sum += result * result;
            temp = temp / 10;
        }
        return sum;
    }
}
