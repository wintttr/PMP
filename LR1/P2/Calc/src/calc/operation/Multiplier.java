package calc.operation;

public class Multiplier {
    private int product;
    
    public Multiplier() { 
        product = 1; 
    }
    
    public void mult(int b) {
        product *= b;
    }
    
    public int getProduct() {
        return product;
    }
}