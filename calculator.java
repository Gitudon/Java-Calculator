import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class calculator {
    // 全体で共有する状態変数
    static int calculator_mode;
    static String history;
    // 計算機能たち
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
    public static float power(float num1, float num2) {
        return (float) Math.pow(num1, num2);
    }
    public static float square_root(float num) {
        return (float) Math.sqrt(num);
    }
    public static float n_root(float num, float n) {
        return (float) Math.pow(num, 1.0 / n);
    }
    public static float common_logarithm(float num) {
        return (float) Math.log10(num);
    }
    public static float natural_logarithm(float num) {
        return (float) Math.log(num);
    }
    public static float general_logarithm(float num, float base) {
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
    public static float absolute_value(float num) {
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

    // 履歴
    public static void add_history(float num1, float num2, String operator, float result) {
        history += num1 + " " + operator + " " + num2 + " = " + result + "\n";
    }
    public static void add_history_single(float num, String operator, float result) {
        history += operator + " " + num + " = " + result + "\n";
    }
    public static void history() {
        System.out.println("");
        System.out.println(history);
        System.out.println("");
    }
    public static void clear_history() {
        history = "";
    }
    // 計算機たち
    public static int choice_calculator_mode() throws IOException {
        int choice_list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
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
            if (Arrays.stream(choice_list).noneMatch(i -> i == choice)) {
                System.out.println("Invalid choice");
            } else {
                select = choice;
                break;
            }
        }
        return select;
    }
    public static void simple_calculator() throws IOException {
        int choice_list[] = {1, 2, 3, 4, 5, 6, 7};
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
                if (Arrays.stream(choice_list).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            if (select == 7) {
                break;
            } else if (select == 6) {
                history();
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
                    result = add(num1, num2);
                    System.out.println("The sum is: " + result + "\n");
                    add_history(num1, num2, "+", result);
                }
                case 2 -> {
                    result = subtract(num1, num2);
                    System.out.println("The difference is: " + result + "\n");
                    add_history(num1, num2, "-", result);
                }
                case 3 -> {
                    result = multiply(num1, num2);
                    System.out.println("The product is: " + result + "\n");
                    add_history(num1, num2, "×", result);
                }
                case 4 -> {
                    result = divide(num1, num2);
                    System.out.println("The quotient is: " + result + "\n");
                    add_history(num1, num2, "÷", result);
                }
                case 5 -> {
                    result = modulo(num1, num2);
                    System.out.println("The remainder is: " + result + "\n");
                    add_history(num1, num2, "%", result);
                }
            }
        }
    }
    public static void function_calculator() throws IOException {
        int choice_list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
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
                if (Arrays.stream(choice_list).noneMatch(i -> i == choice)) {
                    System.out.println("Invalid choice");
                } else {
                    select = choice;
                    break;
                }
            }
            if (select == 15) {
                break;
            } else if (select == 14) {
                history();
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
                    result = add(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    add_history(num1, num2, "^", result);
                }
                case 2 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = square_root(num1);
                    System.out.println("The answer is: " + result + "\n");
                    add_history_single(num1, "√", result);
                }
                case 3 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the root number");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = n_root(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    add_history(num2, num1, "√", result);
                }
                case 4 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = common_logarithm(num1);
                    System.out.println("The answer is: " + result + "\n");
                    add_history_single(num1, "log_{10}", result);
                }
                case 5 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = natural_logarithm(num1);
                    System.out.println("The answer is: " + result + "\n");
                    add_history_single(num1, "log", result);
                }
                case 6 -> {
                    System.out.println("\nEnter the base number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the root number");
                    num2 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = general_logarithm(num1, num2);
                    System.out.println("The answer is: " + result + "\n");
                    history += "log_{" + num2 + "} " + num1 + " = " + result + "\n";
                }
                case 7 -> {
                    System.out.println("\nEnter the number");
                    num1 = Integer.parseInt(br.readLine());
                    System.out.println("");
                    result = factorial(num1);
                    System.out.println("The answer is: " + result + "\n");
                    add_history_single(num1, "!", result);
                }
            }
        }
    }
    // 全体の制御をするメイン関数
    public static void main(String[] args) throws IOException {
        history = "";
        while (true) {
            calculator_mode = choice_calculator_mode();
            switch (calculator_mode) {
                case 1:
                    System.out.println("\nSimple Calculator\n");
                    simple_calculator();
                case 2:
                    System.out.println("\nFunction Calculator\n");
                    break;
                case 3:
                    System.out.println("\nTrigonometric Calculator\n");
                    break;
                case 4:
                    System.out.println("\nNumber System Converter\n");
                    break;
                case 5:
                    System.out.println("\nMatrix Calculator\n");
                    break;
                case 6:
                    System.out.println("\nVariety Calculator\n");
                    break;
                case 7:
                    System.out.println("\nConstant Dictionary\n");
                    break;
                case 8:
                    System.out.println("\nFree Input\n");
                    break;
                case 9:
                    System.out.println("\nReverse Polish Notation\n");
                    break;
                case 10:
                    clear_history();
                    System.out.println("\nThe history was cleared.\n");
                case 11:
                    break;
            }
        }
    }
}
