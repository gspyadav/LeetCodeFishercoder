package Test;

import java.io.IOException;
import java.util.*;

public class Test1Solution {
    public static void main(String []args) throws IOException
    {

        String text = "ab";

        String prefixString = "b";
        String suffixString = "a";

        String output = "";
        int max_prefix_count = 0, prefix_count = 0,
                max_suffix_count = 0, suffix_count = 0,
                sstr_start = 0, sstr_end = 0,
                i=0,j=0;

        while(i<text.length())
        {
            int k=i,start=-1,end=-1;
            j=0;prefix_count = 0;

            while((k<text.length() && j<prefixString.length())
                    && (text.charAt(k) != prefixString.charAt(j)))
                j++;

            while((k<text.length() && j<prefixString.length())
                    && (text.charAt(k) == prefixString.charAt(j)))
            {
                if(start == -1)
                    start = k;

                prefix_count++;
                k++; j++;
            }

            //update prefixString index as we get the new string.
            if(prefix_count > max_prefix_count)
            {
                max_prefix_count = prefix_count;
                sstr_start = start;
            }

            k=i;j=0;
            suffix_count = 0;

            while((k<text.length() && j<suffixString.length())
                    && (text.charAt(k) != suffixString.charAt(j)))
                j++;

            while((k<text.length() && j<suffixString.length())
                    && (text.charAt(k) == suffixString.charAt(j)))
            {
                suffix_count++;
                k++; j++;
            }

            end = k;

            //update prefixString index as we get the new string.
            if(suffix_count > max_suffix_count)
            {
                max_suffix_count = suffix_count;
                sstr_end = end;
            }
            i++;
        }
        System.out.println(sstr_end + "  "+ sstr_start);
        if(sstr_end>sstr_start)
            System.out.println("output:"+text.substring(sstr_start, sstr_end));
        else
            System.out.println("output:"+text.substring(0,sstr_end));


        System.out.println(calculateScore(text,prefixString,suffixString));
    }


    static String calculateScore(String text, String prefixString, String suffixString) {

        int n = text.length();

        Map<String, Integer> textScoreMap = new HashMap<>();

        for(int i =0; i<n; i++) {
            for(int j = i+1; j<=n; j++) {
                String substring = text.substring(i,j);
                int ps = 0, ss = 0, subL = substring.length();
                for(int k =0; k < subL; k++) {
                    if(k < prefixString.length()) {
                        if(substring.substring(0,k+1).equals(prefixString.substring(prefixString.length()-k-1, prefixString.length()))) {
                            ss = Math.max(k+1,ss);
                        }
                    }
                }
                for(int k =0; k < subL; k++) {
                    if(subL - k <= suffixString.length()) {
                        if(substring.substring(k).equals(suffixString.substring(0,subL-k))) {
                            ps = Math.max(subL-k, ps);
                        }
                    }
                }
                if(textScoreMap.get(substring)==null) {
                    textScoreMap.put(substring, ps+ss);
                } else {
                    textScoreMap.put(substring, Math.max(textScoreMap.get(substring), ps+ss));
                }
            }
        }
        int textScore = -1;
        Set<String> keys = textScoreMap.keySet();
        String[] resultTexts = keys.toArray(new String[keys.size()]);

        Arrays.sort(resultTexts);
        String result = "";
        for(int i = 0; i<resultTexts.length; i++) {
            if(textScore < textScoreMap.get(resultTexts[i])) {
                result = resultTexts[i];
                textScore = textScoreMap.get(resultTexts[i]);
            }
        }
        return result;
    }

    static int droppedRequests(List<Integer> requestTime) {

        Map<Integer, Integer> requestCountMap = new HashMap<>();
        if(requestTime == null || requestTime.size()==0){
            return 0;
        }

        for(int i=0;i<requestTime.size();i++){
            requestCountMap.put(requestTime.get(i), requestCountMap.getOrDefault(requestTime.get(i),0)+1);
        }
        Set<Integer> times = requestCountMap.keySet();
        Integer[] timesArray = times.toArray(new Integer[times.size()]);
        Arrays.sort(timesArray);


        int totalRequests = 0;
        int rollOverRequests =0;
        int currentSecRequests = 0;
        int tenSecRequests = 0;
        int minRequests = 0;
        int totalDrops = 0;

        for(int i=1; i<=timesArray[timesArray.length-1];i++){
            currentSecRequests = requestCountMap.getOrDefault(i,0);
            System.out.println(currentSecRequests);
            totalRequests+= currentSecRequests;
            if(currentSecRequests > 3){
                totalDrops += currentSecRequests - 3;
                rollOverRequests = currentSecRequests - 3;
            }
            if(i%10 == 0 && i%60 == 0){
                if(minRequests > 60){
                    totalDrops += minRequests - 60;
                }
                minRequests = 0;
            }
            else if(i%10 == 0){
                if(totalRequests > 20){
                    totalDrops += totalRequests - 20;
                    minRequests+=totalRequests;
                }
                totalRequests = 0;
            }
        }
        if(totalRequests > 20){
            totalDrops += totalRequests - 20;
            minRequests+=totalRequests;
        }


        return totalDrops;
    }
}
