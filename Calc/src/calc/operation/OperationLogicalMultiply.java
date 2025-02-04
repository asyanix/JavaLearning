package calc.operation;

public class OperationLogicalMultiply
{
    private int product;
    public OperationLogicalMultiply(int a) { this.product=a; }

    public void log_mul(int b) { product &= b; }

    public int getProduct() { return product; }
}