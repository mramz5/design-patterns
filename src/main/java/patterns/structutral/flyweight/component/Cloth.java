package patterns.structutral.flyweight.component;

//another concrete flyweight that does not have any extrinsic state
public class Cloth extends Component {
    public Cloth(String value) {
        super("Cloth", value);
    }
    public void wear(){
        System.out.println("Cloth "+getValue()+" assigned");
    }
}
