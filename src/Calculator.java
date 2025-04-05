import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Calculator {
    // 全体で共有する状態変数
    static int calculatorMode;
    static String history;
    public class Arithmetic {
        public static float add(float num1, float num2) {
            return num1 + num2;
        }
        public static float subtract(float num1, float num2) {
            return num1 - num2;
        }
        public static float multiply(float num1, float num2) {
            return num1 * num2;
        }
        public static float divide(float num1, float num2) {
            return num1 / num2;
        }
        public static float modulo(float num1, float num2) {
            return num1 % num2;
        }
    }
    public class Function{
        public static float power(float num1, float num2) {
            return (float) Math.pow(num1, num2);
        }
        public static float squareRoot(float num) {
            return (float) Math.sqrt(num);
        }
        public static float nRoot(float num, float n) {
            return (float) Math.pow(num, 1.0 / n);
        }
        public static float commonLogarithm(float num) {
            return (float) Math.log10(num);
        }
        public static float naturalLogarithm(float num) {
            return (float) Math.log(num);
        }
        public static float generalLogarithm(float num, float base) {
            // log_b(a) = log_c(a) / log_c(b)
            return (float) (Math.log(num) / Math.log(base));
        }
        public static float factorial(float num) {
            if (num == 0) {
                return 1;
            }
            return num * factorial(num - 1);
        }
        public static float permutation(float n, float r) {
            return factorial(n) / factorial(n - r);
        }
        public static float combination(float n, float r) {
            return factorial(n) / (factorial(r) * factorial(n - r));
        }
        public static float absoluteValue(float num) {
            return Math.abs(num);
        }
        public static float ceiling(float num) {
            return (float) Math.ceil(num);
        }
        public static float floor(float num) {
            return (float) Math.floor(num);
        }
        public static float round(float num) {
            return (float) Math.round(num);
        }
    }
    public class Trigonometric{
        public static float sine(float num) {
            return (float) Math.sin(num);
        }
        public static float cosine(float num) {
            return (float) Math.cos(num);
        }
        public static float tangent(float num) {
            return (float) Math.tan(num);
        }
        public static float cosecant(float num) {
            return 1 / sine(num);
        }
        public static float secant(float num) {
            return 1 / cosine(num);
        }
        public static float cotangent(float num) {
            return 1 / tangent(num);
        }
        public static float arcsine(float num) {
            return (float) Math.asin(num);
        }
        public static float arccosine(float num) {
            return (float) Math.acos(num);
        }
        public static float arctangent(float num) {
            return (float) Math.atan(num);
        }
        public static float sinc(float num) {
            return (float) Math.sin(num) / num;
        }
        public static float sinh(float num) {
            return (float) Math.sinh(num);
        }
        public static float cosh(float num) {
            return (float) Math.cosh(num);
        }
        public static float tanh(float num) {
            return (float) Math.tanh(num);
        }
    }
    public class NumberSystem{
        public static int convertNumber(int convertedNumber, int conversionNumber) {
            return Integer.parseInt(Integer.toString(convertedNumber, conversionNumber));
        }
        public static int numberCalculation(int base, int num1, int num2, String operator) {
            switch (operator) {
                case "+" -> {
                    return num1 + num2;
                }
                case "-" -> {
                    return num1 - num2;
                }
                case "×" -> {
                    return num1 * num2;
                }
                case "÷" -> {
                    return num1 / num2;
                }
                case "%" -> {
                    return num1 % num2;
                }
                default -> {
                    return 0;
                }
            }
        }
    }
    public class ManageHistory{
        public static void addHistory(float num1, float num2, String operator, float result) {
            history += (num1 + " " + operator + " " + num2 + " = " + result + "\n");
        }
        public static void addSingleHistory(float num, String operator, float result) {
            history += (operator + " " + num + " = " + result + "\n");
        }
        public static void addHistoryOnSide(float num, String operator, float result) {
            history += (operator + " " + num + "  " + operator + " = " + result + "\n");
        }
        public static void addNumberSystemHistory(int num1, int num2, int base, String operator, int result) {
            history += (num1 + "(" + base + ") " + operator + " " + num2 + "(" + base + ") = " + result + "\n");
        }
        public static void displayHistory() {
            System.out.println("");
            System.out.println(history);
            System.out.println("");
        }
        public static void clearHistory() {
            history = "";
        }
    }
    public class Choices{
        public static int calculatorMode() throws IOException {
            int choicesList[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            int select = 0;
            while (true) {
                // モードはシンプル計算機、関数計算機、三角関数計算機、n進数計算機、行列計算機、バラエティ計算機、定数辞典、自由入力、逆ポーランド記法、終了
                System.out.println("Enter the mode of operation");
                System.out.println(" 1. Simple Calculator");
                System.out.println(" 2. Function Calculator");
                System.out.println(" 3. Trigonometric Calculator");
                System.out.println(" 4. Number System Converter");
                System.out.println(" 5. Matrix Calculator");
                System.out.println(" 6. Variety Calculator");
                System.out.println(" 7. Constant Dictionary");
                System.out.println(" 8. Free Input");
                System.out.println(" 9. Reverse Polish Notation");
                System.out.println("10. Clear History");
                System.out.println("11. Exit");
                System.out.println("");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int choice = Integer.parseInt(br.readLine());
                if (Arrays.stream(choicesList).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            return select;
        }
        public static String operationMode() throws IOException{
            int choicesList[] = {1, 2, 3, 4, 5};
            String selectedOperator = "";
            while (true) {
                System.out.println("\nEnter the operator");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Modulo");
                System.out.println("");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int choice = Integer.parseInt(br.readLine());
                if (Arrays.stream(choicesList).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    switch (choice) {
                        case 1 -> selectedOperator = "+";
                        case 2 -> selectedOperator = "-";
                        case 3 -> selectedOperator = "×";
                        case 4 -> selectedOperator = "÷";
                        case 5 -> selectedOperator = "%";
                    }
                    break;
                }
            }
            return selectedOperator;
        }
    }
    public class Calculators{
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
                    ManageHistory.displayHistory();
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
                        result = Arithmetic.add(num1, num2);
                        System.out.println("The sum is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "+", result);
                    }
                    case 2 -> {
                        result = Arithmetic.subtract(num1, num2);
                        System.out.println("The difference is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "-", result);
                    }
                    case 3 -> {
                        result = Arithmetic.multiply(num1, num2);
                        System.out.println("The product is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "×", result);
                    }
                    case 4 -> {
                        result = Arithmetic.divide(num1, num2);
                        System.out.println("The quotient is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "÷", result);
                    }
                    case 5 -> {
                        result = Arithmetic.modulo(num1, num2);
                        System.out.println("The remainder is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "%", result);
                    }
                }
            }
        }
        public static void functionCalculator() throws IOException {
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
                    ManageHistory.displayHistory();
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
                        result = Function.power(num1, num2);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "^", result);
                    }
                    case 2 -> {
                        System.out.println("\nEnter the base number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.squareRoot(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num1, "√", result);
                    }
                    case 3 -> {
                        System.out.println("\nEnter the base number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("\nEnter the root number");
                        num2 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.nRoot(num1, num2);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistory(num2, num1, "√", result);
                    }
                    case 4 -> {
                        System.out.println("\nEnter the base number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.commonLogarithm(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num1, "log_{10}", result);
                    }
                    case 5 -> {
                        System.out.println("\nEnter the base number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.naturalLogarithm(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num1, "log", result);
                    }
                    case 6 -> {
                        System.out.println("\nEnter the base number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("\nEnter the root number");
                        num2 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.generalLogarithm(num1, num2);
                        System.out.println("The answer is: " + result + "\n");
                        history += "log_{" + num2 + "} " + num1 + " = " + result + "\n";
                    }
                    case 7 -> {
                        System.out.println("\nEnter the number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.factorial(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num1, "!", result);
                    }
                    case 8 -> {
                        System.out.println("\nEnter the number of elements");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("\nEnter the number of selections");
                        num2 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.permutation(num1, num2);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "P", result);
                    }
                    case 9 -> {
                        System.out.println("\nEnter the number of elements");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("\nEnter the number of selections");
                        num2 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.combination(num1, num2);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistory(num1, num2, "C", result);
                    }
                    case 10 -> {
                        System.out.println("\nEnter the number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.absoluteValue(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistoryOnSide(num1, history, result);
                    }
                    case 11 -> {
                        System.out.println("\nEnter the number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.ceiling(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistoryOnSide(num1, "⌈", result);
                    }
                    case 12 -> {
                        System.out.println("\nEnter the number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.floor(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistoryOnSide(num1, "⌊", result);
                    }
                    case 13 -> {
                        System.out.println("\nEnter the number");
                        num1 = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Function.round(num1);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addHistoryOnSide(num1, "〉", result);
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
                    ManageHistory.displayHistory();
                    continue;
                }
                float num, result;
                switch (select) {
                    case 1 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.sine(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "sin", result);
                    }
                    case 2 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.cosine(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "cos", result);
                    }
                    case 3 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.tangent(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "tan", result);
                    }
                    case 4 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.secant(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "sec", result);
                    }
                    case 5 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.cosecant(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "csc", result);
                    }
                    case 6 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.cotangent(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "cot", result);
                    }
                    case 7 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.arcsine(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "arcsin", result);
                    }
                    case 8 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.arccosine(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "arccos", result);
                    }
                    case 9 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.arctangent(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "arctan", result);
                    }
                    case 10 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.sinc(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "sinc", result);
                    }
                    case 11 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.sinh(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "sinh", result);
                    }
                    case 12 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.cosh(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "cosh", result);
                    }
                    case 13 -> {
                        System.out.println("\nEnter the angle in radians");
                        num = Integer.parseInt(br.readLine());
                        System.out.println("");
                        result = Trigonometric.tanh(num);
                        System.out.println("The answer is: " + result + "\n");
                        ManageHistory.addSingleHistory(num, "tanh", result);
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
                            result = NumberSystem.convertNumber(num1, num2);
                            System.out.println("The answer is: " + result + "(" + num2 +")\n");
                        }
                        case 7 ->{
                            ManageHistory.displayHistory();
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
                    operator = Choices.operationMode();
                    switch (select) {
                        case 1 -> {
                            result = NumberSystem.numberCalculation(2, num1, num2, operator);
                            ManageHistory.addNumberSystemHistory(num1, num2, 2, operator, result);
                            System.out.println("The answer is: " + result + "\n");
                        }
                    }
                }
            }
        }
    }
    // 全体の制御をするメイン関数
    public static void main(String[] args) throws IOException {
        history = "";
        while (true) {
            calculatorMode = Choices.calculatorMode();
            switch (calculatorMode) {
                case 1 -> {
                    System.out.println("\nSimple Calculator\n");
                    Calculators.simpleCalculator();
                }
                case 2 -> {
                    System.out.println("\nFunction Calculator\n");
                    Calculators.functionCalculator();
                }
                case 3 -> {
                    System.out.println("\nTrigonometric Calculator\n");
                    Calculators.trigonometricCalculator();
                }
                case 4 -> {
                    System.out.println("\nNumber System Converter\n");
                    Calculators.numberSystemCalculator();
                }
                case 5 -> {
                    System.out.println("\nMatrix Calculator\n");
                    // Add matrix calculator functionality here
                }
                case 6 -> {
                    System.out.println("\nVariety Calculator\n");
                    // Add variety calculator functionality here
                }
                case 7 -> {
                    System.out.println("\nConstant Dictionary\n");
                    // Add constant dictionary functionality here
                }
                case 8 -> {
                    System.out.println("\nFree Input\n");
                    // Add free input functionality here
                }
                case 9 -> {
                    System.out.println("\nReverse Polish Notation\n");
                    // Add reverse polish notation functionality here
                }
                case 10 -> {
                    ManageHistory.clearHistory();
                    System.out.println("\nThe history was cleared.\n");
                }
                case 11 -> {
                    System.out.println("\nExiting...\n");
                    return;
                }
            }
        }
    }
}
