package patterns.structutral.composite.challenge;

public abstract class Member implements Faculty{
    private String name;
    private int position,officeNumber;

    public Member(String name, int position, int officeNumber) {
        this.name = name;
        this.position = position;
        this.officeNumber = officeNumber;
    }
}
