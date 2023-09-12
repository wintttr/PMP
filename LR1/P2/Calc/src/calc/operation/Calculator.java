package calc.operation;

public class Calculator {
    public int sum(int... a) {
        Adder adder = new Adder();
        
        for(int i : a) {
            adder.add(i);
        }
        
        return adder.getSum();
    }
    
    public int subtract(int minimum, int... subtrahend) {
        Subtractor subtractor = new Subtractor(minimum);
        
        for(int i : subtrahend) {
            subtractor.subtract(i);
        }
        
        return subtractor.getSub();
    }
    
    public double divide(double dividend, double... divisors) {
        Divider divider = new Divider(dividend);
        
        for(double i : divisors) {
            divider.divide(i);
        }
        
        return divider.getQuotient();
    }
    
    public int mult(int... a) {
        Multiplier multiplier = new Multiplier();
        
        for(int i : a) {
            multiplier.mult(i);
        }
        
        return multiplier.getProduct();
    }
    
    public float fmod(float dividend, float... divisors) {
        Moder moder = new Moder(dividend);
        
        for(float i : divisors) {
            moder.mod(i);
        }
        
        return moder.getMod();
    }
}