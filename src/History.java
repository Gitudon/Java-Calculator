public class History {
    static String history;
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
    public static void addLogHistory(float num1, float num2, float result) {
        history += "log_{" + num2 + "} " + num1 + " = " + result + "\n";
    }
    public static void displayHistory() {
        System.out.println("");
        System.out.println(history);
        System.out.println("");
    }
    public static void initializeHistory() {
        history = "";
    }
}