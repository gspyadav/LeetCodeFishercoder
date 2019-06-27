package leetcode.gspycoder.solutions;

/**
 * 66. Plus One
 * <p>
 * Given a non-negative number represented as an array of digits, plus one to the number. The digits
 * are stored such that the most significant digit is at the head of the list.
 */
public class _66_Plus_One {
    public static void main(String arg[]){
        int arr[] = {1,2,3,4,5,9,1,9};
        arr = new Solution1().plusOne(arr);
        for(int a:arr){
            //System.out.println(a);
        }
    }

    public static class Solution1 {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            System.out.println(len);
            int[] temp = digits;
            System.out.println(temp.length);

            for (int i = len - 1; i >= 0; i--) {
                System.out.println("Old Value: "+temp[i]);
                if (temp[i] + 1 == 10) {
                    temp[i] = 0;
                } else {
                    temp[i] += 1;
                    return temp;
                }
                System.out.println("new Value: "+temp[i]);
            }
            if (temp[0] == 0) {
                int[] res = new int[len + 1];
                res[0] = 1; //all the rest of the numbers should all be zeroes, so we don't need to copy from the original array
                return res;
            } else {
                return temp;
            }
        }
    }
}
