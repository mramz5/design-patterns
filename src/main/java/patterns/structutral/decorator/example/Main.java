package patterns.structutral.decorator.example;

public class Main {
    public static void main(String[] args) {
        // 1 dalil inke decorator child Component hast ine ke ba in mishe dobare az decorator use kard
        // va khod on ro dobare decorate kard

        Window textWindow=new TextWindow();

        Window decoratedTextWindow=new WindowVerticalScrollBar(textWindow);
        decoratedTextWindow.setBorder();
        decoratedTextWindow.displayWindow();

        Window decoratedTextWindow2=new WindowVerticalScrollBar(new DarkTheme(textWindow));
        decoratedTextWindow2.setBorder();
        decoratedTextWindow2.displayWindow();

        //more beautiful
        Window decoratedTW=new DarkTheme(new WindowVerticalScrollBar(new TextWindow()));
        decoratedTW.setBorder();
        decoratedTW.displayWindow();
    }
}
