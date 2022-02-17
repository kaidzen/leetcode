package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.Trie;

import java.util.*;

public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0) {
            return Collections.emptyList();
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, trie, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, Set<String> res, Trie trie, String currentStr) {
        char ch = board[i][j];
        if (ch == '$') {
            return;
        }
        board[i][j] = '$';
        Trie current = trie.getChildren()[ch - 'a'];
        if (current != null) {
            String str = currentStr + ch;
            if (current.isEndOfWord()) {
                res.add(str);
            }
            if (i < board.length - 1) {
                dfs(board, i + 1, j, res, current, currentStr);
            }
            if (j < board[0].length - 1) {
                dfs(board, i, j + 1, res, current, currentStr);
            }
            if (i > 0) {
                dfs(board, i - 1, j, res, current, currentStr);
            }
            if (j > 0) {
                dfs(board, i, j - 1, res, current, currentStr);
            }
        }
        board[i][j] = ch;
    }

    public static void main(String[] args) {
        WordSearch2 search2 = new WordSearch2();
//        Input:
//        board = [
//                    ['o','a','a','n'],
//                    ['e','t','a','e'],
//                    ['i','h','k','r'],
//                    ['i','f','l','v']
//                ]
//        words = ["oath","pea","eat","rain"]
//
//        Output: ["eat","oath"]
        List<String> words = search2.findWords(new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"});
        System.out.println(words);
    }
}
