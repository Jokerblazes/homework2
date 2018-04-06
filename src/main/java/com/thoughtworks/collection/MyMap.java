package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> result = new ArrayList<>();
        array.forEach(integer -> result.add(integer * 3));
        return result;
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<>();
        array.forEach(integer -> result.add(letters[integer - 1]));
        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        for (Integer integer : array) {
            int num = integer;
            boolean divisible = num % 26 == 0;
            String s = "";
            if (divisible) {
                int i = num / 26;
                int permit = 1;
                while (i > 0) {
                    if (i > permit) {
                        i = i - permit;
                        permit = permit * 26;
                        s = letters[25] + s;
                    } else {
                        s = letters[i - 1] + s;
                        i = 0;
                    }
                }
            } else {
                while (num > 0) {
                    s = letters[num % 26 - 1] + s;
                    num /= 26;
                }
            }
            result.add(s);
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted((a,b) -> b - a).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
