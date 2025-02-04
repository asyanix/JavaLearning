package calc.operation;

public class OperationDivision
{
    private int div;
    public OperationDivision(int a) { this.div=a; }

    public void div(int b) { 
        if (b == 0) {
            System.out.println("Ошибка: деление на 0 невозможно.");
            return; 
        }
        div /= b;
    }
    
    public int getDiv() { return div; }
}