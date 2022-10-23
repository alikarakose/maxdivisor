package MaxDivisors;

public class MainWithThread {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int numThreads = 4;
        int maxValue = 100000;
        int range = maxValue/numThreads;
        CalculateNumDivisorsOfRange[] cRange = new CalculateNumDivisorsOfRange[numThreads];
        Thread[] tRange = new Thread[numThreads];
        for (int i=0;i<numThreads;i++) {
            int from = 1+i*range;
            int to = range+i*range;
            cRange[i] = new CalculateNumDivisorsOfRange(from,to);
            tRange[i] = new Thread(cRange[i]);
            tRange[i].start();
        }
        for (Thread thread:tRange) {
            thread.join();
        }
        int maxDivisor=1;
        int maxNumber=1;
        for (CalculateNumDivisorsOfRange calculated:cRange) {
            NumberDivisors result = calculated.getResult();
            System.out.println(result);
            if (result.numDivisors>maxDivisor) {
                maxDivisor = result.numDivisors;
                maxNumber = result.number;
            }
        }
        System.out.println("Gewinner ist " + maxNumber + " mit " + maxDivisor + ".");
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nTotal elapsed time:  " + (elapsedTime/1000.0) + " seconds.\n");

        int processors = Runtime.getRuntime().availableProcessors();
        if (processors == 1)
            System.out.println("Your computer has only 1 available processor.\n");
        else
            System.out.println("Your computer has " + processors + " available processors.\n");
    }
}
