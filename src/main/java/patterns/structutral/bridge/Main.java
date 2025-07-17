package patterns.structutral.bridge;

public class Main {
    public static void main(String[] args) {
//        Remote touchRemote = new TouchRemote(new Television());

//        System.out.println("Remote Operation...");
//        touchRemote.togglePower();
//        System.out.println("Remote device is on...");
//        System.out.println("Channel:" + touchRemote.getDevice().getChannel());
//        touchRemote.getDevice().setChannel(12);
//        System.out.println("Channel is " + touchRemote.getDevice().getChannel());
//        touchRemote.volumeDown(50.31f);
//        System.out.println("Volume: " + touchRemote.getDevice().getVolume());

        IColor iColor = new RedCircle();
        Shape triangle=new Triangle(iColor);
        triangle.modifyBorder(12,3);
        triangle.drawShape(13);

    }
}

abstract class Shape {
    protected IColor drawer;

    public Shape(IColor drawer) {
        this.drawer = drawer;
    }

    public abstract void drawShape(int border);

    public abstract void modifyBorder(int border, int increment);
}


class Triangle extends Shape {
    public Triangle(IColor iColor) {
        super(iColor);
    }

    @Override
    public void drawShape(int border) {
        drawer.fillWithColor(border);
    }

    @Override
    public void modifyBorder(int border, int increment) {
        drawer.fillWithColor(border *= increment);
    }
}

class Rectangle extends Shape {
    public Rectangle(IColor drawer) {
        super(drawer);
    }

    @Override
    public void drawShape(int border) {

    }

    @Override
    public void modifyBorder(int border, int increment) {

    }

}

abstract class Color {}

class Red extends Color {
}

class Blue extends Color {
}

interface IColor {
    void fillWithColor(int border);
}

class GreenCircle implements IColor {
    @Override
    public void fillWithColor(int border) {
        System.out.println("Coloring circle with green color and border with thickness:" + border);
    }
}

class RedCircle implements IColor {
    @Override
    public void fillWithColor(int border) {
        System.out.println("Coloring circle with red color and border with thickness:" + border);
    }
}