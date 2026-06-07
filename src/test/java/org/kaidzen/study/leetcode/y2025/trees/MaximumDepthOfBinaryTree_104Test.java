package org.kaidzen.study.leetcode.y2025.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaidzen.study.leetcode.util.TreeMaker;
import org.kaidzen.study.leetcode.util.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthOfBinaryTree_104Test {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(TreeMaker.create(new Integer[]{3,9,20,null,null,15,7}), 3),
                Arguments.of(TreeMaker.create(new Integer[]{1,null,2}), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void verify(TreeNode root, int size) {
        final int result = new MaximumDepthOfBinaryTree_104().maxDepth(root);

        assertEquals(size, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    void verify2(TreeNode root, int size) {
        int result = new MaximumDepthOfBinaryTree_104().maxDepth2(root);

        assertEquals(size, result);
    }
}