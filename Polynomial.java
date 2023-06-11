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

    public Polynomial multiply(Polynomial newP){
        




        return
    }

    public boolean hasRoot(double sol){
        return evaluate(sol) == 0;
    }
}