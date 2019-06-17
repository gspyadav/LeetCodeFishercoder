package leetcode;

import java.util.*;

public class SortElementsByFreq {

    public static void main(String args[]){
        int arr[] = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length;i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count + 1);
            list.add(arr[i]);
        }
        SortComparator sortcmp = new SortComparator(map);

        Collections.sort(list,sortcmp);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }

}

class SortComparator implements  Comparator<Integer>{

    Map<Integer, Integer> freqMap;

    SortComparator(Map<Integer, Integer> map){
        freqMap = map;
    }

    @Override
    public int compare(Integer o1, Integer o2) {

        int freq = freqMap.get(o2).compareTo(freqMap.get(o1));

        int val = o1.compareTo(o2);

        if(freq == 0){
            return val;
        }else
            return freq;
    }
}
