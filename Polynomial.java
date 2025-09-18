import java.lang.Math;

class Polynomial
{
    
    double[] coefs;
    
    public Polynomial(){
        coefs = new double[] {0};
    }
    
    public Polynomial(double[] coefs){
        this.coefs = new double[coefs.length];
        
        for(int i = 0; i < coefs.length; i++){
            this.coefs[i] = coefs[i];
        }
    }
    
    //helper method
    public void printPolynomial(){
        
        for(int i = 0; i < coefs.length; i++){
            System.out.printf("%fx^%d ", coefs[i], i);
            if(i < coefs.length - 1) System.out.print("+ ");
        }
        System.out.println();
        
    }
    
    public Polynomial add(Polynomial p){
        
        int maxl = maxLen(coefs, p.coefs);
        
        double[] sum = new double[maxl];

        for(int i = 0; i < maxl; i++){

            if(i < coefs.length) sum[i] += coefs[i];

            if(i < p.coefs.length) sum[i] += p.coefs[i];

        }
        
        return new Polynomial(sum);
        
    }
    
    public double evaluate(double x){
        double result = 0;
        
        for(int i = 0; i < coefs.length; i++){
            result += coefs[i] * Math.pow(x, i);
        }
        
        return result;
    }
    
    public boolean hasRoot(double x){
        if(evaluate(x) == 0){
            return true;
        }
        
        return false;
    }
    
    //helper method
    private int maxLen(double[] p1, double[] p2){
        if(p1.length > p2.length) return p1.length;
        else return p2.length;
    }
    
}