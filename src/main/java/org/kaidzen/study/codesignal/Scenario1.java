package org.kaidzen.study.codesignal;

import java.util.*;

public class Scenario1 {

    public static void main(String[] args) {
        Scenario1 scen = new Scenario1();

        String[][] queries = new String[][]{
                {"ADD","1"},
                {"ADD","2"},
                {"ADD","2"},
                {"ADD","3"},
                {"EXISTS","1"},
                {"EXISTS","2"},
                {"EXISTS","3"},
                {"REMOVE","2"},
                {"REMOVE","1"},
                {"EXISTS","2"},
                {"EXISTS","1"},
        };
        String[] res = scen.solution(queries);
        System.out.println(Arrays.toString(res));
    }

    String[] solution(String[][] queries) {
        Map<String, Integer> map = new HashMap<>();
        int rows = queries.length;
        String[] result = new String[rows];

        for (int i = 0; i<queries.length; i++) {
            String operation = queries[i][0];
            String  value = queries[i][1];
            if ("ADD".equals(operation)) {
                map.merge(value, 1, Integer::sum);
            }
            if ("REMOVE".equals(operation)) {
                if (map.containsKey(value)) {
                    int oldValue = map.get(value);
                    if (oldValue > 1) {
                        map.put(value, oldValue-1);
                    } else {
                        map.remove(value);
                    }
                }
            }
            final List<String> collect = map.keySet().stream()
                    .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

            for (String key: collect) {

            }
            result[i] = switch (operation) {
                case "ADD" -> "";
                case "EXISTS" -> map.containsKey(value)? "true": "false";
                case "REMOVE" -> "true";
                default -> throw new IllegalStateException("Unexpected value: " + operation);

            };
        }
        return result;
    }
}
