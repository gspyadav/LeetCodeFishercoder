package hackerrank.solutions;


import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ClimbingTheLeaderboard {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int result[] = new int[alice.length];

        Map<Integer,Integer> map = new HashMap<>();
        int count = 1;
        for(int s:scores){
            if(!map.containsKey(s)){
                map.put(s,count++);
            }
        }

        for(int k=0;k< alice.length;k++){
            boolean flag = false;
            for(int i=scores.length-1;i>=0;i--){
                if(scores[i] == alice[k]){
                    result[k] = map.get(scores[i]);
                    flag = true;
                    break;
                }
                else if(scores[i] > alice[k]){
                    result[k] = map.get(scores[i])+1;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result[k] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       int[] scores = new int[]{100,100,50,40,40,20,10};
       int[] alice = new int[]{5,25,50,120};
        climbingLeaderboard(scores,alice);
    }
}
