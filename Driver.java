import java.util.*;
import java.io.File;
import java.io.IOException;
public class Driver {
    // Test - Lab 1 
    public static void main(String [] args) throws IOException {
    Polynomial p = new Polynomial();
    System.out.println(p.evaluate(3));
    double [] c1 = {1,3};
    int [] e1 = {2,0};
    // Test  - add, Solve
    Polynomial p1 = new Polynomial(c1,e1);
    double [] c2 = {-2,-2};
    int [] e2 = {1,0};
    Polynomial p2 = new Polynomial(c2,e2);
    Polynomial s = p1.add(p2);
    System.out.println("s(1) = " + s.evaluate(1));
    //System.out.println(Arrays.toString(s.coefficients));
    if(s.hasRoot(1))
    System.out.println("1 is a root of s");
    else
    System.out.println("1 is not a root of s");

    // Test - Multiply
    Polynomial m = p1.multiply(p2);
    System.out.println("exponent = " + Arrays.toString(m.exponents));
    System.out.println("coefficients = " + Arrays.toString(m.coefficients));

    // Test - File
    File file = new File("polynomial.txt");
    Polynomial polynomial = new Polynomial(file);
    System.out.println("exponent from file" + Arrays.toString(polynomial.exponents));
    System.out.println("coe from file" + Arrays.toString(polynomial.coefficients));   

    //Test - saveToFile
    double [] s_c1 = {3,-11,11};
    int [] s_e1 = {2,12,3};
    Polynomial savepPolynomial = new Polynomial(s_c1,s_e1);
    savepPolynomial.saveToFile("polynomial2.txt");
    }

    }