package patterns.structutral.flyweight;

import patterns.structutral.flyweight.operator.CounterTerrorist;
import patterns.structutral.flyweight.operator.Operator;
import patterns.structutral.flyweight.operator.Terrorist;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory{
    private final Map<String, Operator> operatorCache = new HashMap<>();

    //get the object or create one if it does not exist
    public Operator get(String opType) {
        if (operatorCache.containsKey(opType))
            return operatorCache.get(opType);

        Operator operator = switch (opType) {
            case "counterTerrorist" -> new CounterTerrorist();
            case "terrorist" -> new Terrorist();
            default -> throw new IllegalArgumentException("Invalid input : " + opType);
        };

        operatorCache.put(opType, operator);
        return operator;
    }

    public int getNumberOFPlayers() {
        return operatorCache.size();
    }
}
