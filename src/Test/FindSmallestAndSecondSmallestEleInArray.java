package Test;

public class FindSmallestAndSecondSmallestEleInArray {

    static int[] print2Smallest(int arr[])
    {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i=0; i< arr.length; i++){
            if(arr[i] < first){
                second = first;
                first = arr[i];
            }else if(arr[i] < second && arr[i]!=first){
                second = arr[i];
            }
        }
        if(first != Integer.MAX_VALUE && second != Integer.MAX_VALUE){
            return new int[]{first,second};
        }if(first != Integer.MAX_VALUE && second == Integer.MAX_VALUE){
            return new int[]{first};
        }
        return new int[]{};
    }
}
