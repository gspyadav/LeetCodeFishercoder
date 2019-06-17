package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class SampleJava {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        customSort(arr);

        bufferedReader.close();
    }

    public static void customSort(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sol = new ArrayList<>();

        for (int val : arr) {
            int count = map.getOrDefault(val, 0);
            map.put(val, count + 1);
            sol.add(val);
        }

        SortComparator comp = new SortComparator(map);

        Collections.sort(sol, comp);

        for (Integer i : sol) {
            System.out.println(i);
        }

    }


    public static long kSub(int k, List<Integer> nums) {
        // Write your code here
        int mod[] = new int[k];
        Arrays.fill(mod, 0);
        int cumSum = 0;
        for (int val : nums) {
            cumSum += val;
            mod[((cumSum % k) + k) % k]++;
        }

        int result = 0;

        for (int i = 0; i < k; i++){
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;
        }

        result += mod[0];

        return result;

    }
}
