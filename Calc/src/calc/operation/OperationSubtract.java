package calc.operation;

public class OperationSubtract
{
    private int sub;
    public OperationSubtract(int a) { this.sub=a; }

    public void sub(int b) { sub -= b; }
    
    public int getSub() { return sub; }
}