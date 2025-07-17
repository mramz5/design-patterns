package patterns.structutral.composite.practice.second;

public class Employee extends Organization {
    private String fName, lName;

    public Employee(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public int getNumberOfEmployees() {
        return 1;
    }

    @Override
    public String toString() {
        return "[fName=" + fName +
                ", lName=" + lName + "]";
    }
}
