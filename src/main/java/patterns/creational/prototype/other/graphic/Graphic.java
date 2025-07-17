package patterns.creational.prototype.other.graphic;

public interface Graphic extends Cloneable{
    void draw(double x,double y);
    Graphic clone() throws CloneNotSupportedException;
}
