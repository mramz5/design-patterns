package patterns.structutral.composite.practice.first;

public class Main {
    public static void main(String[] args) {
        try {
            Director.getDirector().callOperation("showInfo",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
