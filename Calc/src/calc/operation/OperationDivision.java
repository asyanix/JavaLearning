package calc.operation;

public class OperationDivision
{
    private int div;
    public OperationDivision(int a) { this.div=a; }

    public void div(int b) { div /= b; }
    
    public int getDiv() { return div; }
}