package patterns.structutral.composite.practice.first;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode implements INode {
    protected List<INode> children = new ArrayList<>();

    public void addChild(INode node) {
        children.add(node);
    }

    public void deleteChild(INode node) {
        children.remove(node);
    }

    public void deleteChild(int position) {
        children.remove(position);
    }

    public INode getChild(int position) {
        return children.get(position);
    }

    public void showInfo() {
        children.forEach(node -> {
            if (node instanceof Leaf) {
                Leaf leaf=(Leaf) node;
                System.out.println("[#id=" + leaf.getId() + " , " + leaf.getInfo() + "]");
            }
        });
    }
}
