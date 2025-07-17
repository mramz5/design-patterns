package patterns.structutral.flyweight;

import patterns.structutral.flyweight.component.Cloth;
import patterns.structutral.flyweight.component.Weapon;
import patterns.structutral.flyweight.operator.Operator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        OperatorFactory operatorFactory = new OperatorFactory();

        String[] weapons = {"W1", "W2", "W3", "W4"};
        String[] types = {"counterTerrorist", "terrorist"};
        String[] clothes={"C1","C2","C12","C134","C123","C9137","C311"};
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Operator operator = operatorFactory.get(types[random.nextInt(types.length)]);
            operator.setWeapon(new Weapon(weapons[random.nextInt(weapons.length)]));
            operator.setCloth(new Cloth(clothes[random.nextInt(clothes.length)]));

            System.out.println("Player " + operator.getClass().getSimpleName() + " created with weapon '"
                    + operator.getWeapon() + "' and cloth : '" + operator.getCloth() + "' with task: '" + operator.getTask() + "'");
        }

        System.out.println("Number of operators: " + operatorFactory.getNumberOFPlayers());

    }
}
