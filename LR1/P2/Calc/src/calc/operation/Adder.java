package calc.operation;

public class Adder {
    private int sum;
    
    public Adder() { 
        sum = 0; 
    }
    
    public void add(int b) {
        sum += b;
    }
    
    public int getSum() {
        return sum;
    }
}