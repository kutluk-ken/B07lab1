//import java.util.*;
public class Driver {
    public static void main(String [] args) {
    Polynomial p = new Polynomial();
    System.out.println(p.evaluate(3));
    double [] c1 = {3,-4,6};
    int [] e1 = {4,2,3};
    Polynomial p1 = new Polynomial(c1,e1);
    double [] c2 = {1,3,2};
    int [] e2 = {5,3,4};
    Polynomial p2 = new Polynomial(c2,e2);
    Polynomial s = p1.add(p2);
    System.out.println("s(0) = " + s.evaluate(-1));
    //System.out.println(Arrays.toString(s.coefficients));
    if(s.hasRoot(1))
    System.out.println("0 is a root of s");
    else
    System.out.println("0 is not a root of s");
    }
    }