# Cryptarithm-Solver

This is a simple android application that solves Cryptarithmetic Puzzles by generating the permutations and checking if any of it is a solution.

**Overview:**

A cryptarithmetic puzzle is a mathematical exercise where the digits of some numbers are represented by letters (or symbols). Each letter represents a unique digit. The goal is to find the digits such that a given mathematical equation is verified:
```
    SEND
+   MORE
--------
=  MONEY
```

One assignment of letters to digits yields the following equation:
```
    9567
+   1085
--------
=  10652
```

The app takes 3 inputs: String 1, String 2 and String 3. And, provides 4 options: Addition, Subtraction, Multiplication and Division.
Based on the option, it displays the result.

In case of above example: 
```
String 1 -> SEND
String 2 -> MORE
String 3 -> MONEY
Option -> Addition
Result -> 9567 + 1085 = 10652
```
