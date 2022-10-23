package MaxDivisors;

public class NumberDivisors {
    final int number;
    final int numDivisors;
    public NumberDivisors(int number, int numDivisors){
        this.number = number;
        this.numDivisors = numDivisors;
    }

    @Override
    public String toString() {
        return "NumberDivisors{" +
                "number=" + number +
                ", numDivisors=" + numDivisors +
                '}';
    }
}
