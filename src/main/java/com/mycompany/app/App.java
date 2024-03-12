package com.mycompany.app;

import static spark.Spark.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {


    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            String string1 = req.queryParams("string1");
            String string2 = req.queryParams("string2");
            String array1Str = req.queryParams("array1");
            String array2Str = req.queryParams("array2");
            // Parse comma-separated strings into integer arrays
            int[] array1 = Arrays.stream(array1Str.split(","))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
            int[] array2 = Arrays.stream(array2Str.split(","))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();


            String result = App.replaceCharacters(string1, string2, array1, array2);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute", (rq, rs) -> {
            Map map = new HashMap();
            map.put("result", "not computed yet!");
            return new ModelAndView(map,"compute.mustache");
        }, new MustacheTemplateEngine());
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
