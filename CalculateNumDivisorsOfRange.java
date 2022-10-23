package MaxDivisors;

public class CalculateNumDivisorsOfRange implements Runnable {
    private final int from;
    private final int to;
    private NumberDivisors result;

    public CalculateNumDivisorsOfRange(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public NumberDivisors getResult() {
        return result;
    }


    @Override
    public void run() {
        result = MaxDivisorsSingle.maxDivisorsOfRange(from,to);
    }
}
