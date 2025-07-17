package patterns.structutral.composite.practice.first;

public class Leaf implements INode {
    private String info;
    private int id;
    private static int idGenerator;

    public Leaf(String info) {
        this.info = info;
        id = ++idGenerator;
    }

    public String getInfo() {
        return info;
    }

    public int getId() {
        return id;
    }

    @Override
    public void showInfo() {
        System.out.print(info);
    }
}
