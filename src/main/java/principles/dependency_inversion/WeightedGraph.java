package principles.dependency_inversion;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph implements Graph {
    private Map<Integer,Object> edges=new HashMap<>();

    public <K, V> WeightedGraph(Map<Integer,Object> nodes) {
        this.edges=nodes;
    }
}
