package calc;

public class Calc {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Hello! It's harcode examples");
        System.out.println("2 + 2 = "+calc.sum(2,2));
        System.out.println("8 - 3 - 2 = "+calc.sub(8,3,2));
        System.out.println("5 * 3 = "+calc.multiply(5,3));
        System.out.println("20 / 4 = "+calc.division(20,4));
        System.out.println("10 & 12 = "+calc.logical_multiply(10,12));
    }
}

// cd "/Users/asyachz/JavaLearning/Calc/"
// java -cp classes calc.Calc

// java -jar calc.jar
