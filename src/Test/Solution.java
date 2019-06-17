package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Result {

    /*
     * Complete the 'customSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void customSort(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sol = new ArrayList<>();

        for (int val : arr) {
            int count;
            if(!map.containsKey(val)){
                count = 0;
            }else{
                count = map.get(val);
            }
            //int count = map.getOrDefault(val, 0);
            map.put(val, count + 1);
            sol.add(val);
        }

        SortComparator comp = new SortComparator(map);

        Collections.sort(sol, comp);

        for (Integer i : sol) {
            System.out.println(i);
        }

    }

}

class SortComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> newMap;

    SortComparator(Map<Integer, Integer> compMap) {
        this.newMap = compMap;
    }

    @Override
    public int compare(Integer val1, Integer val2) {

        int compare = newMap.get(val2).compareTo(newMap.get(val1));

        if (compare == 0)
            return val1.compareTo(val2);
        else
            return compare*-1;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        Result.customSort(arr);

        bufferedReader.close();
    }
}
