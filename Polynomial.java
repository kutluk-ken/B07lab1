public class Polynomial {
    double [] coefficients;

    public Polynomial(){
        coefficients = new double[]{0};
    }

    public void set(double[] array){
        for (int i = 0; i < array.length; i++){
            coefficients[i] = array[i];
        }
    }


}