package calc.operation;

public class OperationMultiply
{
    private int product;
    public OperationMultiply() { product=1; } 

    public void mul(int b) { product *= b; }

    public int getProduct() { return product; }
}