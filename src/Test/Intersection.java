package Test;

import java.util.*;

public class Intersection {


    public List<Integer> countSteppingNumbers1(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (isStepping(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isStepping(int num) {
        int prev = -1;
        while (num > 0) {
            int lastDigit = num % 10;
            if (prev != -1 && Math.abs(lastDigit - prev) != 1) {
                return false;
            } else if (prev == -1) {
                prev = lastDigit;
            }
            num = num / 10;
        }
        return true;
    }

    public boolean isValidPalindrome(String s, int k) {
        String rev = s;
        rev = reverse(rev);
        int len = s.length();
        return (isPalinDP(s, rev, len, len) <= k * 2);
    }

    public int isPalinDP(String str1,
                         String str2, int len1, int len2) {
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) ==
                        str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public int minCostToMoveChips(int[] chips) {
        return 0;
    }

    public static int longestSubsequence(int[] arr, int difference) {

        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int currlen = 1;
            //Move Left
            int prev = arr[i] - difference;
            int tempi = i;
            while (map.containsKey(prev) && map.get(prev) < tempi) {
                //map.remove(prev);
                tempi = map.get(prev);
                prev = prev - difference;
                currlen++;

            }

            tempi = i;
            //Move right
            int next = arr[i] + difference;
            while (map.containsKey(next) && map.get(next) > tempi) {
                //map.remove(next);
                tempi = map.get(next);
                next = next + difference;
                currlen++;

            }
            max = Math.max(max, currlen);
        }
        return max;
    }

    public static int getMaximumGold(int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;
        int result =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = grid[i][j];
                int tempi= i;
                int tempj= j;
                while(true){
                    int top = 0;
                    int left = 0;
                    int below =0;
                    int right = 0;
                    if(tempi>0){
                        top = grid[tempi-1][tempj];
                    }
                    if(tempj>0){
                        left = grid[tempi][tempj-1];
                    }
                    if(tempi<n-1){
                        below = grid[tempi+1][tempj];
                    }
                    if(tempj<n-1){
                        right = grid[tempi][tempj+1];
                    }
                    if(left>=right && left>=top &&left>=below){
                        tempj--;
                        curr+=left;
                    }if(right>=left && right>=top &&right>=below){
                        tempj++;
                        curr+=right;
                    }if(top>=left && top>=right &&top>=below){
                        tempi--;
                        curr+=top;
                    }
                    if(below>=left && below>=top &&below>=right){
                        tempi++;
                        curr+=below;
                    }
                    result = Math.max(result,curr);
                    if(top==0 && below==0&& right==0 && left==0) {
                        break;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String args[]) {

        int[] arr = new int[]{3, 0, -3, 4, -4, 7, 6};
        System.out.println(longestSubsequence(arr, 3));
    }


}
