package Test;

import java.util.*;

public class BiWeeklyContest11 {

    public int missingNumber(int[] arr) {
        int len = arr.length;
        int d = Math.min(Math.abs(arr[1] - arr[0]), Math.abs(arr[len - 1] - arr[len - 2]));
        System.out.println("d  " + d);

        boolean isNeg = (arr[1] - arr[0]) > 0 ? false : true;

        for (int i = 0; i < len - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) > d) {
                return arr[i] + (isNeg ? -d : d);
            }
        }
        return 0;
    }

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        int s1 = slots1.length;
        int s2 = slots2.length;
        int i = 0, j = 0;


        Arrays.sort(slots1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer itemIdOne = o1[0];
                Integer itemIdTwo = o2[0];
                return itemIdOne.compareTo(itemIdTwo);
            }
        });

        Arrays.sort(slots2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer itemIdOne = o1[0];
                Integer itemIdTwo = o2[0];
                return itemIdOne.compareTo(itemIdTwo);
            }
        });


        while (i < s1 && j < s2) {
            if ((slots1[i][0] >= slots2[j][0] && slots1[i][0] <= slots2[j][1]) ||
                    (slots2[j][0] >= slots1[i][0] && slots2[j][0] <= slots1[i][1])) {
                int start = Math.max(slots1[i][0], slots2[j][0]);
                int end = Math.min(slots1[i][1], slots2[j][1]);
                if (end - start >= duration) {
                    result.add(start);
                    result.add(start + duration);
                    return result;
                }
            }
            if (slots1[i][0] > slots2[j][0]) {
                j++;
            } else if (slots1[i][0] < slots2[j][0]) {
                i++;
            } else {
                if (slots1[i][1] > slots2[j][1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return result;
    }


    public int maximizeSweetness(int[] sweetness, int K) {
        int low = 0, high = 0, sum = 0;
        for(int chunk : sweetness)
            sum += chunk;
        high = sum / (K + 1);
        while(low < high){
            int mid = low + (high - low) / 2 + ((high - low) % 2 == 1 ? 1 : 0);
            if(check(sweetness, K + 1, mid))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    boolean check(int[] sweetness, int K, int min){
        int count = 0, curr = 0;
        for(int i : sweetness){
            curr += i;
            if(curr >= min){
                count++;
                curr = 0;
            }
        }
        return count >= K;
    }





    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        Double[][] memo = new Double[n + 1][target + 1];
        return dfs(0, target, memo, prob);
    }
    double dfs(int index, int target, Double[][] memo, double[] prob) {
        if (index == prob.length && target == 0) {
            return 1.0;
        }
        if (index == prob.length) {
            return 0;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }
        double res = 0;
        if (target > 0) {
            res += dfs(index + 1, target - 1, memo, prob) * prob[index];
        }
        res += dfs(index + 1, target, memo, prob) * (1 - prob[index]);
        memo[index][target] = res;
        return res;
    }
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 2, 1, 2, 2, 1, 2, 2};

    }
}
