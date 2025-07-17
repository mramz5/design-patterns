package patterns.structutral.composite.challenge;

public class Professor implements Faculty{
    private String name;
    private int position,officeNumber;

    public Professor(String name, int position, int officeNumber) {
        this.name = name;
        this.position = position;
        this.officeNumber = officeNumber;
    }

    @Override
    public String getDetails() {
        return "professor{"+name+" , "+position+" , "+officeNumber+"}";
    }
}
