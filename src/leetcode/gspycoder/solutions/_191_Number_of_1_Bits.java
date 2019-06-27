package leetcode.gspycoder.solutions;

/**
 * 191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, the input will be given as signed integer type and should not affect your implementation,
 * as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 3 above the input represents the signed integer -3.
 *
 * */

public class _191_Number_of_1_Bits {

    public static class Solution1 {
        /**Doing bitwise AND operation between n and n-1 will always flip the least significant 1 bit in n to zero
         example run for the above editorial solution: input 5, n will be 5&4 and becomes 4,
         then in the next run, n will become 4&3 which is 0, thus exit the while loop.*/
        public int hammingWeight(int n) {
            int bits = 0;
            while (n != 0) {
                bits++;
                n &= (n - 1);
            }
            return bits;
        }
    }

    public static class Solution2 {
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }

    public static class Solution3 {
        public int hammingWeight(int n) {
            int bits = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & 1) == 1) {
                    bits++;
                }
                if (n == 0) {
                    return bits;
                }
                /**must use unsigned right shift operator since the problem says this is an unsigned value*/
                n >>>= 1;
            }
            return bits;
        }
    }

    public static class Solution4 {
        public int hammingWeight(int n) {
            int bits = 0;
            for (int i = 0; i < 32; i++) {
                bits += n & 1;
                n >>>= 1;
            }
            return bits;
        }
    }
}
