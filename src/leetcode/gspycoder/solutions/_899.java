package leetcode.gspycoder.solutions;

import java.util.Arrays;

public class _899 {
    public static class Solution1 {
        public static String orderlyQueue(String S, int K) {
            int len = S.length();
            if(K >len){
                char[] c = S.toCharArray();
                Arrays.sort(c);
                return new String(c);
            }
            int maxCharIndex = 0;
            char maxChar = S.charAt(0);
            boolean flag = false;
            System.out.println(maxCharIndex);
            System.out.println(maxChar + " ---\n");
            if(len>=2){
                if(S.charAt(1)<S.charAt(0)){
                    flag = true;
                }
            }
            for(int i=1; i<K;i++){
                System.out.println("maxChar: "+maxChar+ " S.charAt(i):"+S.charAt(i));
                if(S.charAt(i) < maxChar){
                    System.out.println(" in if block");
                    //maxCharIndex = i-1;
                    // maxChar = S.charAt(i-1);
                    flag = true;
                }else if(S.charAt(i) > maxChar){
                    System.out.println(" in else if block");
                    maxCharIndex = i;
                    maxChar = S.charAt(i);
                    flag = true;

                }
            }
            if(maxCharIndex < K && flag){
                if(maxCharIndex == 0){
                    System.out.println(maxCharIndex);
                    return orderlyQueue( S.substring(maxCharIndex+1,len)+maxChar ,K);
                }else{
                    return orderlyQueue( S.substring(0,maxCharIndex)+S.substring(maxCharIndex+1,len)+maxChar ,K);
                }
            }else{
                return S;
            }
        }
    }
}
