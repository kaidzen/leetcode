package org.kaidzen.study.hackerrank;

public class CanJump {

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,1,4}; //true
        int[] arr2 = new int[] {3,2,1,0,4}; //false
        final boolean res = CanJump.solution(arr);
        System.out.println(res);
    }

    public static boolean solution(int[] arr) {
        int reachable = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + arr[i]);
        }
        return true;
    }
}
