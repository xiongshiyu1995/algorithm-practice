package week.nine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author XiongShiyu
 * @description ReverseWordsInAString
 * @date 2022/6/19 22:24
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> strings = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }
}
