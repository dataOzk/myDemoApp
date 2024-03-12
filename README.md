# My Demo App

## Overview
My Demo App is a Java application that provides functionality to replace characters in a string based on provided indices and replacement characters.

## Usage
1. Clone or download the repository.
2. Open the project in your favorite Java IDE.
3. Modify the `main` method in the `App` class with your desired input strings and indices.
4. Run the `main` method to see the result of character replacement.
   
   Example:
   ```java
   String str1 = "Hello";
   String str2 = "World";
   int[] array1 = {2, 3, 4, 1, 0}; 
   int[] array2 = {4, 1, 2, 3, 0}; 

   String result = App.replaceCharacters(str1, str2, array1, array2);
   System.out.println("Result: " + result);

[![Build Status](https://app.travis-ci.com/dataOzk/myDemoApp.svg?token=3grjW2phX7pqFNkLprhN&branch=master)](https://app.travis-ci.com/dataOzk/myDemoApp)

