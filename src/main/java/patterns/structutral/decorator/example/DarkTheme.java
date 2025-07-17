package patterns.structutral.decorator.example;

public class DarkTheme extends WindowDecorator {
    public DarkTheme(Window window) {
        super(window);
    }

    @Override
    public void displayWindow() {
        System.out.println("Dark Theme added");
        window.displayWindow();
    }

    @Override
    public void setBorder() {
        System.out.println("dark border set");
        window.setBorder();
    }
}
