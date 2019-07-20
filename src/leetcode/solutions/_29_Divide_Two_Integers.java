package leetcode.solutions;

/**
 * 29. Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 */
public class _29_Divide_Two_Integers {

    public static class Solution1 {
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
                return Integer.MAX_VALUE;
            }
            if (dividend != Integer.MIN_VALUE
                    && Math.abs(dividend) < Math.abs(divisor)) {
                return 0;
            }
            if (divisor == Integer.MIN_VALUE) {
                return (dividend == Integer.MIN_VALUE) ? 1 : 0;
            }

            boolean flag = (dividend < 0) ^ (divisor < 0);
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            int[] num = new int[40];
            int[] multiple = new int[40];
            num[1] = divisor;
            multiple[1] = 1;

            for (int i = 2; i < 32 && num[i - 1] < 0; ++i) {
                num[i] = num[i - 1] << 1;
                multiple[i] = multiple[i - 1] << 1;
            }

            int result = 0;
            int index = 1;
            while (num[index] < 0) {
                ++index;
            }
            index -= 1;

            while (dividend <= divisor) {
                while (dividend <= num[index]) {
                    result += multiple[index];
                    dividend -= num[index];
                }
                --index;
            }
            return !flag ? result : -result;
        }
    }
    public static class Solution2 {
        public int divide(int dividend, int divisor) {
            // Calculate sign of divisor i.e.,
            // sign will be negative only iff
            // either one of them is negative
            // otherwise it will be positive
            int sign = ((dividend < 0) ^
                    (divisor < 0)) ? -1 : 1;

            // Update both divisor and
            // dividend positive
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            // Initialize the quotient
            int quotient = 0;

            while (dividend >= divisor)
            {
                dividend -= divisor;
                ++quotient;
            }

            return sign * quotient;
        }
    }
}
