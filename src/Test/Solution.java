package Test;
import java.io.IOException;
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
        ArrayList<Integer> songDurations = new ArrayList<>();
        songDurations.add(20);
        songDurations.add(70);
        songDurations.add(90);
        songDurations.add(30);
        songDurations.add(60);
        songDurations.add(110);
        IDsOfSongs(110,songDurations);
    }

    List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList)
    {

        HashMap<Integer, List<List<Integer>>> optimalListsmap = new HashMap<>();
        optimalListsmap.put(0, new ArrayList<>());

        for(int i =0; i<forwardRouteList.size();i++){
            for(int j=0; j<returnRouteList.size();j++){
                int totalDistance = forwardRouteList.get(i).get(1)+returnRouteList.get(j).get(1);
                if(totalDistance <= maxTravelDist ){
                    if(optimalListsmap.containsKey(totalDistance)){
                        optimalListsmap.get(totalDistance).add(new ArrayList<Integer>(Arrays.asList(forwardRouteList.get(i).get(0),returnRouteList.get(j).get(0))));
                    }else{
                        List<List<Integer>> newList = new ArrayList<>();
                        newList.add(new ArrayList<Integer>(Arrays.asList(forwardRouteList.get(i).get(0),returnRouteList.get(j).get(0))));
                        optimalListsmap.put(totalDistance,newList);
                    }
                }
            }
        }
        int maxDistance = Integer.MIN_VALUE;
        for(Integer key : optimalListsmap.keySet()){
            if(maxDistance<key){
                maxDistance = key;
            }
        }



        return maxDistance == Integer.MIN_VALUE? new ArrayList<>():optimalListsmap.get(maxDistance);
        // WRITE YOUR CODE HERE
    }



    public static ArrayList<Integer> IDsOfSongs(int rideDuration,
                                  ArrayList<Integer> songDurations)
    {
        // WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> finalresults = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<songDurations.size();i++){
            map.put(songDurations.get(i),i);
        }

        for(int i=0; i<songDurations.size();i++){
            if(map.containsKey(rideDuration-songDurations.get(i)-30) && map.get(rideDuration-songDurations.get(i)-30)!=i){
                ArrayList<Integer> result = new ArrayList<>();
                result.add(map.get(rideDuration-songDurations.get(i)-30));
                result.add(i);
                finalresults.add(result);
            }
        }
        if(finalresults.size()==1){
            return finalresults.get(0);
        }else if(finalresults.size()>1){
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> result = new ArrayList<>();
            for(int i=0; i<finalresults.size();i++){
                if(max<songDurations.get(finalresults.get(i).get(0)) || max<songDurations.get(finalresults.get(i).get(1))){
                    max = songDurations.get(finalresults.get(i).get(0)) < songDurations.get(finalresults.get(i).get(1))?songDurations.get(finalresults.get(i).get(1)):songDurations.get(finalresults.get(i).get(0));
                    result = finalresults.get(i);
                }
            }
            return result;
        }else{
            return new ArrayList<>();
        }

    }
}
