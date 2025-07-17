package patterns.structutral.composite.practice.second;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private Director(){}
    private static class DirectorHelperClass{private static final Director director=new Director();}

    public static Director getDirector() {
        return DirectorHelperClass.director;
    }
    private List<Organization> organizations;

    public void loadOrg(){
        AbstractDepartment hr=new Department("hr");
        AbstractDepartment qa=new Department("qa");
        AbstractDepartment dev=new Department("dev");

        Organization emp1=new Employee("ali","zamani");
        Organization emp2=new Employee("ahmad","mohammadi");
        Organization emp3=new Employee("Abbas","abbasi");
        Organization emp4=new Employee("hossein","hosseini");
        Organization emp5=new Employee("hassan","hassan-ali");
        Organization emp6=new Employee("Mohsen","imami");

        organizations=new ArrayList<>();

        organizations.add(emp1);
        organizations.add(hr);
        hr.add(emp2);
        organizations.add(qa);
        qa.add(emp3);
        qa.add(emp4);
        hr.add(qa);
        hr.add(dev);
        organizations.add(dev);
        dev.add(emp5);
        dev.add(emp6);

    }

    public int numOfAllEmployees(){
        return organizations.stream().mapToInt(Organization::getNumberOfEmployees).sum();
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }
}
