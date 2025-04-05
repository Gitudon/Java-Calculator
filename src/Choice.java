import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Choice{
    public static int calculatorMode() throws IOException {
        int choicesList[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int select = 0;
        while (true) {
            // モードはシンプル計算機、関数計算機、三角関数計算機、n進数計算機、行列計算機、バラエティ計算機、定数辞典、自由入力、逆ポーランド記法、終了
            System.out.println("Enter the mode of operation");
            System.out.println(" 1. Simple Calculator");
            System.out.println(" 2. Methods.Function Calculator");
            System.out.println(" 3. Methods.Trigonometric Calculator");
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