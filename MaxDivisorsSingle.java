package MaxDivisors;

public class MaxDivisorsSingle {
    public static void main(String[] args) {
        int from = 2;
        int to = 10000;
        NumberDivisors pair = maxDivisorsOfRange(from,to);
        System.out.println("Among integers between " + from + " and " + to + ".");
        System.out.println("The maximum number of divisors is " + pair.numDivisors);
        System.out.println("A number with " + pair.numDivisors + " divisors is " + pair.number);

    } // end main()

    // private static Map.Entry<Integer,Integer> maxDivisorsFromRange(int from, int to) {
    static NumberDivisors maxDivisorsOfRange(int from, int to) {
        int maxDivisors = 1;  // Maximum number of divisors seen so far.
        int numWithMax = 1;   // A value of N that had the given number of divisors.
        for ( int n = from;  n <= to;  n++ ) {

            int divisorCount = getNumOfDivisors(n);

            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
                numWithMax = n;
            }
        }
        return new NumberDivisors(numWithMax,maxDivisors);
        // return new AbstractMap.SimpleEntry<Integer,Integer>(numWithMax,maxDivisors);
    }
    private static int getNumOfDivisors(int n) {
        int divisorCount = 0;

        for (int d = 1; d <= n; d++ ) {
            if ( n % d == 0 )
                divisorCount++;
        }
        return divisorCount;
    }
}
