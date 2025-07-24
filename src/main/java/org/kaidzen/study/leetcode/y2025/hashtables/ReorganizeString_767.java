package org.kaidzen.study.leetcode.y2025.hashtables;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Max Heap approach. Calculate amount of each character. Then reverse mapping
 * value to character. Ordering it in the Priority queue.
 * Take two with the biggest values and create result string. -1 and then push
 * back to queue.
 * T = O(nlogn)
 * S = O(n)
 */
public class ReorganizeString_767 {

    public static void main(String[] args) {
        ReorganizeString_767 pairing = new ReorganizeString_767();
        String s = "aab";
        System.out.println(pairing.reorganizeString(s)); //aba
    }

    public String reorganizeString(String s) {
        int[] chars = new int[26];
        Queue<DataPair> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.first(), a.first()));
        String res = "";

        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) continue;
            queue.offer(new DataPair(chars[i], (char) ('a' + i)));
        }

        while (queue.size() > 1) {
            DataPair top1 = queue.poll();
            DataPair top2 = queue.poll();
            res += top1.second;
            res += top2.second;

            if (top1.first - 1 > 0) {
                queue.offer(top1.decreaseFirst());
            }
            if (top2.first - 1 > 0) {
                queue.offer(top2.decreaseFirst());
            }
        }
        if (!queue.isEmpty()) {
            final DataPair dataPair = queue.poll();
            if (dataPair.first == 1) {
                res += dataPair.second();
            } else {
                return "";
            }
        }
        return res;
    }


    private record DataPair(int first, char second) {
        public DataPair decreaseFirst() {
            int decreased = this.first - 1;
            return new DataPair(decreased, this.second);
        }
    }

}
