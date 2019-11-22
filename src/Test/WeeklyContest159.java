package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WeeklyContest159 {

    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;

        double slope = getSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0],coordinates[1][1]);
        System.out.println(slope);

        for(int i=0; i<coordinates.length-1;i++){
            if(slope != getSlope(coordinates[i][0], coordinates[i][1], coordinates[i+1][0],coordinates[i+1][1])){
                return false;
            }
        }
        return true;
    }

    public static double getSlope(int x1,int y1, int x2, int y2){
        if(x1 == x2) return Double.MAX_VALUE;
        double slope = (double) (y2-y1)/(double) (x2-x1);
        return slope;
    }



    public static class Trie{
        String folder;
        HashSet<Trie> childs;
        public boolean isFolder;
        Trie(String f){
            childs = new HashSet<>();
            folder=f;
        }
    }

    public List<String> removeSubfolders(String[] folder) {

        Trie root = new Trie("root");
        List<String> list = new ArrayList<>();
        for(String str: folder){
            String[] sub = str.split("/");
            Trie temp = root;
            for(String subfolder: sub){
            }

        }


        return list;
    }

    public static int balancedString(String s) {

        int result = Integer.MAX_VALUE;
        int min = 0;
        int len = s.length();
        int accCount = len/4;
        String str ="";
        System.out.println("accCount: "+accCount+"    len:"+len);
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<len;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character c: map.keySet()){
            System.out.println("C:"+c+"  : "+map.get(c));
            if(map.get(c)>accCount){
                min+=map.get(c)-accCount;
                map2.put(c,map.get(c)-accCount);
            }
        }

        int start = 0;
        int end =0;

        if(min == 0){
            return 0;
        }

        while(start<len && end < len){
            if(min == 0){
                while(start<end){
                    result = Math.min(result, end-start);
                    if(map2.keySet().contains(s.charAt(start))  && map2.get(s.charAt(start))>0){
                        map2.put(s.charAt(start), map2.get(s.charAt(start))+1);
                        min++;
                        start++;
                        break;
                    }
                    start++;
                }
            }
            if(map2.keySet().contains(s.charAt(end)) && map2.get(s.charAt(end))>0){
                min--;
                map2.put(s.charAt(end), map2.get(s.charAt(end))-1);
            }
            end++;
        }
        if(min == 0){
            result = Math.min(result, end-start);
        }


        return result;
    }


    public static void main(String args[]){
        int[][] arr = new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};

        String str = "WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE";

        System.out.println(balancedString(str));
    }
}
