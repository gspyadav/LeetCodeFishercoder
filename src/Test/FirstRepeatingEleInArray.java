package Test;

import java.util.ArrayList;
import java.util.List;

public class FirstRepeatingEleInArray {
    static int printFirstRepeating(int arr[])
    {
        List<Integer> list = new ArrayList<>();
        int min = -1;

        for(int i=arr.length-1 ; i>=0; i--){
            if(list.contains(arr[i])){
                min = i;
            }else{
                list.add(arr[i]);
            }
        }
        if(min!= -1){
            return arr[min];
        }else{
            return -1;
        }
    }
}
