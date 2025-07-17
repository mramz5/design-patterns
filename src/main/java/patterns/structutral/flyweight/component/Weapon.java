package patterns.structutral.flyweight.component;

//another concrete flyweight that does not have any extrinsic state
public class Weapon extends Component {
    public Weapon(String value) {
        super("Weapon", value);
    }
    public void fire(){
        System.out.println(getValue()+"is Firing");
    }
}
