import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Calculator {
    static String history;
    public static void simpleCalculator() throws IOException {
        int choicesList[] = {1, 2, 3, 4, 5, 6, 7};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int select = 0;
            while (true) {
                System.out.println("Enter the mode of operation");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Modulo");
                System.out.println("6. History");
                System.out.println("7. Quit");
                System.out.println("");
                int choice = Integer.parseInt(br.readLine());
                if (Arrays.stream(choicesList).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            if (select == 7) {
                break;
            } else if (select == 6) {
                History.displayHistory();
                continue;
            }
            System.out.println("\nEnter the first number");
            float num1 = Integer.parseInt(br.readLine());
            System.out.println("\nEnter the second number");
            float num2 = Integer.parseInt(br.readLine());
            System.out.println("");
            float result;
            switch (select) {
                case 1 -> {
                    result = Methods.Arithmetic.add(num1, num2);
                    System.out.println("The sum is: " + result + "\n");
                    History.addHistory(num1, num2, "+", result);
                }
                case 2 -> {
                    result = Methods.Arithmetic.subtract(num1, num2);
                    System.out.println("The difference is: " + result + "\n");
                    History.addHistory(num1, num2, "-", result);
                }
                case 3 -> {
                    result = Methods.Arithmetic.multiply(num1, num2);
                    System.out.println("The product is: " + result + "\n");
                    History.addHistory(num1, num2, "×", result);
                }
                case 4 -> {
                    result = Methods.Arithmetic.divide(num1, num2);
                    System.out.println("The quotient is: " + result + "\n");
                    History.addHistory(num1, num2, "÷", result);
                }
                case 5 -> {
                    result = Methods.Arithmetic.modulo(num1, num2);
                    System.out.println("The remainder is: " + result + "\n");
                    History.addHistory(num1, num2, "%", result);
                }
            }
        }
    }
    public static void FunctionCalculator() throws IOException {
        int choicesList[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // モードは累乗、平方根、n乗根、常用対数、自然対数、一般の対数、階乗、順列、組み合わせ、絶対値、切り上げ、切り捨て、四捨五入、終了
        while (true) {
            int select = 0;
            while (true) {
                System.out.println("Enter the mode of operation");
                System.out.println(" 1. Power");
                System.out.println(" 2. Square Root");
                System.out.println(" 3. N Root");
                System.out.println(" 4. Common Logarithm");
                System.out.println(" 5. Natural Logarithm");
                System.out.println(" 6. General Logarithm");
                System.out.println(" 7. Factorial");
                System.out.println(" 8. Permutation");
                System.out.println(" 9. Combination");
                System.out.println("10. Absolute Value");
                System.out.println("11. Ceiling");
                System.out.println("12. Floor");
                System.out.println("13. Round");
                System.out.println("14. History");
                System.out.println("15. Quit");
                System.out.println("");
                int choice = Integer.parseInt(br.readLine());
                if (Arrays.stream(choicesList).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            if (select == 15) {
                break;
            } else if (select == 14) {
                History.displayHistory();
                continue;
            }
            float num1, num2, result;
            switch (select) {
                case 1 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the exponent number");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.power(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistory(num1, num2, "^", result);
                }
                case 2 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.squareRoot(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num1, "√", result);
                }
                case 3 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the root number");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.nRoot(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistory(num2, num1, "√", result);
                }
                case 4 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.commonLogarithm(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num1, "log_{10}", result);
                }
                case 5 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.naturalLogarithm(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num1, "log", result);
                }
                case 6 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the root number");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.generalLogarithm(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    history += "log_{" + num2 + "} " + num1 + " = " + result + "\n";
                }
                case 7 -> {
                    System.out.println("\nEnter the number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.factorial(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num1, "!", result);
                }
                case 8 -> {
                    System.out.println("\nEnter the number of elements");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the number of selections");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.permutation(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistory(num1, num2, "P", result);
                }
                case 9 -> {
                    System.out.println("\nEnter the number of elements");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the number of selections");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.combination(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistory(num1, num2, "C", result);
                }
                case 10 -> {
                    System.out.println("\nEnter the number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.absoluteValue(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistoryOnSide(num1, history, result);
                }
                case 11 -> {
                    System.out.println("\nEnter the number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.ceiling(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistoryOnSide(num1, "⌈", result);
                }
                case 12 -> {
                    System.out.println("\nEnter the number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.floor(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistoryOnSide(num1, "⌊", result);
                }
                case 13 -> {
                    System.out.println("\nEnter the number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Function.round(num1);
                    System.out.println("The answer is: " + result + "\n");
                    History.addHistoryOnSide(num1, "〉", result);
                }
            }
        }
    }
    public static void trigonometricCalculator() throws IOException {
        int choicesList[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // モードはsin、cos、tan、csc、sec、cot、arcsin、arccos、arctan、終了
        while (true) {
            int select = 0;
            while (true) {
                System.out.println("Enter the mode of operation");
                System.out.println("1. Sine");
                System.out.println("2. Cosine");
                System.out.println("3. Tangent");
                System.out.println("4. Secant");
                System.out.println("5. Cosecant");
                System.out.println("6. Cotangent");
                System.out.println("7. Arcsine");
                System.out.println("8. Arccosine");
                System.out.println("9. Arctangent");
                System.out.println("10. Sinc");
                System.out.println("11. Sinh");
                System.out.println("12. Cosh");
                System.out.println("13. Tanh");
                System.out.println("14. History");
                System.out.println("15. Quit");
                System.out.println("");
                int choice = Integer.parseInt(br.readLine());
                if (Arrays.stream(choicesList).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            if (select == 15) {
                break;
            }
            if (select == 14) {
                History.displayHistory();
                continue;
            }
            float num, result;
            switch (select) {
                case 1 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.sine(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "sin", result);
                }
                case 2 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.cosine(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "cos", result);
                }
                case 3 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.tangent(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "tan", result);
                }
                case 4 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.secant(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "sec", result);
                }
                case 5 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.cosecant(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "csc", result);
                }
                case 6 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.cotangent(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "cot", result);
                }
                case 7 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.arcsine(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "arcsin", result);
                }
                case 8 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.arccosine(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "arccos", result);
                }
                case 9 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.arctangent(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "arctan", result);
                }
                case 10 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.sinc(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "sinc", result);
                }
                case 11 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.sinh(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "sinh", result);
                }
                case 12 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.cosh(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "cosh", result);
                }
                case 13 -> {
                    System.out.println("\nEnter the angle in radians");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = Methods.Trigonometric.tanh(num);
                    System.out.println("The answer is: " + result + "\n");
                    History.addSingleHistory(num, "tanh", result);
                }
            }
        }
    }
    public static void numberSystemCalculator() throws IOException {
        int choicesList[] = {1, 2, 3, 4, 5, 6, 7, 8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int select = 0;
            while (true) {
                System.out.println("Enter the mode of operation");
                System.out.println("1. Binary");
                System.out.println("2. Octal");
                System.out.println("3. Decimal");
                System.out.println("4. Hexadecimal");
                System.out.println("5. N");
                System.out.println("6. Conversion");
                System.out.println("7. History");
                System.out.println("8. Quit");
                System.out.println("");
                int choice = Integer.parseInt(br.readLine());
                if (Arrays.stream(choicesList).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            int num1, num2, result;
            if (select >= 6){
                switch (select){
                    case 6 ->{
                        System.out.println("\nEnter the converted number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("\nEnter the conversion number");
                        num2 = Integer.parseInt(br.readLine());
                        result = Methods.NumberSystem.convertNumber(num1, num2);
                        System.out.println("The answer is: " + result + "(" + num2 +")\n");
                    }
                    case 7 ->{
                        History.displayHistory();
                        continue;
                    }
                    case 8 ->{
                        break;
                    }
                }
            }
            else{
                String operator;
                System.out.println("\nEnter the first number");
                num1 = Integer.parseInt(br.readLine());
                System.out.println("\nEnter the second number");
                num2 = Integer.parseInt(br.readLine());
                operator = Choice.operationMode();
                switch (select) {
                    case 1 -> {
                        result = Methods.NumberSystem.numberCalculation(2, num1, num2, operator);
                        History.addNumberSystemHistory(num1, num2, 2, operator, result);
                        System.out.println("The answer is: " + result + "\n");
                    }
                }
            }
        }
    }
}
