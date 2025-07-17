package principles.liskov_substitution;

public class Parallelogram {
    private float a,b;

    public Parallelogram(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }
    public void setA(float a) {
        this.a = a;
    }
    public float getB() {
        return b;
    }
    public void setB(float b) {
        this.b = b;
    }
}
