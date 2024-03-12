package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testReplaceCharacters_SingleReplacement() {
        String str1 = "Hello";
        String str2 = "World";
        int[] array1 = {2};
        int[] array2 = {4};
        String expected = "Hedlo";
        String result = App.replaceCharacters(str1, str2, array1, array2);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_MultipleReplacements() {
        String str1 = "Hello";
        String str2 = "World";
        int[] array1 = {1, 2, 4};
        int[] array2 = {4, 1, 2};
        String expected = "Hdolr";
        String result = App.replaceCharacters(str1, str2, array1, array2);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_EmptyString() {
        String str1 = "";
        String str2 = "World";
        int[] array1 = {};
        int[] array2 = {};
        String expected = "";
        String result = App.replaceCharacters(str1, str2, array1, array2);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_SameString() {
        String str1 = "Hello";
        String str2 = "Hello";
        int[] array1 = {0, 1, 2, 3, 4};
        int[] array2 = {0, 1, 2, 3, 4};
        String expected = "Hello";
        String result = App.replaceCharacters(str1, str2, array1, array2);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_LargeStrings() {
        String str1 = "This is a long string for testing";
        String str2 = "Another long string for testing";
        int[] array1 = {5, 10, 15, 20};
        int[] array2 = {10, 15, 20, 7};
        String expected = "This ns a rong ftrin  for testing";
        String result = App.replaceCharacters(str1, str2, array1, array2);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_UnevenArrays() {
        String str1 = "Hello";
        String str2 = "World";  
        int[] array1 = {2, 3, 4, 1, 0}; 
        int[] array2 = {4, 1, 2,}; 

        try {
            App.replaceCharacters(str1, str2, array1, array2);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            
        }
    }

    @Test
    public void testReplaceCharacters_OutOfBoundsIndex() {
        String str1 = "Hello";
        String str2 = "World";
        int[] array1 = {2, 6};  
        int[] array2 = {4, 1};

        try {
            App.replaceCharacters(str1, str2, array1, array2);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException, but no exception was thrown");
    }


}

