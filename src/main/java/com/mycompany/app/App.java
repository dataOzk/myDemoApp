package com.mycompany.app;

public class App {

    public static void main(String[] args) {
        /*String str1 = "Hello";
        String str2 = "World";
        int[] array1 = {2, 3, 4, 1, 0}; 
        int[] array2 = {4, 1, 2, 3, 0}; 

        String result = replaceCharacters(str1, str2, array1, array2);
        System.out.println("Result: " + result);*/
    }


    // Metod String olan str1 ve str2 parametrelerini ve integer array olan array1 ve array2 parametrelerini alıyor.
    // Döngü içinde str1'in array[i]'inci karakterini str2'nin array[i]'inci karakteri ile değiştiriyor.
    
    public static String replaceCharacters(String str1, String str2, int[] array1, int[] array2) {
        // Array Boyları Aynı Mı?
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of equal length");
        }

        // Out of Bounds değer var mı?
        int maxLength1= str1.length();
        int maxLength2= str2.length();
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < 0 || array1[i] >= maxLength1 || array2[i] < 0 || array2[i] >= maxLength2) {
                throw new IllegalArgumentException("Array indices out of bounds");
            }
        }


        // Sonuç olarak döneceğimiz string, str1 üzerinde oynama yapacağımız için başta str1'e eşit
        StringBuilder result = new StringBuilder(str1);
        for (int i = 0; i < array1.length; i++) {
            int index1 = array1[i];
            int index2 = array2[i];
            
            // Indexlerdeki değerleri değiştir
            result.setCharAt(index1, str2.charAt(index2));
            
        }
        return result.toString();
    }
}