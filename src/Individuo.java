import java.util.Random;
import java.util.stream.DoubleStream;

public class Individuo implements Cloneable{
    
    private double valorIndividuo[];
    private Random random;
    private int n;
    private double lower[];
    private double upper[];
    
    public Individuo(int n, double lower[], double upper[]){
        
        this.n = n;
        this.lower = lower;
        this.upper = upper;
        this.random = new Random();
        this.valorIndividuo = new double[n];
        generarDimension();
    }
    
    private void generarDimension(){
        
        double dimensionLowerBounds;
        double dimensionUpperBounds;
        DoubleStream valueGenerator;
        
        for(int i = 0; i < n; i++){
            dimensionLowerBounds = lower[i];
            dimensionUpperBounds = upper[i];
            valueGenerator = random.doubles(dimensionLowerBounds, dimensionUpperBounds);
            valorIndividuo[i] = valueGenerator.iterator().nextDouble();
            valueGenerator = random.doubles(dimensionLowerBounds, dimensionUpperBounds);
        }
    }
    
    public double[] getValorIndividuo(){ return valorIndividuo; }
    
    public String toString(){
        
        String string = "";
        
        for(int i = 0; i < valorIndividuo.length; i++){
            string += Double.toString(valorIndividuo[i]);
            if((i + 1) != valorIndividuo.length)
                string += ".\t";
        }
        
        return string;
    }
    
    protected Object clone() throws CloneNotSupportedException{ 
        return super.clone();
    }
    
}
