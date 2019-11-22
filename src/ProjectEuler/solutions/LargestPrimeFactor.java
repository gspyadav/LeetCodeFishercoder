package ProjectEuler.solutions;

public class LargestPrimeFactor {
    static long maxPrimeFactors(long n)
    {
        // Initialize the maximum prime
        // factor variable with the
        // lowest one
        long maxPrime = -1;

        // Print the number of 2s
        // that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point,
        // thus skip the even numbers
        // and iterate only for odd
        // integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;
    }


    public static void main(String[] args)
    {
        Long n = 15l;
        System.out.println(maxPrimeFactors(n));

        //n = 25698751364526l;
        n = 600851475143l;
        System.out.println(maxPrimeFactors(n));
    }
}
