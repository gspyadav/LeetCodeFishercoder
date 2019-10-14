package leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1213_Intersection_of_Three_Sorted_Arrays {
    public static class Solution1{
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> results = new ArrayList<>();
            for (int num : arr1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int num : arr2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int num : arr3) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Integer key : map.keySet()) {
                if (map.get(key) == 3) {
                    results.add(key);
                }
            }
            return results;
        }
    }
    public static class Solution2{
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> result = new ArrayList<>();
            if(arr1 == null || arr1.length == 0) return result;
            if(arr2 == null || arr2.length == 0) return result;
            if(arr3 == null || arr3.length == 0) return result;
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < arr1.length && j < arr2.length && k < arr3.length) {
                if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                    result.add(arr1[i]);
                    i++;
                    j++;
                    k++;
                } else if (arr1[i] < arr2[j]) {
                    i++;
                } else if (arr2[j] < arr3[k]) {
                    j++;
                } else k++;
            }
            return result;
        }
    }
}
