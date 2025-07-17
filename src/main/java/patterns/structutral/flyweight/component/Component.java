package patterns.structutral.flyweight.component;

//another abstract flyweight
public abstract class Component {
    private final String name;
    private final String value;

    public Component(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
