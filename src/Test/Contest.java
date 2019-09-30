package Test;

import java.util.*;

public class Contest {






    public int minimumMoves(int[][] g) {
        int n = g.length;
        int[][][] f = new int[n][n][2];
        int max = 10000;

        for (int i = 0; i<n; i++)
            for (int j = 0; j<n; j++)
                for (int k = 0; k<2; k++)
                    f[i][j][k] = max;
        f[0][1][0] = 0;
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0,1,0});
        while (!q.isEmpty()){
            int[] cur = q.remove();
            int x = cur[0];
            int y = cur[1];
            int state = cur[2];
            if (state == 0){
                if (y+1<n && g[x][y+1]==0 && f[x][y][0]+1<f[x][y+1][0]){
                    f[x][y+1][0] = f[x][y][0]+1;
                    q.add(new int[]{x,y+1,0});
                }

                if (x+1<n && g[x+1][y-1]==0 && g[x+1][y]==0){
                    if (f[x+1][y][0]>f[x][y][0]+1){
                        f[x+1][y][0] = f[x][y][0]+1;
                        q.add(new int[]{x+1,y,0});
                    }
                    if (f[x+1][y-1][1]>f[x][y][0]+1){
                        f[x+1][y-1][1] = f[x][y][0]+1;
                        q.add(new int[]{x+1,y-1,1});
                    }
                }
            }
            else {
                if (x+1<n && g[x+1][y]==0 && f[x][y][1]+1<f[x+1][y][1]){
                    f[x+1][y][1] = f[x][y][1]+1;
                    q.add(new int[]{x+1,y,1});
                }

                if (y+1<n && g[x-1][y+1]==0 && g[x][y+1]==0){
                    if (f[x][y+1][1]>f[x][y][1]+1){
                        f[x][y+1][1] = f[x][y][1]+1;
                        q.add(new int[]{x,y+1,1});
                    }
                    if (f[x-1][y+1][0]>f[x][y][1]+1){
                        f[x-1][y+1][0] = f[x][y][1]+1;
                        q.add(new int[]{x-1,y+1,0});
                    }
                }
            }
        }

        if (f[n-1][n-1][0]==max) return -1;
        return f[n-1][n-1][0];
    }


    public static void main(String args[]){
        int [] arr = new int[]{1,2,2,1,1,3};
    }
}
