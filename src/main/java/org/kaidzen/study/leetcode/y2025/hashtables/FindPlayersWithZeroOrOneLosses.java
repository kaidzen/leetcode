package org.kaidzen.study.leetcode.y2025.hashtables;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    /**
     * Approach: HashSet
     * We use three hash sets to store the players with different numbers of losses:
     *
     * zero_loss to store players with zero loss.
     * one_loss to store players with one loss.
     * more_loss to store players with more than one loss.
     *
     * For each match match[i] = [winner, loser], two players winner and loser may need to move
     * to other sets and we update the sets they should move to. For example, if player_A is in zero_loss
     * previously, assume we encounter a match [player_X, player_A], it means player_A has one loss now,
     * so we need to remove player_A from zero_loss and add it to one_loss.
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Set<Integer> oneLosse = new HashSet<>();
        Set<Integer> moreLosse = new HashSet<>();

        for (int[] match : matches) {
            int win = match[0];
            int losse = match[1];

            if (!oneLosse.contains(win) && !moreLosse.contains(win)) {
                winners.add(win);
            }

            if (winners.contains(losse)) {
                winners.remove(losse);
                oneLosse.add(losse);
            } else if (oneLosse.contains(losse)) {
                oneLosse.remove(losse);
                moreLosse.add(losse);
            } else if (moreLosse.contains(losse)) {
                continue;
            } else {
                oneLosse.add(losse);
            }

        }
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        ans.get(0).addAll(winners);
        ans.get(1).addAll(oneLosse);

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));

        return ans;
    }
}
