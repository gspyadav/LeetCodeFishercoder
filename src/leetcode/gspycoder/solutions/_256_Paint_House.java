package leetcode.gspycoder.solutions;

/**
 * _256 Paint House
 *
 * There are a row of  n  houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two Adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a   cost matrix. For example,   is the cost of painting house 0 with color red;   is the cost of painting house 1 with color green, and so on... Find the Minimum cost to paint all houses.n x 3costs[0][0]costs[1][2]
 *
 * Note:
 * All costs are positive integers.
 */

public class _256_Paint_House {

    public static class Solution1 {
        public int minCost(int[][] costs) {
            if (costs == null || costs.length == 0) {
                return 0;
            }
            for (int i = 1; i < costs.length; i++) {
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
                costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
            }
            int n = costs.length - 1;
            return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
        }
    }
}
