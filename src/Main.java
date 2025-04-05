import java.io.IOException;

public class Main {
    static int calculatorMode;
    public static void main(String[] args) throws IOException {
        History.initializeHistory();
        while (true) {
            calculatorMode = Choice.calculatorMode();
            switch (calculatorMode) {
                case 1 -> {
                    System.out.println("\nSimple Calculator\n");
                    Calculator.simpleCalculator();
                }
                case 2 -> {
                    System.out.println("\nMethods.Function Calculator\n");
                    Calculator.FunctionCalculator();
                }
                case 3 -> {
                    System.out.println("\nMethods.Trigonometric Calculator\n");
                    Calculator.trigonometricCalculator();
                }
                case 4 -> {
                    System.out.println("\nNumber System Converter\n");
                    Calculator.numberSystemCalculator();
                }
                case 5 -> {
                    System.out.println("\nMatrix Calculator\n");
                    // Add matrix calculator Methods.Functionality here
                }
                case 6 -> {
                    System.out.println("\nVariety Calculator\n");
                    // Add variety calculator Methods.Functionality here
                }
                case 7 -> {
                    System.out.println("\nConstant Dictionary\n");
                    // Add constant dictionary Methods.Functionality here
                }
                case 8 -> {
                    System.out.println("\nFree Input\n");
                    // Add free input Methods.Functionality here
                }
                case 9 -> {
                    System.out.println("\nReverse Polish Notation\n");
                    // Add reverse polish notation Methods.Functionality here
                }
                case 10 -> {
                    History.initializeHistory();
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