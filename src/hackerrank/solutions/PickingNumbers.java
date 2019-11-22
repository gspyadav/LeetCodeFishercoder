package hackerrank.solutions;


import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is less than or equal to . For example, if your array is , you can create two subarrays meeting the criterion:  and . The maximum length subarray has  elements.
 *
 * Function Description
 *
 * Complete the pickingNumbers function in the editor below. It should return an integer that represents the length of the longest array that can be created.
 *
 * pickingNumbers has the following parameter(s):
 *
 * a: an array of integers
 * Input Format
 *
 * The first line contains a single integer , the size of the array .
 * The second line contains  space-separated integers .
 *
 * Constraints
 *
 * The answer will be .
 * Output Format
 *
 * A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is .
 *
 * Sample Input 0
 *
 * 6
 * 4 6 5 3 3 1
 * Sample Output 0
 *
 * 3
 * Explanation 0
 *
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e.,  and ), so we print the number of chosen integers, , as our answer.
 */
public class PickingNumbers {
    static class Result {

        /*
         * Complete the 'pickingNumbers' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY a as parameter.
         */

        public static int pickingNumbers(List<Integer> a) {
            // Write your code here
            Collections.sort(a);
            int max = 0;
            for(int i=0;i<a.size();i++){
                if(i>0 && a.get(i-1)==a.get(i)){
                    continue;
                }
                int curr = a.get(i);
                int count = 1;
                int iCopy = i;
                while(iCopy+1 <a.size() && Math.abs(curr-a.get(iCopy+1))<=1){
                    count++;
                    iCopy++;
                }
                max = Math.max(max,count);
            }

            return max;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


