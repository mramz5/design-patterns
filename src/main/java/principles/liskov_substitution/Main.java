package principles.liskov_substitution;

public class Main {
    public static void main(String[] args) {
        Parallelogram parallelogram=new Square(3.4f); // violates the lsp because superclass has some functionality that should not be in the subclass
        parallelogram.setA(2.1f);
        parallelogram.setB(9.2f);
    }
}
