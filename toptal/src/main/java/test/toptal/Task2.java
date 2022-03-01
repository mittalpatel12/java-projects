package test.toptal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {


        // String[] arr = {"P>E", "E>R", "R>U"};
        String[] arr = {"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"};

        Task2 task2 = new Task2();
        task2.findWord(arr);


    }

    private void findWord(String[] arr) {
        Map<String, String> map = new HashMap<>();

        for (String s : arr) {
            String[] charArr = s.split(">");

            map.put(charArr[0], charArr[1]);

        }

        Set<String> values= new HashSet<>(map.values());

        String firstChar = "";

        for (String key : map.keySet()) {
            if (!values.contains(key)) {
                firstChar = key;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);
        String key = firstChar;

        while (true) {
            String value = map.get(key);
            if (value == null) {
                break;
            }
            sb.append(value);
            key = value;
        }

        System.out.println(sb);
    }

}


