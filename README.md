## Lab 1 

### Develop class Polynomial as follows:
1. It has one field representing the coefficients of the polynomial using an array of
double. A polynomial is assumed to have the form 𝑎0 + 𝑎1𝑥1 + ⋯ + 𝑎𝑛−1𝑥𝑛−1.
    - For example, the polynomial $6 − 2𝑥 + 5𝑥^3$ would be represented using the
array [6, -2, 0, 5]
2. It has a no-argument constructor that sets the polynomial to zero (i.e. the
corresponding array would be [0])
3. It has a constructor that takes an array of double as an argument and sets the
coefficients accordingly
4. It has a method named add that takes one argument of type Polynomial and
returns the polynomial resulting from adding the calling object and the argument
5. It has a method named evaluate that takes one argument of type double
representing a value of x and evaluates the polynomial accordingly. For example,
if the polynomial is $6 − 2𝑥 + 5𝑥^3$ and evaluate(-1) is invoked, the result should
be 3.
6. It has a method named hasRoot that takes one argument of type double and
determines whether this value is a root of the polynomial or not. Note that a root
is a value of x for which the polynomial evaluates to zero.

## Lab2
Modify Polynomial.java as follows:
1. Replace the array representing the coefficients by two arrays: one representing the non-
zero coefficients (of type double) and another one representing the corresponding
exponents (of type int). For example, the polynomial $6 − 2𝑥 + 5𝑥^3$ would be represented
using the arrays [6, -2, 5] and [0, 1, 3]
2. Update the existing methods accordingly
3. Add a method named multiply that takes one argument of type Polynomial and returns
the polynomial resulting from multiplying the calling object and the argument. The
resulting polynomial should not contain redundant exponents.
4. Add a constructor that takes one argument of type File and initializes the polynomial
based on the contents of the file. You can assume that the file contains one line with no
Summer 2023
whitespaces representing a valid polynomial. For example: the line $5-3x^2+7x^8$
corresponds to the polynomial $5 − 3x^2 + 7x^8$
Hint: you might want to use the following methods: split of the String class, parseInt of
the Integer class, and parseDouble of the Double class
5. Add a method named saveToFile that takes one argument of type String representing a
file name and saves the polynomial in textual format in the corresponding file (similar to
the format used in part d)
f. You can add any supplementary methods you might find useful
6. Modify Driver.java to test the updated code
