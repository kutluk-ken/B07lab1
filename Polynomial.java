import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Polynomial {
    double [] coefficients;
    int [] exponents;

    public Polynomial(){
        // double[] coefficients = new double[1];
        coefficients = new double[1];
        coefficients[0] = 0;
        exponents = new int[1];
        exponents[0] = 1;

    }

    public Polynomial(double[] coeffs, int[] exps){
        this.coefficients = coeffs;
        this.exponents = exps;
    }

    public Polynomial(File file) throws IOException{
        Scanner scanner = new Scanner(file);
        String polynomialString = scanner.nextLine();
        scanner.close();

        String[] terms = polynomialString.split("\\+|-");
        String[] coe = new String[terms.length];
        String[] exp = new String[terms.length];

        for (int i = 0; i < terms.length; i++){
            String term = terms[i];
            int termlen = term.length();
            int signIndex = term.indexOf("x");
            // Case: No x.
            if (signIndex == -1){
                coe[i] = term.trim(); // remove spaces.
                exp[i] = "0"; 
            }
            // Case: There is x.
            else{
                coe[i] = term.substring(0, signIndex).trim();
                exp[i] = term.substring(signIndex + 1, termlen).trim();
            }
        }
        // Now we move them into double[] and int[].
        coefficients = new double[terms.length];
        exponents = new int[terms.length];  
        // Question: can we use this.exponent here?  - Test later
        for (int i = 0; i < terms.length; i++){
            coefficients[i] = Double.parseDouble(coe[i]);
            exponents[i] = Integer.parseInt(exp[i]);
        }
    }



    public double evaluate(double x){
        double result = 0;
        for (int i=0 ; i < coefficients.length; i++){
            result = result + coefficients[i]*(Math.pow(x,exponents[i]));


        }
        return result;
    }

    public Polynomial add(Polynomial newP){
        int len1 = coefficients.length;
        int len2 = newP.coefficients.length;
        int newlen = len1 + len2;
        double[] newCoefficients = new double[newlen];
        int[] newExponents = new int[newlen];

        int i=0, j=0, k=0;
        while(i < len1 && j < len2){
            if(exponents[i] == newP.exponents[j]){
                newCoefficients[k] = coefficients[i] + newP.coefficients[j];
                newExponents[k] = exponents[i];
                i++;j++;k++;
            }
            else if(exponents[i] > newP.exponents[j]){
                newCoefficients[k] = coefficients[i];
                newExponents[k] = exponents[i];
                i++;k++;
            }else{
                newCoefficients[k] = newP.coefficients[j];
                newExponents[k] = newP.exponents[j];
                j++;k++;
            }
        }
        while(i<len1){
            newCoefficients[k] = coefficients[i];
            newExponents[k] = exponents[i];
            i++;k++;
        }
        while(j<len2){
            newCoefficients[k] = coefficients[j];
            newExponents[k] = exponents[j];
            j++;k++;
        }
        return new Polynomial(newCoefficients, newExponents);
    }
    public Polynomial clear_redundant(Polynomial pol){
        int [] uniqueExp = new int [pol.exponents.length];
        double [] combinedCoe = new double [pol.coefficients.length];
        int uniqueIndex = 0;

        // Iterate through array and conbine coefficients for each unique exponent
        for (int i = 0; i < pol.exponents.length; i++){
            int exp = pol.exponents[i];
            double coe = pol.coefficients[i];
            boolean exist = false; 
            // check if exponent already exists
            for (int j = 0; j < uniqueIndex; j++){
                if(uniqueExp[j] == exp){
                    combinedCoe[j] += coe;
                    exist = true;
                    break;
                }
            }
            if(!exist){
                uniqueExp[uniqueIndex] = exp;
                combinedCoe[uniqueIndex] = coe;
                uniqueIndex++;
            }
        }
        return new Polynomial(combinedCoe, uniqueExp);
    }
    public Polynomial clear_zeros(Polynomial pol){
        int len = 0;
        // Get the length of the array without 0 in coefficient.
        for (int i = 0; i < pol.coefficients.length; i++){
            if (pol.coefficients[i] != 0){
                len++;
            }
        }
        double [] result_coe = new double [len];
        int [] result_exp = new int [len];

        for (int j = 0, k=0; j < pol.coefficients.length; j++){
            if (pol.coefficients[j]!=0){
                result_coe[k] = pol.coefficients[j];
                result_exp[k] = pol.exponents[j];
                k++;
            }
        }

        return new Polynomial(result_coe, result_exp);

    }

    public Polynomial multiply(Polynomial newP){
        int len1 = coefficients.length;
        int len2 = newP.coefficients.length;
        int resultlen =  len1 * len2;
        double [] result_coe = new double [resultlen];
        int [] result_exp = new int [resultlen];
        for (int i = 0; i < len1 ; i++){
            for (int j = 0; j < len2; j++){
                result_coe[i*len1+j] = coefficients[i] * newP.coefficients[j];
                result_exp[i*len1+j] = exponents[i] + newP.exponents[j];
            }

        }
        Polynomial p = new Polynomial(result_coe, result_exp);
        Polynomial p1 = p.clear_redundant(p);
        Polynomial p2 = p1.clear_zeros(p1);
        return p2;
    }

    public void saveToFile(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        StringBuilder polynomial = new StringBuilder();

        for (int i = 0; i < coefficients.length; i++){
            double coe = coefficients[i];
            int exp = exponents[i];

            // make sure the coeffient is not zero
            if(coe != 0){
                if(polynomial.length() == 0){
                    if (exp == 0){
                        polynomial.append(coe);
                    }else{
                        polynomial.append(coe).append("x").append(exp);
                    }
                }else{
                    polynomial.append(coe>0? "+":"-");
                    double abscoe = Math.abs(coe);
                    if (exp == 0){
                        polynomial.append(abscoe);
                    }else{
                        polynomial.append(abscoe).append("x").append(exp);
                    }
                }
            }
        }
        fileWriter.write(polynomial.toString());
        fileWriter.close();
    
}
    public boolean hasRoot(double sol){
        return evaluate(sol) == 0;
    }
}