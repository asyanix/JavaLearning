package calc;

import calc.operation.*;

public class Calculator
{
    public int sum(int... a)
    {
        OperationAdd op = new OperationAdd();
        for(int i:a) { op.add(i); }

        return op.getSum();
    }
    
    public int sub(int... a)
    {
        OperationSubtract op = new OperationSubtract(a[0]);
        for (int i = 1; i < a.length; i++) { op.sub(a[i]); }

        return op.getSub();
    }

    public int multiply(int... a)
    {
        OperationMultiply op = new OperationMultiply();
        for(int i:a) { op.mul(i); }

        return op.getProduct();
    }

    public int division(int... a)
    {
        OperationDivision op = new OperationDivision(a[0]);
        for (int i = 1; i < a.length; i++) { op.div(a[i]); }

        return op.getDiv();
    }

    public int logical_multiply(int... a)
    {
        OperationLogicalMultiply op = new OperationLogicalMultiply(a[0]);
        for (int i = 1; i < a.length; i++) { op.log_mul(a[i]); }

        return op.getProduct();
    }
}