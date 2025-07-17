package patterns.structutral.decorator.example;

public class WindowVerticalScrollBar extends WindowDecorator {

    public WindowVerticalScrollBar(Window window) {
        super(window);
    }

    @Override
    public void displayWindow() {
        System.out.println("showing vertical scroll bar");
        window.displayWindow();
        System.out.println("*****************");
    }

    @Override
    public void setBorder() {
        System.out.println("scroll bar set");
        window.setBorder();
    }
}
