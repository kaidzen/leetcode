package org.kaidzen.study.other;

public class ViralAdvertising {

    public static void main(String[] args) {
        ViralAdvertising adv = new ViralAdvertising();

        System.out.println(adv.advertising(5));
    }

    public int advertising(int n) {
        int friends = 5;
        int regress = 2;
        int sum = 0;
        int liked = 0;
        for (int i = 0; i < n; i++){
            if (i == 0){
                 liked = friends / regress;
                 sum += liked;
                 continue;
            }
            liked = liked * 3;
            sum += liked / regress;
            liked = liked / 2;
        }
        return sum;
    }
}
