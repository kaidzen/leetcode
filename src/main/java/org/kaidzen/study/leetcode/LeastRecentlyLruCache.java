package org.kaidzen.study.leetcode;

import java.util.*;

public class LeastRecentlyLruCache {

    public static void main(String[] args) {


//        LRUCache cache = new LRUCache( 2);
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

//        LRUCache cache = new LRUCache( 1);
//
//        cache.put(2, 1);
//        System.out.println(cache.get(2));       // returns 1

//        //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
//        LRUCache cache = new LRUCache( 2);
//
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));       // returns 1

        // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache cache = new LRUCache( 2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));       // returns 1
        System.out.println(cache.get(2));       // returns 1

    }

    class LRUCache1 {
        Map<Integer, Integer> orderedCache;

        public LRUCache1(int capacity) {
            this.orderedCache = new LinkedHashMap<Integer, Integer>(capacity, 0.9F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return this.orderedCache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            this.orderedCache.put(key, value);
        }
    }

    private static class LRUCache {
        int capacity;
        static final Deque<CacheEntry> queue = new LinkedList<>();
        static final Map<Integer, CacheEntry> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                CacheEntry entry = map.get(key);
                queue.remove(entry);
                queue.addFirst(entry);
                return entry.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            CacheEntry newEntry = new CacheEntry(key, value);
            if (map.containsKey(key)) {
                CacheEntry oldEntry = map.get(key);
                queue.remove(oldEntry);
                if (oldEntry.value != value) {
                    map.put(key, newEntry);
                    queue.addFirst(newEntry);
                } else {
                    map.remove(key);
                    queue.addFirst(newEntry);
                }
            }else {
                if (queue.size() == capacity){
                    CacheEntry lastEntry = queue.removeLast();
                    map.remove(lastEntry.key);
                }
                map.put(key, newEntry);
                queue.addFirst(newEntry);
            }
        }

        private static class CacheEntry {
            int key;
            int value;

            CacheEntry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
