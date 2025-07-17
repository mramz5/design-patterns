package principles.dependency_inversion;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //GraphOp depends on abstraction(Graph) not to implementation
        //we can (change the type of the/add new) implementations without breaking the superclass -> loose coupling
        Graph g1=new WeightedGraph(Collections.singletonMap(3,"Node"));
        GraphsOp.BFS(g1);

    }
}
