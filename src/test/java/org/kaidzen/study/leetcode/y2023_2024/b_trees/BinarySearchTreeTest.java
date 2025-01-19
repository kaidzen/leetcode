package org.kaidzen.study.leetcode.y2023_2024.b_trees;

import org.junit.jupiter.api.Test;

import java.util.List;

class BinarySearchTreeTest {

    @Test
    void verify_insertion_and_proper_inOrder() {
        final List<Integer> nodes = List.of(8, 4, 1, 7, 12, 9, 14, 15);

        BinarySearchTree bst = new BinarySearchTree();

        nodes.forEach(bst::insertNode);

        bst.printInOrder(bst.getRoot());
    }
}