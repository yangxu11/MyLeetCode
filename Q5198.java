package leetcode;

/**
 * 丑数III
 *
 * @author yx
 * @create 2019-09-22  12:04
 **/
public class Q5198 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long start = 1, end = 2000000000;
        while (start < end) {
            long mid = (start + end) / 2;
            long uglyNum = findUgly(a, b, c, mid);
            if (uglyNum >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int)start;
    }

    private long findUgly(int a, int b, int c, long n) {
        long n1 = n / a + n / b + n / c;

        long n2 = n / gcm(a, b) + n / gcm(a, c) + n / gcm(b, c);

        long n3 = n / gcm(gcm(a, b), c);

        return n1 - n2 + n3;
    }

    private long gcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
