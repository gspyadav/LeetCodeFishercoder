package ProjectEuler.solutions;

/**
 * Multiples of 3 and 5
 * <p>
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class MutiplesOf3And5 {

    public static int getSumOfMutiplesOf3And5(int target) {
        int sum = 0;
        int i = 0;

        while (3 * i < target) {
            if ((3 * i) % 5 != 0) {
                sum += 3 * i;
                //System.out.println();
            }
            i++;
        }
        i=0;
        while (5 * i < target) {
            sum += 5 * i;
            i++;
        }
        return sum;
    }


    public static void main(String args[]){
        System.out.println(getSumOfMutiplesOf3And5(1000));
    }
}
