package patterns.structutral.composite.practice.second;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDepartment extends Organization {
    private String name;
    protected List<Organization> employees = new ArrayList<>();

    public AbstractDepartment(String name) {
        this.name = name;
    }

    @Override
    public int getNumberOfEmployees() {
        return employees.stream()
                .filter(e -> e instanceof Employee)
                .mapToInt(Organization::getNumberOfEmployees)
                .sum();
    }

    public void add(Organization org) {
        employees.add(org);
    }

    public void delete(Organization org) {
        employees.remove(org);
    }
}
