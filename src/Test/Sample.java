package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sample {
    public static void main(String args[]) {
        //category, the title, the length (#ms), the average watched (#ms), views (# views).
        String strLine = "DOGS Lola barks at Oliver 34ms 34ms 17174 views ";
        String[] words = strLine.split(" ");
        System.out.println("Category "+words[0]);
        System.out.println("Views "+words[words.length-2]);
        System.out.println("Watched "+words[words.length-3].substring(0,words[words.length-3].indexOf("ms")));
        System.out.println("Length "+words[words.length-4].substring(0,words[words.length-4].indexOf("ms")));
        System.out.println();


        for(int i=1;i<words.length-4;i++){
            System.out.print(words[i]);
            if(i!=words.length-5){
                System.out.print(" ");
            }
        }
    }


    static boolean LSB(int num, int K)
    {

        boolean x = (num & (1 << (K-1))) != 0;
        return true;
    }


    public static List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> list = new ArrayList<Boolean>();

        int num=0;
        for(int i=A.length-1, j=0; i>=0; i--,j++){

            num += A[i]*Math.pow(2,j);
            System.out.println(num);
            if(num%5 == 0){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        Collections.reverse(list);
        return list;
    }

    static String removeDups(String str){
        if(str == null || str.equals("")){
            return str;
        }
        char temp[] = str.toCharArray();
        Arrays.sort(temp);

        str = new String(temp);
        return removeDupsSorted(str);

    }
    static String removeDupsSorted(String str){
        char ch[] = str.toCharArray();
        int count = 1;
        for(int i=1;i<ch.length; i++){
            if(ch[i] != ch[i-1]){
                ch[count++] = ch[i];
            }
        }
        str = new String(ch);
        return str.substring(0,count);
    }

    static int power(int x, int y){

        if(y==0){
            return 1;
        }else if(y%2 == 0){
            return power(x,y/2) * power(x,y/2);
        }else{
            return x* power(x,y/2) * power(x,y/2);
        }
    }

    public static void mergeSortedArrays(int[] arr1, int[] arr2, int[] arr3){
        int n1 =arr1.length;
        int n2 = arr2.length;
        int i=0,j=0,k=0;

        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }
        while(i<n1){
            arr3[k++] = arr1[i++];
        }
        while(j<n2){
            arr3[k++] = arr2[j++];
        }

    }


    // Function returns 1 if set, 0 if not




}
