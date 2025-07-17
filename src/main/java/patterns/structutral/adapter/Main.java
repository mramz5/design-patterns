package patterns.structutral.adapter;

import static java.lang.Math.PI;

public class Main {
    public static void main(String[] args) {
        //we have a rectangle, and we want to calculate its area and perimeter, but we don't have a suitable calculator for it,
        // so we should use an adapter to adapt it to an oval and then use an oval calculator to calculate its area and perimeter
        //rectangle --> oval --> ovalCalculator
        Rectangle rectangle=new Rectangle(10,12);
        OvalCalculator ovalCalculator=new CircleCalculator();
        RectangleCalculator rectangleCalculator= (RectangleCalculator) new AdapterFactory().getAdapter("OvalCalculatorAdapter",rectangle,ovalCalculator);

        System.out.println("*** Adapting Rectangle Calculator to Circle Calculator ***");
        System.out.println("Area:"+rectangleCalculator.getArea());
        System.out.println("Perimeter:"+rectangleCalculator.getPerimeter());

    }
}
//marker interface
interface Adapter{}
class OvalCalculatorAdapter extends RectangleCalculator implements Adapter{
    private OvalCalculator ovalCalculator;

    public OvalCalculatorAdapter(Rectangle rectangle, OvalCalculator ovalCalculator) {
        super(rectangle);
        rectangle.sides[0]=rectangle.sides[1];
        this.ovalCalculator = ovalCalculator;
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }
}
//performing some operations on the sides
//********************************************************
abstract class PolygonCalculator{
    public abstract double getArea();
    public abstract double getPerimeter();
}
class RectangleCalculator extends PolygonCalculator{
    private Rectangle rectangle;

    public RectangleCalculator(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public double getArea() {
        return rectangle.sides[0]*rectangle.sides[1];
    }

    @Override
    public double getPerimeter() {
        return 2*(rectangle.sides[0]+rectangle.sides[1]);
    }
}

//performing some operations on the diameters
abstract class OvalCalculator{
    public abstract double getAreaWithDiameters();
    public abstract double getPerimeterWithDiameters();
}
class CircleCalculator extends OvalCalculator{
    private Oval circle;

    public CircleCalculator() {
    }

    public CircleCalculator(Circle circle) {
        this.circle = circle;
    }

    @Override
    public double getAreaWithDiameters() {
        return 2*PI*circle.x*circle.x;
    }
    @Override
    public double getPerimeterWithDiameters() {
        return 2*PI*circle.x;
    }
}
//********************************************************
abstract class Polygon {
    protected double[] sides;

    public Polygon(int sidesNumber) {
        this.sides = new double[sidesNumber];
    }
    abstract int getNumberOfSides();
}
class Rectangle extends Polygon {
    private static final int SIDES_NUMBER=4;
    public Rectangle() {
        super(SIDES_NUMBER);
    }

    public Rectangle(double length, double width) {
        super(SIDES_NUMBER);
        sides[0] = length;
        sides[1] = width;
    }

    @Override
    public int getNumberOfSides() {
        return SIDES_NUMBER;
    }
}
//********************************************************
abstract class Oval{
    protected double x,y;
    protected double getX(){return x;}
    protected double getY(){return y;}
}
class Circle extends Oval{
    
    public Circle(double radius) {
        this.x=this.y=radius;
    }

}

class AdapterFactory{
    public Adapter getAdapter(String type,
                              Rectangle rectangle,
                              OvalCalculator calculator){
        return switch (type.toLowerCase()){
            case ("ovalcalculatoradapter")->new OvalCalculatorAdapter(rectangle,calculator);
            default -> throw new IllegalArgumentException("Not supported Adapter");
        };
    }
}