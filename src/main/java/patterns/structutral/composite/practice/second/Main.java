package patterns.structutral.composite.practice.second;

public class Main {
    public static void main(String[] args) {
        Director director=Director.getDirector();
        director.loadOrg();
        System.out.println("number of all employees:"+director.numOfAllEmployees());
        System.out.println("After removing third element : "+director.getOrganizations().get(3));
        director.getOrganizations().remove(2);
        System.out.println(director.numOfAllEmployees());
    }
}
