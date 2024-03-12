package com.mycompany.app;

import static spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;

        for (int elt : array) {
            if (elt == e) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> {
            return "Hello, World";
        });

        post("/compute", (req, res) -> {
            String input1 = req.queryParams("input1");
            String input2 = req.queryParams("input2");

            String[] input1Array = input1.split(",");
            String[] input2Array = input2.split(",");

            int[] array1 = new int[input1Array.length];
            int[] array2 = new int[input2Array.length];

            for (int i = 0; i < input1Array.length; i++) {
                array1[i] = Integer.parseInt(input1Array[i].trim());
                array2[i] = Integer.parseInt(input2Array[i].trim());
            }

            String str1 = req.queryParams("str1");
            String str2 = req.queryParams("str2");

            String result = replaceCharacters(str1, str2, array1, array2);

            Map<String, String> map = new HashMap<>();
            map.put("result", result);
            return map;
        });

        get("/compute", (req, res) -> {
            Map<String, String> map = new HashMap<>();
            map.put("result", "not computed yet!");
            return map;
        });
    }

    public static String replaceCharacters(String str1, String str2, int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of equal length");
        }

        int maxLength1 = str1.length();
        int maxLength2 = str2.length();
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < 0 || array1[i] >= maxLength1 || array2[i] < 0 || array2[i] >= maxLength2) {
                throw new IllegalArgumentException("Array indices out of bounds");
            }
        }

        StringBuilder result = new StringBuilder(str1);
        for (int i = 0; i < array1.length; i++) {
            int index1 = array1[i];
            int index2 = array2[i];
            result.setCharAt(index1, str2.charAt(index2));
        }
        return result.toString();
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // Default port if heroku-port isn't set
    }
}
