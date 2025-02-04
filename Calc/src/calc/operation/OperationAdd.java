package calc.operation;

public class OperationAdd
{
    private int sum;
    public OperationAdd() { sum=0; } 

    public void add(int b) { sum += b; }

    public int getSum() { return sum; }
}