package patterns.structutral.composite.practice.second;

public class Department extends AbstractDepartment {
    public Department(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return employees.toString();
    }
}
