package patterns.structutral.composite.practice.first;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private static List<INode> nodeList;
    private Director(){}
    private static class DirectorHelperClass{private static final Director director=new Director();}

    public static Director getDirector() {
        initialize();
        return DirectorHelperClass.director;
    }

    public static void initialize() {
        AbstractNode root = new Node();
        AbstractNode node2 = new Node();
        AbstractNode node3 = new Node();

        INode leaf1 = new Leaf("leaf1");
        INode leaf2 = new Leaf("leaf2");
        INode leaf3 = new Leaf("leaf3");
        INode leaf4 = new Leaf("leaf4");

        root.addChild(leaf1);
        root.addChild(node2);

        node2.addChild(leaf2);
        node2.addChild(leaf3);
        node2.addChild(node3);

        node3.addChild(leaf4);

        nodeList = new ArrayList<>();

        nodeList.add(root);
        nodeList.add(node2);
        nodeList.add(node3);
    }

    public void callOperation(String methodName, Class<?>[] parametersType) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        Method method = INode.class.getMethod(methodName);
        for (INode node : nodeList)
            method.invoke(node, parametersType);
    }
}
