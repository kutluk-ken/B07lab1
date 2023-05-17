public class Polynomial {
    double [] coefficients;

    public Polynomial(){
        coefficients = new double[1];
        coefficients[0] = 0;
    }

    public Polynomial(double[] array){
        this.coefficients = array;
    }
    public double evaluate(double x){
        double result = 0;
        double power = 0;
        for (double coe : coefficients){
            result = result + (coe*(Math.pow(x,power)));
            power += 1;
        }
        return result;
    }
    public Polynomial add(Polynomial newP){
        int maxlen = Math.max(coefficients.length, newP.coefficients.length);
        double[] result = new double[maxlen];
        for (int i = 0; i < maxlen; i++){
            double original_coef = (i < coefficients.length) ? coefficients[i]:0; 
            double newP_coef = (i < newP.coefficients.length) ? newP.coefficients[i]:0;
            result[i] = original_coef + newP_coef;
        }
        return new Polynomial(result);
    }

    public boolean hasRoot(double sol){
        return evaluate(sol) == 0;
    }
}