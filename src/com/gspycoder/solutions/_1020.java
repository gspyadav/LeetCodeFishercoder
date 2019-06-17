package com.gspycoder.solutions;

public class _1020 {
    public static class Solution {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        public int numEnclaves(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                        if (A[i][j] == 1)
                            dfs(A, m, n, i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++)
                    if (A[i][j] == 1)   count ++;
            }
            return count;
        }
        public void dfs(int[][] A, int m, int n, int x, int y) {
            if (x >= m || x < 0 || y >= n || y < 0 || A[x][y] == 0) return;
            A[x][y] = 0;
            for (int[] d : dirs)
                dfs(A, m, n, x+d[0], y+d[1]);
        }
    }
}
