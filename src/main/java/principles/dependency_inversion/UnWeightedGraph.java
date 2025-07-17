package principles.dependency_inversion;

import java.util.ArrayList;
import java.util.List;

public class UnWeightedGraph implements Graph {
    private List<?> edges=new ArrayList<>();

    public UnWeightedGraph(List<?> edges) {
        this.edges = edges;
    }
}
