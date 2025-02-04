package calc;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Для начала работы с калькулятором выберите операцию");
        System.out.println("Для завершения работы с калькулятором введите end");
        System.out.println("Доступные операции: +  -  *  /  &");
        System.out.println("Вводите число, далее операцию, далее число и т.д.");
        
        Scanner scanner = new Scanner(System.in);
        int result = readNumber(scanner);

        while (true) { 
            String operation = scanner.nextLine().trim();
            if (operation.equals("end")) {
                System.out.println("Калькулятор завершает работу.");
                System.out.println("Результат работы: " + result);
                break;
            }
            result = performOperation(scanner, result, operation);
            System.out.println("Результат операции: " + result);
        }
    }

    private static int readNumber(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено некорректное число");
            return readNumber(scanner);
        }
    }

    private static int performOperation(Scanner scanner, int number, String operation) {
        Calculator calc = new Calculator();
        switch (operation) { 
            case "+" -> { return calc.sum(number, readNumber(scanner)); }
            case "-" -> { return calc.sub(number, readNumber(scanner)); }
            case "*" -> { return calc.multiply(number, readNumber(scanner)); }
            case "/" -> { return calc.division(number, readNumber(scanner)); }
            case "&" -> { return calc.logical_multiply(number, readNumber(scanner)); }
            default -> {
                System.out.println("Неверная операция. Попробуйте снова.");
                return number;
            }
        }
    }
}