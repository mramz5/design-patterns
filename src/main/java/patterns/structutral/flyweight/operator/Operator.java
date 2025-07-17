package patterns.structutral.flyweight.operator;


import patterns.structutral.flyweight.component.Cloth;
import patterns.structutral.flyweight.component.Component;
import patterns.structutral.flyweight.component.Weapon;

//abstract flyweight
public abstract class Operator {
    //extrinsic states , should be careful that increasing the extrinsic states increase the cost of runtime
    private Component weapon;
    private Component cloth;
    //

    //intrinsic state ,initialized with object creation
    private final String task;

    public Operator(String task) {
        this.task = task;
    }

    public Component getWeapon() {
        return weapon;
    }

    //extrinsic setter method
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public Component getCloth() {
        return cloth;
    }

    public String getTask() {
        return task;
    }
}
