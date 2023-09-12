package calc.operation;

public class Divider {
    private double quotient;
    
    public Divider(double dividend) { 
        quotient = dividend; 
    }
    
    public void divide(double b) {
        quotient /= b;
    }
    
    public double getQuotient() {
        return quotient;
    }
}