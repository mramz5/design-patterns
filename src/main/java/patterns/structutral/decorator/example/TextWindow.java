package patterns.structutral.decorator.example;

public class TextWindow implements Window {
    @Override
    public void displayWindow() {
        System.out.println("Displaying window");
    }

    @Override
    public void setBorder() {
        System.out.println("Border set!");
    }
}
