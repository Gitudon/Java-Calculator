public class Methods {
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
}
