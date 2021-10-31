package org.kaidzen.study.other;

public class TwiceAsOld {

    public static void main(String[] args) {
        TwiceAsOld twice = new TwiceAsOld();

        int result = twice.asOld(30, 7);

        System.out.println(result);

    }

    public int asOld(int dadYears, int sonYears){
        if(sonYears == 0){
            return dadYears;
        }

        return Math.abs(dadYears - (sonYears  * 2));
    }


}
