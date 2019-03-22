package leetcode;

import java.util.Arrays;

public class Q313 {


    public int nthSuperUglyNumber(int n, int[] primes) {

        if (n <= 0 || primes == null || primes.length == 0)
            return -1;

        int lengthOfPrime = primes.length;
        //to indicate the location in the uglyNum of each prime
        int[] primeLocation = new int[lengthOfPrime];
        for (int i = 0; i < lengthOfPrime; i++)
            // set all the location to indicate the first location
            primeLocation[i] = 0;
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;

        for (int i = 1; i < n; i++) {

            int min = uglyNum[primeLocation[0]] * primes[0];
            for (int j = 1; j < lengthOfPrime; j++) {
                if (uglyNum[primeLocation[j]] * primes[j] < min) {
                    min = uglyNum[primeLocation[j]] * primes[j];
                }

            }
            for (int j = 0; j < lengthOfPrime; j++) {
                if (uglyNum[primeLocation[j]] * primes[j] == min) {
                    primeLocation[j] += 1;
                }
            }

            uglyNum[i] = min;

        }

        System.out.println(Arrays.toString(uglyNum));

        return uglyNum[n - 1];
    }
}



