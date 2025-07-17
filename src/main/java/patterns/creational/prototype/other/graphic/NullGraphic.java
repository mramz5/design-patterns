package patterns.creational.prototype.other.graphic;

public class NullGraphic implements Graphic {

    private static final NullGraphic instance = new NullGraphic();

    public static NullGraphic getInstance() {
        return instance;
    }

    private NullGraphic(){}

    @Override
    public void draw(double x, double y) {
        System.out.println("nothing to draw");
    }

    @Override
    public Graphic clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
