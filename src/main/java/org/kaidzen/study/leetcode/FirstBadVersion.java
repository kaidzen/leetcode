package org.kaidzen.study.leetcode;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left)/2;
            if (!isBadVersion(mid)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean isBadVersion(int n) {
        int bad = 4;
        return n == bad;
    }



    public static void main(String[] args) {
        //{[1, 2, ..., n}
        FirstBadVersion badVersion = new FirstBadVersion();
        System.out.println(badVersion.firstBadVersion(5));
    }
}
