package calc.operation;

public class Subtractor {
    private int sub;
    
    public Subtractor(int sub) { 
        this.sub = sub; 
    }
    
    public void subtract(int b) {
        sub -= b;
    }
    
    public int getSub() {
        return sub;
    }
}