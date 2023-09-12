package calc.operation;

public class Moder {
    private float mod;
    
    static private float fmod(float a, float b) {
        int i = 0;
        for(; (i + 1) * b <= a; i++) {}
        return a - i * b;
    }
    
    public Moder(float dividend) { 
        mod = dividend; 
    }
    
    public void mod(float b) {
        mod = fmod(mod, b);
    }
    
    public float getMod() {
        return mod;
    }
}