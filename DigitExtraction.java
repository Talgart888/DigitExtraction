import java.util.Arrays;

public class DigitExtraction {
    public static void main(String[] args) {
        String string = "Java first appeared May 23, 1995; 27 years ago. Java SE 19 edit 20 September 2022; 2 months ago";
        int[] numbers = extractNumbersFromString(string);
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] extractNumbersFromString(final String string) {
        int[] results = new int[string.length() / 2 + 1];
        int count = 0; // храним извлеченные числа
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            var ch = string.charAt(i); // получаем символ по указанному индексу
            if (isDigit(ch)) {
                numberBuilder.append(ch); // если символ является цифрой одна или несколько
            } else if (numberBuilder.length() > 0) {
                results[count++] = Integer.parseInt(numberBuilder.toString());
                numberBuilder.setLength(0);
            }
        }
        if (numberBuilder.length() > 0) {
            results[count++] = Integer.parseInt(numberBuilder.toString());
        }
        return trimArray(results, count);
    }

    private static boolean isDigit(char ch) {
        // return Character.isDigit(ch)
        return ch >= '0' && ch <= '9';
    }

    private static int[] trimArray(int[] array, int count) {
        int[] result = new int[count];
        // System.arraycopy(array, 0, result, 0, count);
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        return result;
    }
}