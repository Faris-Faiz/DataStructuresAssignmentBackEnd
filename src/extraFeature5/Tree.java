package extraFeature5;

import Q24.Vertex;

public class Tree extends Vertex  {

    public Tree() {
    }

    public Tree(double pointer) {
        super(pointer);
    }

    @Override
    public String toString() {
        return"Tree{" +
                "id=" + id +
                '}';
    }
}
