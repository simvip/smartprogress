import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ivan Sliusar on 28.08.2018.
 * Red Line Soft corp.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(normalizeInputString("ИВАнов иВан иваНОВИЧ."));
        System.out.println(reversString("мАма мЫЛА рАму. маШа игрАла в мЯч."));
    }

    public static String normalizeInputString(String input) {
        List<String> inputList = Arrays.asList(input.split("\\s+"));
        return inputList.stream()
                .map(
                        name ->
                                // lover case input stream and change firs car to UpperCase
                                name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static String reversString(String input) {
        // Splint input string by regular expression (dot)
        List<String> inputList = Arrays.asList(input.split("\\."));
        return inputList.stream()
                .map(
                        name ->
                                // revers and lowercase input string
                                new StringBuilder(name).reverse().toString().toLowerCase())
                .map(
                        name ->
                                // change firs car to UpperCase
                                name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
                .collect(Collectors.joining("."));
    }
}
